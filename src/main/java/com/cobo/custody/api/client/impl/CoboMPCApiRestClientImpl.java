package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.ApiSigner;
import com.cobo.custody.api.client.CoboMPCApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.MPCUnspentInputs;
import com.cobo.custody.api.client.domain.asset.MPCWalletAsset;
import com.cobo.custody.api.client.domain.transaction.*;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.math.BigInteger;
import java.util.List;

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
    public ApiResponse<MPCAddressList> getMainAddress(String chainCode) {
        return executeSync(coboMPCApiService.getMainAddress(chainCode));
    }

    @Override
    public ApiResponse<MPCAddressList> batchGenerateAddresses(String chainCode, int count) {
        return executeSync(coboMPCApiService.batchGenerateAddresses(chainCode, count));
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
    public ApiResponse<MPCUnspentInputs> getWalletUnspentInputList(String address, String coin) {
        return executeSync(coboMPCApiService.getWalletUnspentInputList(address, coin));
    }

    @Override
    public ApiResponse<MPCPostTransaction> createTransaction(String coin, String requestId, String fromAddr, String toAddr, BigInteger amount,
                                                             String toAddressDetails, BigInteger fee, BigInteger gasPrice, BigInteger gasLimit,
                                                             String extraParameters) {
        return executeSync(coboMPCApiService.createTransaction(coin, requestId, fromAddr, toAddr, amount,
                toAddressDetails, fee, gasPrice, gasLimit, extraParameters));
    }

    @Override
    public ApiResponse<MPCPostTransaction> speedUpTransaction(String coboId, BigInteger fee, BigInteger gasPrice, BigInteger gasLimit) {
        return executeSync(coboMPCApiService.speedUpTransaction(coboId, fee, gasPrice, gasLimit));
    }

    @Override
    public ApiResponse<MPCPostTransaction> dropTransaction(String coboId, BigInteger fee, BigInteger gasPrice, BigInteger gasLimit) {
        return executeSync(coboMPCApiService.dropTransaction(coboId, fee, gasPrice, gasLimit));
    }

    @Override
    public ApiResponse<MPCTransactionInfos> getTransactionByRequestIds(String requestIds, Integer status) {
        return executeSync(coboMPCApiService.getTransactionsByRequestIds(requestIds, status));
    }

    @Override
    public ApiResponse<MPCTransactionInfos> getTransactionByCoboIds(String coboIds, Integer status) {
        return executeSync(coboMPCApiService.getTransactionsByCoboIds(coboIds, status));
    }

    @Override
    public ApiResponse<MPCTransactionInfos> getTransactionByTxHash(String txHash, Integer transactionType) {
        return executeSync(coboMPCApiService.getTransactionByTxhash(txHash, transactionType));
    }

    @Override
    public ApiResponse<MPCTransactions> listWalletTransactions(Long startTime, Long endTime, Integer status, String order,
                                                               Integer transactionType, String coins, String fromAddr, String toAddr,
                                                               Integer limit) {
        return executeSync(coboMPCApiService.listWalletTransactions(startTime, endTime, status, order, transactionType,
                coins, fromAddr, toAddr, limit));
    }

    @Override
    public ApiResponse<EstimateFeeDetails> estimateFee(String coin, Integer amount, String address) {
        return executeSync(coboMPCApiService.estimateFee(coin, amount, address));
    }

    @Override
    public ApiResponse<MPCTssNodeRequests> listRequests(Integer requestType, Integer status) {
        return executeSync(coboMPCApiService.listRequests(requestType, status));
    }
}
