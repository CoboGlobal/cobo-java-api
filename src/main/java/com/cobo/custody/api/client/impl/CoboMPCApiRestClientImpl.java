package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.ApiSigner;
import com.cobo.custody.api.client.CoboMPCApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.MPCAddresses;
import com.cobo.custody.api.client.domain.account.MPCChains;
import com.cobo.custody.api.client.domain.account.MPCCoins;
import com.cobo.custody.api.client.domain.asset.MPCWalletAsset;
import com.cobo.custody.api.client.domain.transaction.MPCTransactionInfo;
import com.cobo.custody.api.client.domain.transaction.MPCTransactions;

import java.math.BigInteger;

import static com.cobo.custody.api.client.impl.CoboApiServiceGenerator.createService;
import static com.cobo.custody.api.client.impl.CoboApiServiceGenerator.executeSync;

public class CoboMPCApiRestClientImpl implements CoboMPCApiRestClient {
    private final CoboMPCApiService coboMPCApiService;

    public CoboMPCApiRestClientImpl(ApiSigner signer, Env env, boolean debug) {
        this.coboMPCApiService = createService(CoboMPCApiService.class, signer, env, debug);
    }
    @Override
    public ApiResponse<MPCChains> getSupportedChains() {
        return executeSync(coboMPCApiService.getSupportedChains());
    }

    @Override
    public ApiResponse<MPCCoins> getSupportedCoins(String chainCode) {
        return executeSync(coboMPCApiService.getSupportedCoins(chainCode));
    }

    @Override
    public ApiResponse<MPCAddresses> batchNewAddress(String chainCode, int count) {
        return executeSync(coboMPCApiService.batchNewAddress(chainCode, count));
    }

    @Override
    public ApiResponse<MPCAddresses> getAddressList(String chainCode, int pageIndex, int pageLength, Integer sortFlag) {
        return executeSync(coboMPCApiService.getAddressList(chainCode, pageIndex, pageLength, sortFlag));
    }

    @Override
    public ApiResponse<MPCWalletAsset> getWalletAssetList(String address, String chainCode) {
        return executeSync(coboMPCApiService.getWalletAssetList(address, chainCode));
    }

    @Override
    public ApiResponse<Void> createTransaction(String coin, String request_id, String fromAddr, String toAddr, BigInteger amount) {
        return executeSync(coboMPCApiService.createTransaction(coin, request_id, fromAddr, toAddr, amount));
    }

    @Override
    public ApiResponse<MPCTransactionInfo> getTransaction(String request_id) {
        return executeSync(coboMPCApiService.getTransaction(request_id));
    }

    @Override
    public ApiResponse<MPCTransactions> listWalletTransactions(String address, String coin, String max_id, String min_id, Integer limit) {
        return executeSync(coboMPCApiService.listWalletTransactions(address, coin, max_id, min_id, limit));
    }
}
