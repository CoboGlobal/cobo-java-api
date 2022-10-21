package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.ApiSigner;
import com.cobo.custody.api.client.CoboWeb3ApiRestClient;
import com.cobo.custody.api.client.config.Env;
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

import static com.cobo.custody.api.client.impl.CoboApiServiceGenerator.createService;
import static com.cobo.custody.api.client.impl.CoboApiServiceGenerator.executeSync;

public class CoboWeb3ApiRestClientImpl implements CoboWeb3ApiRestClient {
    private final CoboWeb3ApiService coboWeb3ApiService;

    public CoboWeb3ApiRestClientImpl(ApiSigner signer, Env env, boolean debug) {
        this.coboWeb3ApiService = createService(CoboWeb3ApiService.class, signer, env, debug);;
    }

    @Override
    public ApiResponse<Web3Chains> getSupportedChains() {
        return executeSync(coboWeb3ApiService.getWeb3SupportedChains());
    }

    @Override
    public ApiResponse<Web3Coins> getSupportedCoins(String chainCode) {
        return executeSync(coboWeb3ApiService.getWeb3SupportedCoins(chainCode));
    }

    @Override
    public ApiResponse<Web3NftCollections> getSupportedNftCollections() {
        return executeSync(coboWeb3ApiService.getWeb3SupportedNftCollections());
    }

    @Override
    public ApiResponse<Web3Contracts> getSupportedContracts(String chainCode) {
        return executeSync(coboWeb3ApiService.getWeb3SupportedContracts(chainCode));
    }

    @Override
    public ApiResponse<Web3ContractMethods> getSupportedContractMethods(String chainCode, String contractAddress) {
        return executeSync(coboWeb3ApiService.getWeb3SupportedContractMethods(chainCode, contractAddress));
    }

    @Override
    public ApiResponse<Web3Addresses> batchNewAddress(String chainCode, int count) {
        return executeSync(coboWeb3ApiService.batchWeb3NewAddress(chainCode, count));
    }

    @Override
    public ApiResponse<Web3Addresses> getAddressList(String chainCode, int pageIndex, int pageLength, Integer sortFlag) {
        return executeSync(coboWeb3ApiService.getWeb3AddressList(chainCode, pageIndex, pageLength, sortFlag));
    }

    @Override
    public ApiResponse<Web3WalletAsset> getWalletAssetList(String address, String chainCode) {
        return executeSync(coboWeb3ApiService.getWeb3WalletAssetList(address, chainCode));
    }

    @Override
    public ApiResponse<Web3WalletNfts> getWalletNftList(String nftCode, String address) {
        return executeSync(coboWeb3ApiService.getWeb3WalletNftList(nftCode, address));
    }

    @Override
    public ApiResponse<Web3WalletNftDetail> getWalletNftDetail(String nftCode, String tokenId) {
        return executeSync(coboWeb3ApiService.getWeb3WalletNftDetail(nftCode, tokenId));
    }

    @Override
    public ApiResponse<Void> withdraw(String coin, String requestId, String fromAddr, String toAddr, long amount) {
        return executeSync(coboWeb3ApiService.web3Withdraw(coin, requestId, fromAddr, toAddr, amount));
    }

    @Override
    public ApiResponse<Web3TransactionInfo> getWithdrawTransaction(String requestId) {
        return executeSync(coboWeb3ApiService.getWeb3WithdrawTransaction(requestId));
    }

    @Override
    public ApiResponse<Void> contract(String chainCode, String requestId, String walletAddr,
                                      String contractAddr, String methodId, String methodName,
                                      String args, Long amount) {
        return executeSync(coboWeb3ApiService.web3Contract(chainCode, requestId, walletAddr, contractAddr,
                methodId, methodName, args, amount));
    }

    @Override
    public ApiResponse<Web3TransactionInfo> getContractTransaction(String requestId) {
        return executeSync(coboWeb3ApiService.getWeb3ContractTransaction(requestId));
    }

    @Override
    public ApiResponse<Web3Transactions> listWalletTransactions(String address, String coin, String max_id,
                                                                String min_id, Integer limit) {
        return executeSync(coboWeb3ApiService.listWeb3WalletTransactions(address, coin, max_id, min_id, limit));
    }
}
