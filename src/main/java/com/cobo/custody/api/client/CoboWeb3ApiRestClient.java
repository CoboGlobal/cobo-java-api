package com.cobo.custody.api.client;

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

public interface CoboWeb3ApiRestClient {
    ApiResponse<Web3Chains> getSupportedChains();

    ApiResponse<Web3Coins> getSupportedCoins(String chainCode);

    ApiResponse<Web3NftCollections> getSupportedNftCollections();

    ApiResponse<Web3Contracts> getSupportedContracts(String chainCode);

    ApiResponse<Web3ContractMethods> getSupportedContractMethods(String chainCode, String contractAddress);

    ApiResponse<Web3Addresses> batchNewAddress(String chainCode, int count);

    ApiResponse<Web3Addresses> getAddressList(String chainCode, int pageIndex, int pageLength, Integer sortFlag);

    ApiResponse<Web3WalletAsset> getWalletAssetList(String address, String chainCode);

    ApiResponse<Web3WalletNfts> getWalletNftList(String nftCode, String address);

    ApiResponse<Web3WalletNftDetail> getWalletNftDetail(String nftCode, String tokenId);

    ApiResponse<Void> withdraw(String coin, String requestId, String fromAddr, String toAddr, long amount);

    ApiResponse<Web3TransactionInfo> getWithdrawTransaction(String requestId);

    ApiResponse<Void> contract(String chainCode, String requestId, String walletAddr,
                               String contractAddr, String methodId, String methodName,
                               String args, Long amount);

    ApiResponse<Web3TransactionInfo> getContractTransaction(String requestId);

    ApiResponse<Web3Transactions> listWalletTransactions(String address, String coin,
                                                         String max_id, String min_id,
                                                         Integer limit);
}
