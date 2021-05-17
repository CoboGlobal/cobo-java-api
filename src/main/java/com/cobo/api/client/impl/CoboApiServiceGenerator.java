package com.cobo.api.client.impl;

import com.cobo.api.client.ApiSigner;
import com.cobo.api.client.CoboApiError;
import com.cobo.api.client.config.CoboApiConfig;
import com.cobo.api.client.domain.ApiResponse;
import com.cobo.api.client.exception.CoboApiException;
import com.cobo.api.client.security.AuthenticationInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

/**
 * Generates a Cobo API implementation based on @see {@link CoboApiService}.
 */
public class CoboApiServiceGenerator {

    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, CoboApiError> errorBodyConverter =
            (Converter<ResponseBody, CoboApiError>) converterFactory.responseBodyConverter(
                    CoboApiError.class, new Annotation[0], null);

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();
    }

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null, null);
    }

    public static <S> S createService(Class<S> serviceClass, String apiKey, ApiSigner signer, String coboPub) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(CoboApiConfig.getApiBaseUrl())
                .addConverterFactory(converterFactory);

        if (StringUtils.isEmpty(apiKey) || signer == null || StringUtils.isEmpty(coboPub)) {
            retrofitBuilder.client(sharedClient);
        } else {
            // `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent' client
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, signer, coboPub);
            OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor(interceptor).build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                CoboApiError apiError = getCoboApiError(response);
                return (T) new ApiResponse<>(
                        null, false, apiError.getError_code(),
                        apiError.getError_message(), apiError.getError_id(),
                        apiError.getError_message()
                );
            }
        } catch (IOException e) {
            throw new CoboApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static CoboApiError getCoboApiError(Response<?> response) throws IOException, CoboApiException {
        //System.out.println(response.errorBody().string());
        ResponseBody errorBody = response.errorBody();
        //System.out.println(errorBody.string());
        ObjectMapper mapper = new ObjectMapper();
        String s = errorBody.string();
        return mapper.readValue(s, CoboApiError.class);
    }

    /**
     * Returns the shared OkHttpClient instance.
     */
    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}
