package com.cobo.api.client;

import com.cobo.api.client.impl.CoboApiRestClientImpl;

public class CoboApiClientFactory {

    private String apiKey = "0397ef0d81938bcf9587466ee33ab93caa77677416ada3297e70e92aa42245d99e";
    private String apiSecret = "e7e73fabdd9edb8bddf947954c400a63bf93edc57abf170544ec570757df5453";
    private String coboPub = "032f45930f652d72e0c90f71869dfe9af7d713b1f67dc2f7cb51f9572778b9c876";

    private CoboApiClientFactory(String apiKey, String apiSecret) {
        //this.apiKey = apiKey;
        //this.apiSecret = apiSecret;
    }

    public static CoboApiClientFactory newInstance(String apiKey, String apiSecret) {
        return new CoboApiClientFactory(apiKey, apiSecret);
    }

    public CoboApiRestClient newRestClient() {
        return new CoboApiRestClientImpl(apiKey, apiSecret, coboPub);
    }
}
