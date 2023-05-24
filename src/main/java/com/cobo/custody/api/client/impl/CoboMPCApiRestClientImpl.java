package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.ApiSigner;
import com.cobo.custody.api.client.CoboMPCApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.MPCNftCollections;
import com.cobo.custody.api.client.domain.transaction.*;

import java.math.BigDecimal;
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
    public ApiResponse<MPCNftCollections> getSupportedNftCollections(String chainCode) {
        return executeSync(coboMPCApiService.getSupportedNftCollections(chainCode));
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

    public ApiResponse<MPCListBalances> listBalances(String coin, Integer pageIndex, Integer pageLength, String chainCode) {
        return executeSync(coboMPCApiService.listBalances(coin, pageIndex, pageLength, chainCode));
    }

    public ApiResponse<MPCListSpendable> listSpendable(String coin, String address) {
        return executeSync(coboMPCApiService.listSpendable(coin, address));
    }

    @Override
    public ApiResponse<MPCPostTransaction> createTransaction(String coin, String requestId, BigInteger amount, String fromAddr, String toAddr,
                                                             String toAddressDetails, BigDecimal fee, BigInteger gasPrice, BigInteger gasLimit,
                                                             Integer operation, String extraParameters, BigInteger maxFee, BigInteger maxPriorityFee,
                                                             BigInteger feeAmount) {
        return executeSync(coboMPCApiService.createTransaction(coin, requestId, amount, fromAddr, toAddr,
                toAddressDetails, fee, gasPrice, gasLimit, operation, extraParameters, maxFee, maxPriorityFee, feeAmount));
    }

    @Override
    public ApiResponse<MPCPostTransaction> signMessage(String chainCode, String requestId, String fromAddr, Integer signVersion,
                                                       String extraParameters) {
        return executeSync(coboMPCApiService.signMessage(chainCode, requestId, fromAddr, signVersion, extraParameters));
    }

    @Override
    public ApiResponse<MPCPostTransaction> speedUpTransaction(String coboId, String requestId, BigDecimal fee,
                                                              BigInteger gasPrice, BigInteger gasLimit, BigInteger feeAmount) {
        return executeSync(coboMPCApiService.speedUpTransaction(coboId, requestId, fee, gasPrice, gasLimit, feeAmount));
    }

    @Override
    public ApiResponse<MPCPostTransaction> dropTransaction(String coboId, String requestId, BigDecimal fee,
                                                           BigInteger gasPrice, BigInteger gasLimit, BigInteger feeAmount) {
        return executeSync(coboMPCApiService.dropTransaction(coboId, requestId, fee, gasPrice, gasLimit, feeAmount));
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
    public ApiResponse<EstimateFeeDetails> estimateFee(String coin, BigInteger amount, String address, String replaceCoboId,
                                                       String fromAddress, String toAddressDetails,
                                                       BigDecimal fee, BigInteger gasPrice, BigInteger gasLimit,
                                                       String extraParameters) {
        return executeSync(coboMPCApiService.estimateFee(coin, amount, address, replaceCoboId, fromAddress, toAddressDetails,
                fee, gasPrice, gasLimit, extraParameters));
    }

    @Override
    public ApiResponse<MPCTssNodeRequests> listTssNodeRequests(Integer requestType, Integer status) {
        return executeSync(coboMPCApiService.listTssNodeRequests(requestType, status));
    }

    @Override
    public ApiResponse<Void> retryDoubleCheck(String requestId) {
        return executeSync(coboMPCApiService.retryDoubleCheck(requestId));
    }
}
