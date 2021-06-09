package com.cobo.api.client;

import com.cobo.api.client.impl.CoboApiRestClientImpl;

public class CoboApiClientFactory {

    private final String apiKey;
    private final ApiSigner signer;
    private final String coboPub;
    private final String host;

    private CoboApiClientFactory(String apiKey, ApiSigner signer, String coboPub, String host) {
        this.apiKey = apiKey;
        this.signer = signer;
        this.coboPub = coboPub;
        this.host = host;
    }

    public static CoboApiClientFactory newInstance(String apiKey, ApiSigner signer, String coboPub, String host) {
        return new CoboApiClientFactory(apiKey, signer, coboPub, host);
    }

    public CoboApiRestClient newRestClient() {
        return new CoboApiRestClientImpl(apiKey, signer, coboPub, host);
    }
}
