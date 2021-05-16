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

    @GET("/v1/custody/transactions_by_id/")
    Call<Response<List<Transaction>>> getTransactionsById(@Query("coin") String coin, @Query("side") String side,
                                                          @Query("address") String address, @Query("max_id") String max_id,
                                                          @Query("min_id") String min_id, @Query("limit") int limit, @Query("include_financial") String include_financial);

    @GET("/v1/custody/transactions_by_time/")
    Call<Response<List<Transaction>>> getTransactionsByTime(@Query("coin") String coin, @Query("side") String side,
                                                            @Query("address") String address, @Query("begin_time") long beginTime,
                                                            @Query("end_time") long endTime, @Query("limit") int limit, @Query("include_financial") String include_financial);

    @GET("/v1/custody/pending_transactions/")
    Call<Response<List<Transaction>>> getPendingTransactions(@Query("coin") String coin, @Query("side") String side,
                                                             @Query("max_id") String max_id,
                                                             @Query("min_id") String min_id, @Query("limit") int limit);

    @GET("/v1/custody/pending_transaction/")
    Call<Response<Transaction>> getPendingTransaction(@Query("id") String id);

    @GET("/v1/custody/transaction_history/")
    Call<Response<List<Transaction>>> getTransactionHistory(@Query("coin") String coin, @Query("side") String side,
                                                            @Query("address") String address, @Query("max_id") String max_id,
                                                            @Query("min_id") String min_id, @Query("limit") int limit, @Query("begin_time") long beginTime,
                                                            @Query("end_time") long endTime, @Query("include_financial") String include_financial);
}
