package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboMPCApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.asset.MPCWalletAsset;
import com.cobo.custody.api.client.domain.transaction.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoboMPCApiRestClientImplTest {
    private String MPCAPISecret = "";
    private CoboMPCApiRestClient mpcClient;
    private Env TestEnv = Env.SANDBOX;

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
    public void testBatchGenerateAddress() {
        String chainCode = "GETH";
        int count = 2;
        ApiResponse<MPCAddressList> res = mpcClient.batchGenerateAddresses(chainCode, count);
        System.out.println(res);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetAddressList() {
        String chainCode = "GETH";
        String startId = "1";
        String endId = "100000";
        int limit = 50;
        int sort = 1;
        ApiResponse<MPCAddresses> res = mpcClient.getAddressList(chainCode, startId, endId, limit, sort);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetBalance() {
        String address = "0x4897e732734a7b4265cf48201b0ad2adb06657ba";
        String chainCode = null;
        String coin = "GETH";
        ApiResponse<MPCBalance> res = mpcClient.getBalance(address, chainCode, coin);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testListBalances() {
        String coin = "GETH";
        Integer pageIndex = 1;
        Integer pageLength = 50;
        ApiResponse<MPCListBalances> res = mpcClient.listBalances(coin, pageIndex, pageLength);
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
        Integer operation = null;
        String extraParameters = null;
        ApiResponse<MPCPostTransaction> res = mpcClient.createTransaction(coin, requestId, fromAddr, toAddr, amount,
                toAddressDetails, fee, gasPrice, gasLimit, operation, extraParameters);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetTransactionByRequestIds() {
        String requestIds = "1668678820274";
        ApiResponse<MPCTransactionInfos> res = mpcClient.getTransactionByRequestIds(requestIds, null);
        System.out.println(res);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetTransactionByTxHash() {
        String txHash = "0x1e14311142db1f5b02e587f0e00643f7fd460c81e73dffff65cf501123fb99dd";
        ApiResponse<MPCTransactionInfos> res = mpcClient.getTransactionByTxHash(txHash, null);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testListWalletTransactions() {
        Long startTime = null;
        Long endTime = null;
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

    @Test
    public void testListRequests() {
        Integer requestType = null;
        Integer status = null;
        ApiResponse<MPCTssNodeRequests> res = mpcClient.listRequests(requestType, status);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void listSpendable(){
        String coin = "BTC";
        String address = null;
        ApiResponse<MPCListSpendable> res = mpcClient.listSpendable(coin, address);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }
}
