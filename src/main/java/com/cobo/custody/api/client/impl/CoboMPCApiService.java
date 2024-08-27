package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.MPCNftCollections;
import com.cobo.custody.api.client.domain.transaction.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface CoboMPCApiService {
    @GET("/v1/custody/mpc/get_supported_chains/")
    Call<ApiResponse<MPCChains>> getSupportedChains();

    @GET("/v1/custody/mpc/get_supported_coins/")
    Call<ApiResponse<MPCCoins>> getSupportedCoins(@Query("chain_code") String chainCode);

    @GET("/v1/custody/mpc/get_supported_nft_collections/")
    Call<ApiResponse<MPCNftCollections>> getSupportedNftCollections(@Query("chain_code") String chainCode);

    @GET("/v1/custody/mpc/get_wallet_supported_coins/")
    Call<ApiResponse<MPCWalletCoins>> getWalletSupportedCoins();

    @GET("/v1/custody/mpc/coin_info/")
    Call<ApiResponse<CoinInfo>> getCoinInfo(@Query("coin") String coin);

    @GET("/v1/custody/mpc/is_valid_address/")
    Call<ApiResponse<Boolean>> isValidAddress(@Query("coin") String coin,
                                              @Query("address") String address);

    @GET("/v1/custody/mpc/get_main_address/")
    Call<ApiResponse<MPCAddressList>> getMainAddress(@Query("chain_code") String chainCode);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/generate_addresses/")
    Call<ApiResponse<MPCAddressList>> generateAddresses(@Field("chain_code") String chainCode,
                                                             @Field("count") int count, @Field("encoding") Integer encoding);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/generate_address_memo/")
    Call<ApiResponse<MPCMemoAddressList>> generateAddressMemo(@Field("chain_code") String chainCode,
                                                        @Field("address") String address,
                                                        @Field("count") int count);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/update_address_description/")
    Call<ApiResponse<MPCAddress>> updateAddressDescription(@Field("coin") String coin,
                                                        @Field("address") String address,
                                                        @Field("description") String description);

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
                                                            @Field("fee_amount") BigInteger feeAmount,
                                                            @Field("remark") String remark,
                                                            @Field("auto_fuel") int autoFuel,
                                                            @Field("memo") String memo);

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
                                                             @Field("fee_amount") BigInteger feeAmount,
                                                             @Field("auto_fuel") int autoFuel,
                                                             @Field("extra_parameters") String extraParameters);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/drop_transaction/")
    Call<ApiResponse<MPCPostTransaction>> dropTransaction(@Field("cobo_id") String coboId,
                                                          @Field("request_id") String requestId,
                                                          @Field("fee") BigDecimal fee,
                                                          @Field("gas_price") BigInteger gasPrice,
                                                          @Field("gas_limit") BigInteger gasLimit,
                                                          @Field("fee_amount") BigInteger feeAmount,
                                                          @Field("auto_fuel") int autoFuel,
                                                          @Field("extra_parameters") String extraParameters);

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

    @GET("/v1/custody/mpc/list_tss_node/")
    Call<ApiResponse<TssNodes>> listTssNodes();

    @GET("/v1/custody/mpc/sign_messages_by_request_ids/")
    Call<ApiResponse<SignMessages>> signMessageByRequestIds(@Query("request_ids") String requestIds);

    @GET("/v1/custody/mpc/sign_messages_by_cobo_ids/")
    Call<ApiResponse<SignMessages>> signMessageByCoboIds(@Query("cobo_ids") String coboIds);

    @GET("/v1/custody/mpc/get_max_send_amount/")
    Call<ApiResponse<GetSendMaxDetail>> getMaxSendAmount(@Query("coin") String coin, @Query("fee_rate") BigDecimal feeRate, @Query("to_address") String to_address, @Query("from_address") String from_address);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/lock_spendable/")
    Call<ApiResponse<LockSpendableDetail>> lockSpendable(@Field("coin") String coin, @Field("tx_hash") String txHash, @Field("vout_n") Integer voutN);


    @FormUrlEncoded
    @POST("/v1/custody/mpc/unlock_spendable/")
    Call<ApiResponse<LockSpendableDetail>> unlockSpendable(@Field("coin") String coin, @Field("tx_hash") String txHash, @Field("vout_n") Integer voutN);

    @GET("/v1/custody/mpc/get_rare_satoshis/")
    Call<ApiResponse<GetSatoshisDetails>> getRareSatoshis(@Query("coin") String coin, @Query("tx_hash") String txHash, @Query("vout_n") Integer voutN);

    @GET("/v1/custody/mpc/get_utxo_assets/")
    Call<ApiResponse<MPCUTXOAssetInfo>> getUTXOAssets(@Query("coin") String coin, @Query("tx_hash") String txHash, @Query("vout_n") Integer voutN);

    @GET("/v1/custody/mpc/get_ordinals_inscription/")
    Call<ApiResponse<OrdinalsInscriptionContent>> getOrdinalsInscription(@Query("inscription_id") String inscriptionId);

    @GET("/v1/custody/mpc/get_approval_details/")
    Call<ApiResponse<ApprovalDetails>> getApprovalDetails(@Query("request_id") String requestId);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/babylon/prepare_staking/")
    Call<ApiResponse<Void>> babylonPrepareStaking(@Field("request_id") String requestId, @Field("stake_info") String stakeInfo, @Field("fee_rate") BigDecimal feeRate, @Field("max_staking_fee") BigInteger maxStakingFee);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/babylon/replace_staking_fee/")
    Call<ApiResponse<Void>> babylonReplaceStakingFee(@Field("request_id") String requestId, @Field("related_request_id") String relatedRequestId, @Field("fee_rate") BigDecimal feeRate, @Field("max_staking_fee") BigInteger maxStakingFee);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/babylon/drop_staking/")
    Call<ApiResponse<Void>> babylonDropStaking(@Field("request_id") String requestId, @Field("related_request_id") String relatedRequestId, @Field("fee_rate") BigDecimal feeRate, @Field("max_staking_fee") BigInteger maxStakingFee);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/babylon/unbonding/")
    Call<ApiResponse<Void>> babylonUnbonding(@Field("request_id") String requestId, @Field("staking_request_id") String stakingRequestId);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/babylon/withdraw/")
    Call<ApiResponse<Void>> babylonWithdraw(@Field("request_id") String requestId, @Field("fee_rate") BigDecimal feeRate, @Field("max_fee_amount") BigInteger maxFeeAmount, @Field("unbonding_request_id") String unbondingRequestId, @Field("staking_request_id") String stakingRequestId);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/babylon/broadcast_staking_transaction/")
    Call<ApiResponse<Void>> babylonBroadcastStakingTransaction(@Field("request_id") String requestId);

    @FormUrlEncoded
    @POST("/v1/custody/mpc/babylon/batch_broadcast_staking_transaction/")
    Call<ApiResponse<Void>> babylonBatchBroadcastStakingTransaction(@Field("request_ids") String requestIds);

    @GET("/v1/custody/mpc/babylon/get_staking_info/")
    Call<ApiResponse<BabylonStakingTransaction>> babylonGetStakingInfo(@Query("request_id") String requestId);

    @GET("/v1/custody/mpc/babylon/list_waiting_broadcast_transactions/")
    Call<ApiResponse<List<BabylonStakingTransaction>>> babylonListWaitingBroadcastTransactions(@Query("asset_coin") String coin, @Query("address") String address);

    @GET("/v1/custody/mpc/babylon/list_transactions_by_status/")
    Call<ApiResponse<List<BabylonStakingTransaction>>> babylonListTransactionsByStatus(@Query("status") Integer status, @Query("address") String address, @Query("min_cobo_id") String minCoboId, @Query("limit") Integer limit);
}
