package com.cobo.api.client.impl;

import com.cobo.api.client.CoboApiRestClient;
import com.cobo.api.client.domain.CoinInfo;
import com.cobo.api.client.domain.Response;
import com.cobo.api.client.domain.OrgInfo;

import static com.cobo.api.client.impl.CoboApiServiceGenerator.createService;
import static com.cobo.api.client.impl.CoboApiServiceGenerator.executeSync;

public class CoboApiRestClientImpl implements CoboApiRestClient {
    private final CoboApiService coboApiService;

    public CoboApiRestClientImpl(String apiKey, String secret, String coboPub) {
        coboApiService = createService(CoboApiService.class, apiKey, secret, coboPub);
    }
    @Override
    public Response<OrgInfo> getOrgInfo() {
        return executeSync(coboApiService.getOrgInfo());
    }

    @Override
    public Response<CoinInfo> getCoinInfo(String coin) {
        return executeSync(coboApiService.getCoinInfo(coin));
    }
}
