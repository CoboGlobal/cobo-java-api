package com.cobo.custody.api.client.security;

import com.cobo.custody.api.client.ApiSigner;
import com.cobo.custody.api.client.constant.CoboApiConstants;
import com.cobo.custody.api.client.impl.LocalSigner;
import okhttp3.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/**
 * A request interceptor that injects the API Key Header into requests, and signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

    private final String apiKey;

    private final ApiSigner signer;

    private final String coboPubKey;

    private final boolean debug;

    public AuthenticationInterceptor(ApiSigner signer, String coboPubKey, boolean debug) {
        this.apiKey = signer.getPublicKey();
        this.signer = signer;
        this.coboPubKey = coboPubKey;
        this.debug = debug;
    }

    /**
     * Extracts the request body into a String.
     *
     * @return request body as a string
     */

    private static String bodyToSortedString(RequestBody body) throws UnsupportedEncodingException {
        if (body instanceof FormBody) {
            FormBody newBody = (FormBody) body;
            TreeMap<String, Object> map = new TreeMap<>();
            for (int i = 0; i < newBody.size(); i++) {
                map.put(newBody.encodedName(i), URLDecoder.decode(newBody.encodedValue(i), "UTF-8"));
            }

            return composeParams(map);
        }
        throw new IllegalArgumentException("Unsupported request body");

    }

    private static String composeParams(TreeMap<String, Object> params) {
        StringBuffer sb = new StringBuffer();
        params.forEach((s, o) -> {
            try {
                sb.append(s).append("=").append(URLEncoder.encode(String.valueOf(o), "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        Request newRequest = addHeader(original, newRequestBuilder);
        Response response = chain.proceed(newRequest);
        String ts = response.header(CoboApiConstants.BIZ_TIMESTAMP);
        String respSignature = response.header(CoboApiConstants.BIZ_RESP_SIGNATURE);
        String responseBody = response.body() == null ? "null" : response.body().string();

        if (debug) {
            System.out.println("response <<<<<<<<");
            System.out.println("responseBody:" + responseBody
                    + "\nrespSignature:" + respSignature + "\nts:" + ts);
        }
        boolean verifyResult = LocalSigner.verifyEcdsaSignature(responseBody + "|" + ts, respSignature, coboPubKey);
        if (!verifyResult) throw new RuntimeException("response verify failed");
        MediaType mediaType = response.body().contentType();
        return response.newBuilder()
                .body(ResponseBody.create(mediaType, responseBody))
                .build();
    }

    private Request addHeader(Request original, Request.Builder newRequestBuilder) throws UnsupportedEncodingException {
        //HTTP_METHOD + | + HTTP_REQUEST_PATH + | + TIMESTAMP + | + PARAMS
        //POST|/v1/custody/test/|1537498830736|amount=100.0&price=100.0&side=buy&symbol=btcusdt&type=limit
        String method = original.method();
        String path = pathSegmentsToString(original.url().pathSegments());
        String body;
        if ("GET".equals(method)) {
            HttpUrl url = original.url();
            Set<String> names = url.queryParameterNames();
            TreeMap<String, Object> params = new TreeMap<>();
            for (String name : names) {
                params.put(name, url.queryParameter(name));
            }
            body = composeParams(params);
        } else if ("POST".equals(method)) {
            body = bodyToSortedString(original.body());
        } else {
            throw new RuntimeException("not supported http method");
        }
        String nonce = String.valueOf(System.currentTimeMillis());
        String content = method + "|" + path + "|" + nonce + "|" + body;
        String sig = signer.sign(content.getBytes());

        newRequestBuilder.addHeader(CoboApiConstants.BIZ_API_KEY, apiKey)
                .addHeader(CoboApiConstants.BIZ_API_NONCE, nonce)
                .addHeader(CoboApiConstants.BIZ_API_SIGNATURE, sig);

        // Build new request after adding the necessary authentication information
        Request request = newRequestBuilder.build();
        if (debug) {
            System.out.println("request >>>>>>>>");
            System.out.println(request.method() + "\n" + request.url() + "\n" + "content:" + content + "\nsig:" + sig + "\nnonce:" + nonce);
        }
        return request;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AuthenticationInterceptor that = (AuthenticationInterceptor) o;
        return Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(signer, that.signer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, signer);
    }

    String pathSegmentsToString(List<String> pathSegments) {
        StringBuilder out = new StringBuilder();
        for (String pathSegment : pathSegments) {
            out.append('/');
            out.append(pathSegment);
        }
        return out.toString();
    }
}