package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.MPCNftCollections;
import com.cobo.custody.api.client.domain.transaction.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface CoboMPCApiService {
    @GET("/v1/custody/mpc/get_supported_chains/")
    Call<ApiResponse<MPCChains>> getSupportedChains();

    @GET("/v1/custody/mpc/get_supported_coins/")
    Call<ApiResponse<MPCCoins>> getSupportedCoins(@Query("chain_code") String chainCode);

    @GET("/v1/custody/mpc/get_supported_nft_collections/")
    Call<ApiResponse<MPCNftCollections>> getSupportedNftCollections(@Query("chain_code") String chainCode);

    @GET("/v1/custody/mpc/get_wallet_supported_coins/")
    Call<ApiResponse<MPCWalletCoins>> getWalletSupportedCoins();

    @GET("/v1/custody/mpc/is_valid_address/")
    Call<ApiResponse<Boolean>> isValidAddress(@Query("coin") String coin,
                                              @Query("address") String address);

    @GET("/v1/custody/mpc/get_main_address/")
    Call<ApiResponse<MPCAddressList>> getMainAddress(@Query("chain_code") String chainCode);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/generate_addresses/")
    Call<ApiResponse<MPCAddressList>> generateAddresses(@Field("chain_code") String chainCode,
                                                             @Field("count") int count);

    @GET("/v1/custody/mpc/list_addresses/")
    Call<ApiResponse<MPCAddresses>> listAddresses(@Query("chain_code") String chainCode,
                                                   @Query("start_id") String startId,
                                                   @Query("end_id") String endId,
                                                   @Query("limit") Integer limit,
                                                   @Query("sort") Integer sort);

    @GET("/v1/custody/mpc/get_balance/")
    Call<ApiResponse<MPCBalance>> getBalance(@Query("address") String address,
                                             @Query("chain_code") String chainCode,
                                             @Query("coin") String coin);

    @GET("/v1/custody/mpc/list_balances/")
    Call<ApiResponse<MPCListBalances>> listBalances(@Query("coin") String coin,
                                                    @Query("page_index") Integer pageIndex,
                                                    @Query("page_length") Integer pageLength,
                                                    @Query("chain_code") String chainCode);

    @GET("/v1/custody/mpc/list_spendable/")
    Call<ApiResponse<MPCListSpendable>> listSpendable(@Query("coin") String coin,
                                                      @Query("address") String address);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/create_transaction/")
    Call<ApiResponse<MPCPostTransaction>> createTransaction(@Field("coin") String coin,
                                                            @Field("request_id") String requestId,
                                                            @Field("amount") BigInteger amount,
                                                            @Field("from_address") String fromAddr,
                                                            @Field("to_address") String toAddr,
                                                            @Field("to_address_details") String toAddressDetails,
                                                            @Field("fee") BigDecimal fee,
                                                            @Field("gas_price") BigInteger gasPrice,
                                                            @Field("gas_limit") BigInteger gasLimit,
                                                            @Field("operation") Integer operation,
                                                            @Field("extra_parameters") String extraParameters,
                                                            @Field("max_fee") BigInteger maxFee,
                                                            @Field("max_priority_fee") BigInteger maxPriorityFee,
                                                            @Field("fee_amount") BigInteger feeAmount);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/sign_message/")
    Call<ApiResponse<MPCPostTransaction>> signMessage(@Field("chain_code") String chainCode,
                                                       @Field("request_id") String requestId,
                                                       @Field("from_address") String fromAddr,
                                                       @Field("sign_version") Integer signVersion,
                                                       @Field("extra_parameters") String extraParameters);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/speedup_transaction/")
    Call<ApiResponse<MPCPostTransaction>> speedUpTransaction(@Field("cobo_id") String coboId,
                                                             @Field("request_id") String requestId,
                                                             @Field("fee") BigDecimal fee,
                                                             @Field("gas_price") BigInteger gasPrice,
                                                             @Field("gas_limit") BigInteger gasLimit,
                                                             @Field("fee_amount") BigInteger feeAmount);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/drop_transaction/")
    Call<ApiResponse<MPCPostTransaction>> dropTransaction(@Field("cobo_id") String coboId,
                                                          @Field("request_id") String requestId,
                                                          @Field("fee") BigDecimal fee,
                                                          @Field("gas_price") BigInteger gasPrice,
                                                          @Field("gas_limit") BigInteger gasLimit,
                                                          @Field("fee_amount") BigInteger feeAmount);

    @GET("/v1/custody/mpc/transactions_by_request_ids/")
    Call<ApiResponse<MPCTransactionInfos>> transactionsByRequestIds(@Query("request_ids") String requestIds,
                                                                       @Query("status") Integer status);

    @GET("/v1/custody/mpc/transactions_by_cobo_ids/")
    Call<ApiResponse<MPCTransactionInfos>> transactionsByCoboIds(@Query("cobo_ids") String coboIds,
                                                                    @Query("status") Integer status);

    @GET("/v1/custody/mpc/transactions_by_tx_hash/")
    Call<ApiResponse<MPCTransactionInfos>> transactionsByTxhash(@Query("tx_hash") String txHash,
                                                                  @Query("transaction_type") Integer transactionType);

    @GET("/v1/custody/mpc/list_transactions/")
    Call<ApiResponse<MPCTransactions>> listTransactions(@Query("start_time") Long startTime,
                                                              @Query("end_time") Long endTime,
                                                              @Query("status") Integer status,
                                                              @Query("order_by") String orderBy,
                                                              @Query("order") String order,
                                                              @Query("transaction_type") Integer transactionType,
                                                              @Query("coins") String coins,
                                                              @Query("from_address") String fromAddress,
                                                              @Query("to_address") String toAddress,
                                                              @Query("limit") Integer limit);

    @GET("/v1/custody/mpc/estimate_fee/")
    Call<ApiResponse<EstimateFeeDetails>> estimateFee(@Query("coin") String coin,
                                                      @Query("amount") BigInteger amount,
                                                      @Query("address") String address,
                                                      @Query("replace_cobo_id") String replaceCoboId,
                                                      @Query("from_address") String fromAddress,
                                                      @Query("to_address_details") String toAddressDetails,
                                                      @Query("fee") BigDecimal fee,
                                                      @Query("gas_price") BigInteger gasPrice,
                                                      @Query("gas_limit") BigInteger gasLimit,
                                                      @Query("extra_parameters") String extraParameters);

    @GET("/v1/custody/mpc/list_tss_node_requests/")
    Call<ApiResponse<MPCTssNodeRequests>> listTssNodeRequests(@Query("request_type") Integer requestType,
                                                              @Query("status") Integer status);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/retry_double_check/")
    Call<ApiResponse<Void>> retryDoubleCheck(@Field("request_id") String requestId);
}
