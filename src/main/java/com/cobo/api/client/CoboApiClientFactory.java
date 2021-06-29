package com.cobo.api.client;

import com.cobo.api.client.config.Env;
import com.cobo.api.client.impl.CoboApiRestClientImpl;

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
}
