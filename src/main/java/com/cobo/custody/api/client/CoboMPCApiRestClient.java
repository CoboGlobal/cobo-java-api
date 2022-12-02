package com.cobo.custody.api.client;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.MPCUnspentInputs;
import com.cobo.custody.api.client.domain.asset.MPCWalletAsset;
import com.cobo.custody.api.client.domain.transaction.MPCPostTransaction;
import com.cobo.custody.api.client.domain.transaction.MPCTransactionInfos;
import com.cobo.custody.api.client.domain.transaction.MPCTransactions;

import java.math.BigInteger;

public interface CoboMPCApiRestClient {
    ApiResponse<OrgInfo> getOrgInfo();
    ApiResponse<MPCChains> getSupportedChains();
    ApiResponse<MPCCoins> getSupportedCoins(String chainCode);

    ApiResponse<MPCAddressList> getMainAddress(String chainCode);

    ApiResponse<MPCAddressList> batchGenerateAddresses(String chainCode, int count);
    ApiResponse<MPCAddresses> getAddressList(String chainCode, int pageIndex, int pageLength, Integer sortFlag);
    ApiResponse<MPCWalletAsset> getWalletAssetList(String address, String chainCode);
    ApiResponse<MPCUnspentInputs> getWalletUnspentInputList(String address, String chainCode);
    ApiResponse<MPCPostTransaction> createTransaction(String coin, String requestId, String fromAddr, String toAddr, BigInteger amount,
                                                      String toAddressDetails, BigInteger fee, BigInteger gasPrice, BigInteger gasLimit,
                                                      String extraParameters);

    ApiResponse<MPCPostTransaction> speedUpTransaction(String coboId, BigInteger gasPrice, BigInteger gasLimit);

    ApiResponse<MPCPostTransaction> dropTransaction(String coboId, BigInteger gasPrice, BigInteger gasLimit);

    ApiResponse<MPCTransactionInfos> getTransactionByRequestIds(String requestIds, Integer status);
    ApiResponse<MPCTransactionInfos> getTransactionByCoboIds(String coboIds, Integer status);
    ApiResponse<MPCTransactionInfos> getTransactionByTxHash(String txId, Integer transactionType);
    ApiResponse<MPCTransactions> listWalletTransactions(Integer startTime, Integer endTime, Integer status, String order,
                                                        Integer transactionType, String coins, String fromAddr, String toAddr,
                                                        Integer limit);
}
