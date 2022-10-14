package com.cobo.custody.api.client;

import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.impl.CoboApiRestClientImpl;
import com.cobo.custody.api.client.impl.CoboWeb3ApiRestClientImpl;

public class CoboApiClientFactory {

    private final Env env;
    private final ApiSigner signer;
    private final boolean debug;

    private CoboApiClientFactory(ApiSigner signer, Env env, boolean debug) {
        this.signer = signer;
        this.env = env;
        this.debug = debug;

    }

    public static CoboApiClientFactory newInstance(ApiSigner signer, Env env, boolean debug) {
        return new CoboApiClientFactory(signer, env, debug);
    }

    public CoboApiRestClient newRestClient() {
        return new CoboApiRestClientImpl(signer, env, debug);
    }

    public CoboWeb3ApiRestClient newWeb3RestClient() {
        return new CoboWeb3ApiRestClientImpl(signer, env, debug);
    }
}
