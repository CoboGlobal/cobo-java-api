package com.cobo.custody.api.client;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.transaction.*;

import java.math.BigInteger;

public interface CoboMPCApiRestClient {
    ApiResponse<MPCChains> getSupportedChains();

    ApiResponse<MPCCoins> getSupportedCoins(String chainCode);

    ApiResponse<Boolean> isValidAddress(String coin, String address);

    ApiResponse<MPCAddressList> getMainAddress(String chainCode);

    ApiResponse<MPCAddressList> batchGenerateAddresses(String chainCode, int count);

    ApiResponse<MPCAddresses> getAddressList(String chainCode, String startId, String endId, Integer limit, Integer sort);

    ApiResponse<MPCBalance> getBalance(String address, String chainCode, String coin);

    ApiResponse<MPCListBalances> listBalances(String coin, Integer pageIndex, Integer pageLength);

    ApiResponse<MPCListSpendable> listSpendable(String coin, String address);

    ApiResponse<MPCPostTransaction> createTransaction(String coin, String requestId, String fromAddr, String toAddr, BigInteger amount,
                                                      String toAddressDetails, BigInteger fee, BigInteger gasPrice, BigInteger gasLimit,
                                                      Integer operation, String extraParameters);

    ApiResponse<MPCPostTransaction> speedUpTransaction(String coboId, String requestId, BigInteger fee, BigInteger gasPrice, BigInteger gasLimit);

    ApiResponse<MPCPostTransaction> dropTransaction(String coboId, String requestId, BigInteger fee, BigInteger gasPrice, BigInteger gasLimit);

    ApiResponse<MPCTransactionInfos> getTransactionByRequestIds(String requestIds, Integer status);

    ApiResponse<MPCTransactionInfos> getTransactionByCoboIds(String coboIds, Integer status);

    ApiResponse<MPCTransactionInfos> getTransactionByTxHash(String txId, Integer transactionType);

    ApiResponse<MPCTransactions> listWalletTransactions(Long startTime, Long endTime, Integer status, String orderBy, String order,
                                                        Integer transactionType, String coins, String fromAddr, String toAddr,
                                                        Integer limit);

    ApiResponse<EstimateFeeDetails> estimateFee(String coin, BigInteger amount, String address);

    ApiResponse<MPCTssNodeRequests> listRequests(Integer requestType, Integer status);
}
