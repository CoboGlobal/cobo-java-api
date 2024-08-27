package com.cobo.custody.api.client;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.MPCNftCollections;
import com.cobo.custody.api.client.domain.transaction.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface CoboMPCApiRestClient {
    ApiResponse<MPCChains> getSupportedChains();

    ApiResponse<MPCCoins> getSupportedCoins(String chainCode);

    ApiResponse<MPCNftCollections> getSupportedNftCollections(String chainCode);

    ApiResponse<MPCWalletCoins> getWalletSupportedCoins();

    ApiResponse<CoinInfo> getCoinInfo(String coin);

    ApiResponse<Boolean> isValidAddress(String coin, String address);

    ApiResponse<MPCAddressList> getMainAddress(String chainCode);

    ApiResponse<MPCAddressList> generateAddresses(String chainCode, int count, Integer encoding);

    ApiResponse<MPCMemoAddressList> generateAddressMemo(String chainCode, String address, int count);

    ApiResponse<MPCAddress> updateAddressDescription(String coin, String address, String description);

    ApiResponse<MPCAddresses> listAddresses(String chainCode, String startId, String endId, Integer limit, Integer sort);

    ApiResponse<MPCBalance> getBalance(String address, String chainCode, String coin);

    ApiResponse<MPCListBalances> listBalances(String coin, Integer pageIndex, Integer pageLength, String chainCode);

    ApiResponse<MPCListSpendable> listSpendable(String coin, String address);

    ApiResponse<MPCPostTransaction> createTransaction(String coin, String requestId, BigInteger amount, String fromAddr, String toAddr,
                                                      String toAddressDetails, BigDecimal fee, BigInteger gasPrice, BigInteger gasLimit,
                                                      Integer operation, String extraParameters, BigInteger maxFee, BigInteger maxPriorityFee,
                                                      BigInteger feeAmount, String remark, int autoFuel, String memo);

    ApiResponse<MPCPostTransaction> signMessage(String chainCode, String requestId, String fromAddr, Integer signVersion,
                                                String extraParameters);

    ApiResponse<MPCPostTransaction> speedUpTransaction(String coboId, String requestId, BigDecimal fee, BigInteger gasPrice,
                                                       BigInteger gasLimit, BigInteger feeAmount,
                                                       int autoFuel, String extraParameters);

    ApiResponse<MPCPostTransaction> dropTransaction(String coboId, String requestId, BigDecimal fee, BigInteger gasPrice,
                                                    BigInteger gasLimit, BigInteger feeAmount,
                                                    int autoFuel, String extraParameters);

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

    ApiResponse<TssNodes> listTssNodes();

    ApiResponse<SignMessages> signMessageByRequestIds(String requestIds);

    ApiResponse<SignMessages> signMessageByCoboIds(String coboIds);

    ApiResponse<GetSendMaxDetail> getMaxSendAmount(String coin, BigDecimal feeRate, String toAddr, String fromAddr);

    ApiResponse<LockSpendableDetail> lockSpendable(String coin, String txHash, Integer voutN);

    ApiResponse<LockSpendableDetail> unlockSpendable(String coin, String txHash, Integer voutN);

    ApiResponse<GetSatoshisDetails> getRareSatoshis(String coin, String txHash, Integer voutN);

    ApiResponse<MPCUTXOAssetInfo> getUTXOAssets(String coin, String txHash, Integer voutN);

    ApiResponse<OrdinalsInscriptionContent> getOrdinalsInscription(String inscriptionId);

    ApiResponse<ApprovalDetails> getApprovalDetails(String requestId);

    ApiResponse<Void> babylonPrepareStaking(String requestId, String stakeInfo, BigDecimal feeRate, BigInteger maxStakingFee);

    ApiResponse<Void> babylonReplaceStakingFee(String requestId, String relatedRequestId, BigDecimal feeRate, BigInteger maxStakingFee);

    ApiResponse<Void> babylonDropStaking(String requestId, String relatedRequestId, BigDecimal feeRate, BigInteger maxStakingFee);

    ApiResponse<Void> babylonUnbonding(String requestId, String stakingRequestId);

    ApiResponse<Void> babylonWithdraw(String requestId, BigDecimal feeRate, BigInteger maxFeeAmount, String unbondingRequestId, String stakingRequestId);

    ApiResponse<Void> babylonBroadcastStakingTransaction(String requestId);

    ApiResponse<Void> babylonBatchBroadcastStakingTransaction(List<String> requestIds);

    ApiResponse<BabylonStakingTransaction> babylonGetStakingInfo(String requestId);

    ApiResponse<List<BabylonStakingTransaction>> babylonListWaitingBroadcastTransactions(String coin, String address);

    ApiResponse<List<BabylonStakingTransaction>> babylonListTransactionsByStatus(Integer status, String address, String minCoboId, Integer limit);

}
