package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.MPCAddresses;
import com.cobo.custody.api.client.domain.account.MPCChains;
import com.cobo.custody.api.client.domain.account.MPCCoins;
import com.cobo.custody.api.client.domain.account.OrgInfo;
import com.cobo.custody.api.client.domain.asset.MPCWalletAsset;
import com.cobo.custody.api.client.domain.transaction.MPCTransaction;
import com.cobo.custody.api.client.domain.transaction.MPCTransactionInfo;
import com.cobo.custody.api.client.domain.transaction.MPCTransactions;
import retrofit2.Call;
import retrofit2.http.*;

import java.math.BigInteger;

public interface CoboMPCApiService {
    @GET("/v1/custody/mpc/org_info/")
    Call<ApiResponse<OrgInfo>> getOrgInfo();
    @GET("/v1/custody/mpc/get_supported_chains/")
    Call<ApiResponse<MPCChains>> getSupportedChains();

    @GET("/v1/custody/mpc/get_supported_coins/")
    Call<ApiResponse<MPCCoins>> getSupportedCoins(@Query("chain_code") String chainCode);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/generate_new_addresses/")
    Call<ApiResponse<MPCAddresses>> batchGenerateNewAddresses(@Field("chain_code") String chainCode,
                                                    @Field("count") int count);

    @GET("/v1/custody/mpc/list_addresses/")
    Call<ApiResponse<MPCAddresses>> getAddressList(@Query("chain_code") String chainCode,
                                                   @Query("page_index") int pageIndex,
                                                   @Query("page_length") int pageLength,
                                                   @Query("sort_flag") int sortFlag);

    @GET("/v1/custody/mpc/list_assets/")
    Call<ApiResponse<MPCWalletAsset>> getWalletAssetList(@Query("address") String address,
                                                         @Query("chain_code") String chainCode);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/create_transaction/")
    Call<ApiResponse<Void>> createTransaction(@Field("coin") String coin,
                                                        @Field("request_id") String requestId,
                                                        @Field("from_address") String fromAddr,
                                                        @Field("to_address") String toAddr,
                                                        @Field("amount") BigInteger amount);

    @GET("/v1/custody/mpc/transaction_info/")
    Call<ApiResponse<MPCTransactionInfo>> getTransaction(@Query("request_id") String requestId);

    @GET("/v1/custody/mpc/transaction_info_by_tx_id/")
    Call<ApiResponse<MPCTransactionInfo>> getTransactionByTxId(@Query("tx_id") String txId);

    @GET("/v1/custody/mpc/list_transactions/")
    Call<ApiResponse<MPCTransactions>> listWalletTransactions(@Query("address") String address,
                                                              @Query("coin") String coin,
                                                              @Query("max_id") String maxId,
                                                              @Query("min_id") String minId,
                                                              @Query("limit") int limit);

}
