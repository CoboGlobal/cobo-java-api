package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.Web3NftCollections;
import com.cobo.custody.api.client.domain.asset.Web3WalletAsset;
import com.cobo.custody.api.client.domain.asset.Web3WalletNftDetail;
import com.cobo.custody.api.client.domain.asset.Web3WalletNfts;
import com.cobo.custody.api.client.domain.contract.Web3ContractMethods;
import com.cobo.custody.api.client.domain.contract.Web3Contracts;
import com.cobo.custody.api.client.domain.transaction.Web3TransactionInfo;
import com.cobo.custody.api.client.domain.transaction.Web3Transactions;
import retrofit2.Call;
import retrofit2.http.*;

public interface CoboWeb3ApiService {
    @GET("/v1/custody/web3_supported_chains/")
    Call<ApiResponse<Web3Chains>> getWeb3SupportedChains();

    @GET("/v1/custody/web3_supported_coins/")
    Call<ApiResponse<Web3Coins>> getWeb3SupportedCoins(@Query("chain_code") String chainCode);

    @GET("/v1/custody/web3_supported_nft_collections/")
    Call<ApiResponse<Web3NftCollections>> getWeb3SupportedNftCollections();

    @GET("/v1/custody/web3_supported_contracts/")
    Call<ApiResponse<Web3Contracts>> getWeb3SupportedContracts(@Query("chain_code") String chainCode);

    @GET("/v1/custody/web3_supported_contract_methods/")
    Call<ApiResponse<Web3ContractMethods>> getWeb3SupportedContractMethods(@Query("chain_code") String chainCode,
                                                                           @Query("contract_address") String contractAddress);

    @FormUrlEncoded
    @POST("/v1/custody/web3_add_addresses/")
    Call<ApiResponse<Web3Addresses>> batchWeb3NewAddress(@Field("chain_code") String chainCode,
                                                        @Field("count") int count);

    @GET("/v1/custody/web3_list_wallet_address/")
    Call<ApiResponse<Web3Addresses>> getWeb3AddressList(@Query("chain_code") String chainCode,
                                                                     @Query("page_index") int pageIndex,
                                                                     @Query("page_length") int pageLength,
                                                                     @Query("sort_flag") int sortFlag);

    @GET("/v1/custody/web3_list_wallet_assets/")
    Call<ApiResponse<Web3WalletAsset>> getWeb3WalletAssetList(@Query("address") String address,
                                                              @Query("chain_code") String chainCode);

    @GET("/v1/custody/web3_list_wallet_nfts/")
    Call<ApiResponse<Web3WalletNfts>> getWeb3WalletNftList(@Query("nft_code") String nftCode,
                                                           @Query("address") String address);

    @GET("/v1/custody/web3_wallet_nft_detail/")
    Call<ApiResponse<Web3WalletNftDetail>> getWeb3WalletNftDetail(@Query("nft_code") String nftCode,
                                                                  @Query("token_id") String tokenId);

    @FormUrlEncoded
    @POST("/v1/custody/web3_withdraw/")
    Call<ApiResponse<Void>> web3Withdraw(@Field("coin") String coin,
                                     @Field("request_id") String requestId,
                                     @Field("from_addr") String fromAddr,
                                     @Field("to_addr") String toAddr,
                                     @Field("amount") long amount);

    @GET("/v1/custody/web3_get_withdraw_transaction/")
    Call<ApiResponse<Web3TransactionInfo>> getWeb3WithdrawTransaction(@Query("request_id") String requestId);

    @FormUrlEncoded
    @POST("/v1/custody/web3_contract/")
    Call<ApiResponse<Void>> web3Contract(@Field("chain_code") String chainCode,
                                     @Field("request_id") String requestId,
                                     @Field("wallet_addr") String walletAddr,
                                     @Field("contract_addr") String contractAddr,
                                     @Field("method_id") String methodId,
                                     @Field("method_name") String methodName,
                                     @Field("args") String args,
                                     @Field("amount") Long amount);

    @GET("/v1/custody/web3_get_contract_transaction/")
    Call<ApiResponse<Web3TransactionInfo>> getWeb3ContractTransaction(@Query("request_id") String requestId);

    @GET("/v1/custody/web3_list_wallet_transactions/")
    Call<ApiResponse<Web3Transactions>> listWeb3WalletTransactions(@Query("address") String address,
                                                                   @Query("coin") String coin,
                                                                   @Query("max_id") String max_id,
                                                                   @Query("min_id") String min_id,
                                                                   @Query("limit") int limit);
}
