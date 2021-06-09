package com.cobo.api.client.config;

public class CoboApiConfig {
    public static String getApiBaseUrl(Env env) {
        if (env == Env.SANDBOX) {
            return "https://api.sandbox.cobo.com";
        }else if (env == Env.PROD) {
            return "https://api.custody.cobo.com";
        }

        throw new IllegalArgumentException("invalid env");
    }
}