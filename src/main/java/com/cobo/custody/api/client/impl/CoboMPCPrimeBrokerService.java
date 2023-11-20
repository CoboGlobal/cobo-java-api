package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface CoboMPCPrimeBrokerService {
    @FormUrlEncoded
    @POST("/v1/custody/guards/create_binding/")
    Call<ApiResponse<PrimeBrokerBinderInfo>> createBinding(@Field("user_id") String userId);

    @GET("/v1/custody/guards/query_binding/")
    Call<ApiResponse<PrimeBrokerUserBindInfo>> queryBinding(@Query("binder_id") String binderId);

    @GET("/v1/custody/guards/query_user_auth/")
    Call<ApiResponse<PrimeBrokerUserAuthInfo>> queryUserAuth(@Query("user_id") String userId);

    @FormUrlEncoded
    @POST("/v1/custody/guards/bind_addresses/")
    Call<ApiResponse<PrimeBrokerUserAuthInfo>> bindAddresses(@Field("user_id") String userId, @Field("addresses") String addresses);

    @FormUrlEncoded
    @POST("/v1/custody/guards/change_binding/")
    Call<ApiResponse<PrimeBrokerBinderInfo>> changeBinding(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("/v1/custody/guards/unbind_binding/")
    Call<ApiResponse<StatementId>> unbindBinding(@Field("user_id") String userId);

    @GET("/v1/custody/guards/query_statement/")
    Call<ApiResponse<Statement>> queryStatement(@Query("statement_id") String statementId);
}
