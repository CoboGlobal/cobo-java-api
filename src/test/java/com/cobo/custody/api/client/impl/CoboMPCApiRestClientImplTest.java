package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboMPCApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.transaction.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoboMPCApiRestClientImplTest {
    private String MPCAPISecret = "";
    private CoboMPCApiRestClient mpcClient;
    private Env TestEnv = Env.DEV;

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
    public void testGetSupportedCoins() {
        String chainCode = "GETH";
        ApiResponse<MPCCoins> res = mpcClient.getSupportedCoins(chainCode);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetWalletSupportedCoins() {
        ApiResponse<MPCWalletCoins> res = mpcClient.getWalletSupportedCoins();
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testIsValidAddress() {
        String coin = "GETH";
        String address = "0x3ede1e59a3f3a66de4260df7ba3029b515337e5c";
        ApiResponse<Boolean> res = mpcClient.isValidAddress(coin, address);
        assertTrue(res.isSuccess());
        assertTrue(res.getResult());
    }

    @Test
    public void testGenerateAddresses() {
        String chainCode = "GETH";
        int count = 2;
        ApiResponse<MPCAddressList> res = mpcClient.generateAddresses(chainCode, count);
        System.out.println(res);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testUpdateAddressDescription() {
        String coin = "GETH";
        String address = "0x6a060efe0ff887f4e24dc2d2098020abf28bcce4";
        String description = "test";
        ApiResponse<MPCAddress> res = mpcClient.updateAddressDescription(coin, address, description);
        System.out.println(res);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testListAddresses() {
        String chainCode = "GETH";
        String startId = "831317442287190282";
        String endId = "831317442287190284";
        int limit = 50;
        int sort = 1;
        ApiResponse<MPCAddresses> res = mpcClient.listAddresses(chainCode, startId, endId, limit, sort);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetBalance() {
        String address = "0x6a060efe0ff887f4e24dc2d2098020abf28bcce4";
        String chainCode = null;
        String coin = "GETH";
        ApiResponse<MPCBalance> res = mpcClient.getBalance(address, chainCode, coin);
        System.out.println(res);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testListBalances() {
        String coin = "GETH";
        String chainCode = "GETH";
        Integer pageIndex = 0;
        Integer pageLength = 50;
        ApiResponse<MPCListBalances> res = mpcClient.listBalances(coin, pageIndex, pageLength, chainCode);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testCreateTransaction() {
        String coin = "GETH";
        String requestId = String.valueOf(System.currentTimeMillis());
        String fromAddr = "0x6a060efe0ff887f4e24dc2d2098020abf28bcce4";
        String toAddr = "0x6a060efe0ff887f4e24dc2d2098020abf28bcce4";
        BigInteger amount = new BigInteger("10");
        String toAddressDetails = null;
        BigDecimal fee = null;
        BigInteger gasPrice = null;
        BigInteger gasLimit = null;
        Integer operation = null;
        String extraParameters = null;
        ApiResponse<MPCPostTransaction> res = mpcClient.createTransaction(coin, requestId, amount, fromAddr, toAddr,
                toAddressDetails, fee, gasPrice, gasLimit, operation, extraParameters, null, null, null, null);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetTransactionByRequestIds() {
        String requestIds = "1668678820274";
        ApiResponse<MPCTransactionInfos> res = mpcClient.transactionsByRequestIds(requestIds, null);
        System.out.println(res);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetTransactionByTxHash() {
        String txHash = "0x1e14311142db1f5b02e587f0e00643f7fd460c81e73dffff65cf501123fb99dd";
        ApiResponse<MPCTransactionInfos> res = mpcClient.transactionsByTxhash(txHash, null);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testListTransactions() {
        Long startTime = null;
        Long endTime = null;
        Integer status = null;
        String orderBy = null;
        String order = null;
        Integer transactionType = null;
        String coins = null;
        String fromAddress = null;
        String toAddress = null;
        Integer limit = null;

        ApiResponse<MPCTransactions> res = mpcClient.listTransactions(startTime, endTime, status, orderBy, order,
                transactionType, coins, fromAddress, toAddress, limit);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Disabled("skip it temporarily")	
    @Test
    public void testListTssNodeRequests() {
        Integer requestType = null;
        Integer status = null;
        ApiResponse<MPCTssNodeRequests> res = mpcClient.listTssNodeRequests(requestType, status);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testListTssNodes() {
        ApiResponse<TssNodes> res = mpcClient.listTssNodes();
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void listSpendable() {
        String coin = "GETH";
        String address = null;
        ApiResponse<MPCListSpendable> res = mpcClient.listSpendable(coin, address);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testEstimateFee() {
        String coin = "GETH";
        BigInteger amount = new BigInteger("10000");
        String address = "0xEEACb7a5e53600c144C0b9839A834bb4b39E540c";
        ApiResponse<EstimateFeeDetails> res = mpcClient.estimateFee(coin, amount, address, null,
                null, null, null, null, null, null);
        System.out.println(res.getResult());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testRetryDoubleCheck() {
        String requestId = "123";
        ApiResponse<Void> res = mpcClient.retryDoubleCheck(requestId);
        System.out.println(res);
        assertFalse(res.isSuccess());
    }

    @Test
    public void testsignMessageByRequestIds() {
        String requestIds = "1690349242683,1690268795963,1690187858862";
        ApiResponse<SignMessages> res = mpcClient.signMessageByRequestIds(requestIds);
        System.out.println(res);
    }

    @Test
    public void testsignMessageByCoboIds() {
        String coboIds = "20230726132723000341052000008222,20230725150636000308867000003494,20230725135301000361318000002480";
        ApiResponse<SignMessages> res = mpcClient.signMessageByCoboIds(coboIds);
        System.out.println(res);
    }

    @Test
    public void testGetMaxSendAmount() {
        ApiResponse<GetSendMaxDetail> res = mpcClient.getMaxSendAmount("", null, "", "");
        System.out.println(res);
    }
}
