package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.CoboApiClientFactory;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoboWeb3ApiRestClientImplTest {
    // refer README "Generate Key Pair"
    private String Web3APISecret = "";
    private CoboWeb3ApiRestClient web3Client;
    private Env TestEnv= Env.SANDBOX;

    @BeforeEach
    public void setUp() throws Exception {
        Web3APISecret = System.getProperty("Web3ApiSecret");
        web3Client = CoboApiClientFactory.newInstance(
                new LocalSigner(Web3APISecret),
                TestEnv,
                true).newWeb3RestClient();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetSupportedChains() {
        ApiResponse<Web3Chains> res = web3Client.getSupportedChains();
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetSupportedCoins() {
        String chainCode = "RETH";
        ApiResponse<Web3Coins> res = web3Client.getSupportedCoins(chainCode);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetSupportedNftCollections() {
        ApiResponse<Web3NftCollections> res = web3Client.getSupportedNftCollections();
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetSupportedContracts() {
        String chainCode = "RETH";
        ApiResponse<Web3Contracts> res = web3Client.getSupportedContracts(chainCode);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetSupportedContractMethods() {
        String chainCode = "RETH";
        String contractAddress = "0x7851dcc90e79f3f2c59915e7f4d6fabd8d3d305b";
        ApiResponse<Web3ContractMethods> res = web3Client.getSupportedContractMethods(chainCode, contractAddress);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testBatchNewAddress() {
        String chainCode = "ETH";
        int count = 10;
        ApiResponse<Web3Addresses> res = web3Client.batchNewAddress(chainCode, count);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetAddressList() {
        String chainCode = "ETH";
        int pageIndex = 0;
        int pageLength = 40;
        int sortFlag = 0;
        ApiResponse<Web3Addresses> res = web3Client.getAddressList(chainCode, pageIndex, pageLength, sortFlag);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetWalletAssetList() {
        String address = "0xd387292d5be73c8b9d6d3a4dcdd49e00edf75b6a";
        String chainCode = "RETH";
        ApiResponse<Web3WalletAsset> res = web3Client.getWalletAssetList(address, chainCode);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetWalletNftList() {
        String nftCode = "NFT_RETH_PROOF_MOONBIRDS";
        String address = "0xd387292d5be73c8b9d6d3a4dcdd49e00edf75b6a";
        ApiResponse<Web3WalletNfts> res = web3Client.getWalletNftList(nftCode, address);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetWalletNftDetail() {
        String nftCode = "NFT_RETH_PROOF_MOONBIRDS";
        String tokenId = "148";
        ApiResponse<Web3WalletNftDetail> res = web3Client.getWalletNftDetail(nftCode, tokenId);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testWithdraw() {
        String coin = "ETH";
        String requestId = String.valueOf(System.currentTimeMillis());
        String fromAddr = "0xd2176409a1ac767824921e45b7ee300745cb1e3f";
        String toAddr = "0xD2176409a1Ac767824921e45B7Ee300745cB1e3f";
        long amount = 101;
        ApiResponse<Void> res = web3Client.withdraw(coin, requestId, fromAddr, toAddr, amount);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetWithdrawTransaction() {
        String requestId = "1665303298935";
        ApiResponse<Web3TransactionInfo> res = web3Client.getWithdrawTransaction(requestId);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testContract() throws JsonProcessingException {
        String chainCode = "ETH";
        String requestId = String.valueOf(System.currentTimeMillis());
        String walletAddr = "0xd2176409a1ac767824921e45b7ee300745cb1e3f";
        String contractAddr = "0xa4e8c3ec456107ea67d3075bf9e3df3a75823db0";
        String methodId = "0xa9059cbb";
        String methodName = "transfer";
        String args = "[\"0x040149e133077aebcfe4594e00638135eb4bc77f\", 1]";
        long amount = 1;
        ApiResponse<Void> res = web3Client.contract(chainCode, requestId, walletAddr,
                contractAddr, methodId, methodName, args, amount);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetContractTransaction() {
        String requestId = "1664239624441";
        ApiResponse<Web3TransactionInfo> res = web3Client.getContractTransaction(requestId);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testListWalletTransactions() {
        String address = "0xd2176409a1ac767824921e45b7ee300745cb1e3f";
        String coin = "ETH";
        String max_id = null;
        String min_id = "20221009161459000368403000001228";
        int limit = 10;
        ApiResponse<Web3Transactions> res = web3Client.listWalletTransactions(address, coin, max_id, min_id, limit);
        System.out.println(res);
        assertTrue(res.isSuccess());
    }
}
