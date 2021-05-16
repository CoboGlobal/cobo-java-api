package com.cobo.api.client.impl;

import com.cobo.api.client.domain.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CoboApiService {
    @GET("/v1/custody/org_info/")
    Call<Response<OrgInfo>> getOrgInfo();

    @GET("/v1/custody/coin_info/")
    Call<Response<CoinInfo>> getCoinInfo(@Query("coin") String coin);

    @FormUrlEncoded
    @POST("/v1/custody/new_address/")
    Call<Response<Address>> newAddress(@Field("coin") String coin,
                                       @Field("native_segwit") boolean native_segwit);

    @FormUrlEncoded
    @POST("/v1/custody/new_address/")
    Call<Response<Address>> newAddress(@Field("coin") String coin);

    @FormUrlEncoded
    @POST("/v1/custody/new_addresses/")
    Call<Response<NewAddresses>> newAddresses(@Field("coin") String coin,
                                              @Field("count") int count,
                                              @Field("native_segwit") boolean native_segwit);

    @FormUrlEncoded
    @POST("/v1/custody/new_addresses/")
    Call<Response<NewAddresses>> newAddresses(@Field("coin") String coin,
                                              @Field("count") int count);

    @GET("/v1/custody/address_info/")
    Call<Response<Address>> addressInfo(@Query("coin") String coin, @Query("address") String address);

    @GET("/v1/custody/addresses_info/")
    Call<Response<Addresses>> addressesInfo(@Query("coin") String coin, @Query("address") String addresses);

    @GET("/v1/custody/is_valid_address/")
    Call<Response<Boolean>> isValidAddress(@Query("coin") String coin, @Query("address") String address);

    @GET("/v1/custody/address_history/")
    Call<Response<List<Address>>> getAddressHistory(@Query("coin") String coin);

    @GET("/v1/custody/internal_address_info/")
    Call<Response<InternalAddressInfo>> getInternalAddressInfo(@Query("coin") String coin, @Query("address") String address);

    @GET("/v1/custody/internal_address_info_batch/")
    Call<Response<List<InternalAddressInfo>>> getInternalAddressInfoBatch(@Query("coin") String coin, @Query("address") String address);

    @GET("/v1/custody/transaction/")
    Call<Response<Transaction>> getTransaction(@Query("id") String id);

//    @GET("/v1/custody/transactions_by_id/")
//     Call<>
}
