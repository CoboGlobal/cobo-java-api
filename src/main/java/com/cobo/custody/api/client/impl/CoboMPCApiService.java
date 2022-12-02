package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.MPCUnspentInputs;
import com.cobo.custody.api.client.domain.asset.MPCWalletAsset;
import com.cobo.custody.api.client.domain.transaction.MPCPostTransaction;
import com.cobo.custody.api.client.domain.transaction.MPCTransactionInfos;
import com.cobo.custody.api.client.domain.transaction.MPCTransactions;
import retrofit2.Call;
import retrofit2.http.*;

import java.math.BigInteger;

public interface CoboMPCApiService {
    @GET("/v1/custody/mpc/get_supported_chains/")
    Call<ApiResponse<MPCChains>> getSupportedChains();

    @GET("/v1/custody/mpc/get_supported_coins/")
    Call<ApiResponse<MPCCoins>> getSupportedCoins(@Query("chain_code") String chainCode);

    @GET("/v1/custody/mpc/get_main_address/")
    Call<ApiResponse<MPCAddressList>> getMainAddress(@Query("chain_code") String chainCode);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/generate_addresses/")
    Call<ApiResponse<MPCAddressList>> batchGenerateAddresses(@Field("chain_code") String chainCode,
                                                             @Field("count") int count);

    @GET("/v1/custody/mpc/list_addresses/")
    Call<ApiResponse<MPCAddresses>> getAddressList(@Query("chain_code") String chainCode,
                                                   @Query("page_index") int pageIndex,
                                                   @Query("page_length") int pageLength,
                                                   @Query("sort_flag") Integer sortFlag);

    @GET("/v1/custody/mpc/list_assets/")
    Call<ApiResponse<MPCWalletAsset>> getWalletAssetList(@Query("address") String address,
                                                         @Query("chain_code") String chainCode);

    @GET("/v1/custody/mpc/list_unspent_inputs/")
    Call<ApiResponse<MPCUnspentInputs>> getWalletUnspentInputList(@Query("address") String address,
                                                                  @Query("coin") String coin);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/create_transaction/")
    Call<ApiResponse<MPCPostTransaction>> createTransaction(@Field("coin") String coin,
                                                            @Field("request_id") String requestId,
                                                            @Field("from_address") String fromAddr,
                                                            @Field("to_address") String toAddr,
                                                            @Field("amount") BigInteger amount,
                                                            @Field("to_address_details") String toAddressDetails,
                                                            @Field("fee") BigInteger fee,
                                                            @Field("gas_price") BigInteger gasPrice,
                                                            @Field("gas_limit") BigInteger gasLimit,
                                                            @Field("extra_parameters") String extraParameters);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/speedup_transaction/")
    Call<ApiResponse<MPCPostTransaction>> speedUpTransaction(@Field("cobo_id") String coboId,
                                                          @Field("gas_price") BigInteger gasPrice,
                                                          @Field("gas_limit") BigInteger gasLimit);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/drop_transaction/")
    Call<ApiResponse<MPCPostTransaction>> dropTransaction(@Field("cobo_id") String coboId,
                                                          @Field("gas_price") BigInteger gasPrice,
                                                          @Field("gas_limit") BigInteger gasLimit);

    @GET("/v1/custody/mpc/transactions_by_request_ids/")
    Call<ApiResponse<MPCTransactionInfos>> getTransactionsByRequestIds(@Query("request_ids") String requestIds,
                                                                   @Query("status") Integer status);

    @GET("/v1/custody/mpc/transactions_by_cobo_ids/")
    Call<ApiResponse<MPCTransactionInfos>> getTransactionsByCoboIds(@Query("cobo_ids") String coboIds,
                                                                @Query("status") Integer status);

    @GET("/v1/custody/mpc/transactions_by_tx_hash/")
    Call<ApiResponse<MPCTransactionInfos>> getTransactionByTxhash(@Query("tx_hash") String txHash,
                                                                  @Query("transaction_type") Integer transactionType);

    @GET("/v1/custody/mpc/list_transactions/")
    Call<ApiResponse<MPCTransactions>> listWalletTransactions(@Query("start_time") Integer startTime,
                                                              @Query("end_time") Integer endTime,
                                                              @Query("status") Integer status,
                                                              @Query("order") String order,
                                                              @Query("transaction_type") Integer transactionType,
                                                              @Query("coins") String coins,
                                                              @Query("from_address") String fromAddress,
                                                              @Query("to_address") String toAddress,
                                                              @Query("limit") Integer limit);
}
