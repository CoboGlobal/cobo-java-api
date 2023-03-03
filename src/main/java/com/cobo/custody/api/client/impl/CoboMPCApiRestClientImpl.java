package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.ApiSigner;
import com.cobo.custody.api.client.CoboMPCApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.transaction.*;

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
    public ApiResponse<MPCWalletCoins> getWalletSupportedCoins() {
        return executeSync(coboMPCApiService.getWalletSupportedCoins());
    }

    @Override
    public ApiResponse<Boolean> isValidAddress(String coin, String address) {
        return executeSync(coboMPCApiService.isValidAddress(coin, address));
    }

    @Override
    public ApiResponse<MPCAddressList> getMainAddress(String chainCode) {
        return executeSync(coboMPCApiService.getMainAddress(chainCode));
    }

    @Override
    public ApiResponse<MPCAddressList> generateAddresses(String chainCode, int count) {
        return executeSync(coboMPCApiService.generateAddresses(chainCode, count));
    }

    @Override
    public ApiResponse<MPCAddresses> listAddresses(String chainCode, String startId, String endId, Integer limit, Integer sort) {
        return executeSync(coboMPCApiService.listAddresses(chainCode, startId, endId, limit, sort));
    }

    public ApiResponse<MPCBalance> getBalance(String address, String chainCode, String coin) {
        return executeSync(coboMPCApiService.getBalance(address, chainCode, coin));
    }

    public ApiResponse<MPCListBalances> listBalances(String coin, Integer pageIndex, Integer pageLength) {
        return executeSync(coboMPCApiService.listBalances(coin, pageIndex, pageLength));
    }

    public ApiResponse<MPCListSpendable> listSpendable(String coin, String address) {
        return executeSync(coboMPCApiService.listSpendable(coin, address));
    }

    @Override
    public ApiResponse<MPCPostTransaction> createTransaction(String coin, String requestId, String fromAddr, String toAddr, BigInteger amount,
                                                             String toAddressDetails, BigInteger fee, BigInteger gasPrice, BigInteger gasLimit,
                                                             Integer operation, String extraParameters) {
        return executeSync(coboMPCApiService.createTransaction(coin, requestId, fromAddr, toAddr, amount,
                toAddressDetails, fee, gasPrice, gasLimit, operation, extraParameters));
    }

    @Override
    public ApiResponse<MPCPostTransaction> speedUpTransaction(String coboId, String requestId, BigInteger fee, BigInteger gasPrice, BigInteger gasLimit) {
        return executeSync(coboMPCApiService.speedUpTransaction(coboId, requestId, fee, gasPrice, gasLimit));
    }

    @Override
    public ApiResponse<MPCPostTransaction> dropTransaction(String coboId, String requestId, BigInteger fee, BigInteger gasPrice, BigInteger gasLimit) {
        return executeSync(coboMPCApiService.dropTransaction(coboId, requestId, fee, gasPrice, gasLimit));
    }

    @Override
    public ApiResponse<MPCTransactionInfos> transactionsByRequestIds(String requestIds, Integer status) {
        return executeSync(coboMPCApiService.transactionsByRequestIds(requestIds, status));
    }

    @Override
    public ApiResponse<MPCTransactionInfos> transactionsByCoboIds(String coboIds, Integer status) {
        return executeSync(coboMPCApiService.transactionsByCoboIds(coboIds, status));
    }

    @Override
    public ApiResponse<MPCTransactionInfos> transactionsByTxhash(String txHash, Integer transactionType) {
        return executeSync(coboMPCApiService.transactionsByTxhash(txHash, transactionType));
    }

    @Override
    public ApiResponse<MPCTransactions> listTransactions(Long startTime, Long endTime, Integer status, String orderBy, String order,
                                                               Integer transactionType, String coins, String fromAddr, String toAddr,
                                                               Integer limit) {
        return executeSync(coboMPCApiService.listTransactions(startTime, endTime, status, orderBy, order, transactionType,
                coins, fromAddr, toAddr, limit));
    }

    @Override
    public ApiResponse<EstimateFeeDetails> estimateFee(String coin, BigInteger amount, String address, String replaceCoboId) {
        return executeSync(coboMPCApiService.estimateFee(coin, amount, address, replaceCoboId));
    }

    @Override
    public ApiResponse<MPCTssNodeRequests> listTssNodeRequests(Integer requestType, Integer status) {
        return executeSync(coboMPCApiService.listTssNodeRequests(requestType, status));
    }
}
