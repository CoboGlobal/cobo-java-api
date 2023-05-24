package com.cobo.custody.api.client;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.MPCNftCollections;
import com.cobo.custody.api.client.domain.transaction.*;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface CoboMPCApiRestClient {
    ApiResponse<MPCChains> getSupportedChains();

    ApiResponse<MPCCoins> getSupportedCoins(String chainCode);

    ApiResponse<MPCNftCollections> getSupportedNftCollections(String chainCode);

    ApiResponse<MPCWalletCoins> getWalletSupportedCoins();

    ApiResponse<Boolean> isValidAddress(String coin, String address);

    ApiResponse<MPCAddressList> getMainAddress(String chainCode);

    ApiResponse<MPCAddressList> generateAddresses(String chainCode, int count);

    ApiResponse<MPCAddresses> listAddresses(String chainCode, String startId, String endId, Integer limit, Integer sort);

    ApiResponse<MPCBalance> getBalance(String address, String chainCode, String coin);

    ApiResponse<MPCListBalances> listBalances(String coin, Integer pageIndex, Integer pageLength, String chainCode);

    ApiResponse<MPCListSpendable> listSpendable(String coin, String address);

    ApiResponse<MPCPostTransaction> createTransaction(String coin, String requestId, BigInteger amount, String fromAddr, String toAddr,
                                                      String toAddressDetails, BigDecimal fee, BigInteger gasPrice, BigInteger gasLimit,
                                                      Integer operation, String extraParameters, BigInteger maxFee, BigInteger maxPriorityFee,
                                                      BigInteger feeAmount);

    ApiResponse<MPCPostTransaction> signMessage(String chainCode, String requestId, String fromAddr, Integer signVersion,
                                                String extraParameters);

    ApiResponse<MPCPostTransaction> speedUpTransaction(String coboId, String requestId, BigDecimal fee, BigInteger gasPrice,
                                                       BigInteger gasLimit, BigInteger feeAmount);

    ApiResponse<MPCPostTransaction> dropTransaction(String coboId, String requestId, BigDecimal fee, BigInteger gasPrice,
                                                    BigInteger gasLimit, BigInteger feeAmount);

    ApiResponse<MPCTransactionInfos> transactionsByRequestIds(String requestIds, Integer status);

    ApiResponse<MPCTransactionInfos> transactionsByCoboIds(String coboIds, Integer status);

    ApiResponse<MPCTransactionInfos> transactionsByTxhash(String txId, Integer transactionType);

    ApiResponse<MPCTransactions> listTransactions(Long startTime, Long endTime, Integer status, String orderBy, String order,
                                                  Integer transactionType, String coins, String fromAddr, String toAddr,
                                                  Integer limit);

    ApiResponse<EstimateFeeDetails> estimateFee(String coin, BigInteger amount, String address, String replaceCoboId,
                                                String fromAddress, String toAddressDetails,
                                                BigDecimal fee, BigInteger gasPrice, BigInteger gasLimit,
                                                String extraParameters);

    ApiResponse<MPCTssNodeRequests> listTssNodeRequests(Integer requestType, Integer status);

    ApiResponse<Void> retryDoubleCheck(String requestId);
}
