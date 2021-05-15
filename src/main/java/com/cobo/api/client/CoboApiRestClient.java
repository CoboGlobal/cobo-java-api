package com.cobo.api.client;

import com.cobo.api.client.domain.CoinInfo;
import com.cobo.api.client.domain.Response;
import com.cobo.api.client.domain.OrgInfo;

public interface CoboApiRestClient {
    Response<OrgInfo> getOrgInfo();
    Response<CoinInfo> getCoinInfo(String coin);
}
