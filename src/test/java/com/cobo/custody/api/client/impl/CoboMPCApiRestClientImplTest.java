package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboMPCApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.MPCWalletAsset;
import com.cobo.custody.api.client.domain.transaction.MPCTransactions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoboMPCApiRestClientImplTest {
    private String MPCAPISecret = "";
    private CoboMPCApiRestClient mpcClient;
    private Env TestEnv= Env.SANDBOX;

    @BeforeEach
    public void setUp() throws Exception {
        MPCAPISecret = System.getProperty("MPCApiSecret");
        mpcClient = CoboApiClientFactory.newInstance(
                new LocalSigner(MPCAPISecret),
                TestEnv,
                false).newMPCRestClient();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetOrgInfo() {
        ApiResponse<OrgInfo> res = mpcClient.getOrgInfo();
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetSupportedChains() {
        ApiResponse<MPCChains> res = mpcClient.getSupportedChains();
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testgetSupportedCoins() {
        String chainCode = "GETH";
        ApiResponse<MPCCoins> res = mpcClient.getSupportedCoins(chainCode);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testBatchNewAddress() {
        String chainCode = "GETH";
        int count = 2;
        ApiResponse<MPCAddressList> res = mpcClient.batchGenerateAddresses(chainCode, count);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetAddressList() {
        String chainCode = "GETH";
        int pageIndex = 1;
        int pageLength = 10;
        Integer sortFlag = 0;
        ApiResponse<MPCAddresses> res = mpcClient.getAddressList(chainCode, pageIndex, pageLength, sortFlag);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetWalletAssetList() {
        String address = "0x4897e732734a7b4265cf48201b0ad2adb06657ba";
        String chainCode = "GETH";
        ApiResponse<MPCWalletAsset> res = mpcClient.getWalletAssetList(address, chainCode);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testCreateTransaction() {
        String coin = "GETH";
        String requestId = String.valueOf(System.currentTimeMillis());
        String fromAddr = "0x4897e732734a7b4265cf48201b0ad2adb06657ba";
        String toAddr = "0xEEACb7a5e53600c144C0b9839A834bb4b39E540c";
        BigInteger amount = new BigInteger("10");
        String toAddressDetails = null;
        BigInteger fee = null;
        BigInteger gasPrice = null;
        BigInteger gasLimit = null;
        String extraParameters = null;
        String replaceTxByHash = null;
        ApiResponse<Void> res = mpcClient.createTransaction(coin, requestId, fromAddr, toAddr, amount,
                toAddressDetails, fee, gasPrice, gasLimit, extraParameters, replaceTxByHash);
        System.out.println(requestId);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetTransaction() {
        String requestIds = "1668678820274";
        ApiResponse<MPCTransactions> res = mpcClient.getTransactionByRequestIds(requestIds, null);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetTransactionByTxId() {
        String txHash = "0x1e14311142db1f5b02e587f0e00643f7fd460c81e73dffff65cf501123fb99dd";
        ApiResponse<MPCTransactions> res = mpcClient.getTransactionByTxHash(txHash, null);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testListWalletTransactions() {
        Integer startTime = null;
        Integer endTime = null;
        Integer status = null;
        String order = null;
        Integer transactionType = null;
        String coins = null;
        String fromAddress = null;
        String toAddress = null;
        Integer limit = null;

        ApiResponse<MPCTransactions> res = mpcClient.listWalletTransactions(startTime, endTime, status, order,
                transactionType, coins, fromAddress, toAddress, limit);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }
}
