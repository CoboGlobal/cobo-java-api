package com.cobo.api.client.impl;

import com.cobo.api.client.domain.CoinInfo;
import com.cobo.api.client.domain.Response;
import com.cobo.api.client.domain.OrgInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoboApiService {
    @GET("/v1/custody/org_info/")
    Call<Response<OrgInfo>> getOrgInfo();

    @GET("/v1/custody/coin_info111/")
    Call<Response<CoinInfo>> getCoinInfo(@Query("coin") String coin);
}
