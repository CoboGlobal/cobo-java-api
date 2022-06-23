package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.staking.*;
import com.cobo.custody.api.client.domain.transaction.Side;
import com.cobo.custody.api.client.domain.transaction.Transaction;
import junit.framework.TestCase;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CoboApiRestClientImplTest extends TestCase {
    //refer README "Generate Key Pair"
    private final String apiSecret = "apiSecret";
    private CoboApiRestClient client;

    public void setUp() throws Exception {
        super.setUp();
        client = CoboApiClientFactory.newInstance(
                new LocalSigner(apiSecret),
                Env.SANDBOX,
                true).newRestClient();
    }

    public void tearDown() {
    }

    public void testGenerateKeyPair() {
        String[] key = LocalSigner.generateKeyPair();
        System.out.println(key[0]);
        System.out.println(key[1]);
    }

    public void testGetOrgInfo() {
        ApiResponse<OrgInfo> res = client.getOrgInfo();
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    public void testGetCoinInfo() {
        ApiResponse<CoinInfo> res = client.getCoinInfo("ETH");
        assertTrue(res.isSuccess());
    }

    public void testNewAddress() {
        ApiResponse<Address> res = client.newAddress("ETH", false);
        assertTrue(res.isSuccess());
    }

    public void testNewAddresses() {
        ApiResponse<NewAddresses> res = client.newAddresses("ETH", 4, false);
        assertTrue(res.isSuccess());
    }

    public void testAddressInfo() {
        ApiResponse<Address> res = client.addressInfo("ETH", "0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee");
        assertTrue(res.isSuccess());
    }

    public void testAddressesInfo() {
        List<String> list = new ArrayList<>();
        list.add("0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee");
        list.add("0xe105a42297428575086387de415900a08765a8af");
        list.add("0x641733cde30e99fe0d6082c2ed96601c37a1718b");
        list.add("0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d");

        ApiResponse<Addresses> res = client.addressesInfo("ETH", list);
        assertTrue(res.isSuccess());

    }

    public void testIsValidAddress() {
        ApiResponse<Boolean> res = client.isValidAddress("ETH", "0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d");
        assertTrue(res.getResult());
    }

    public void testGetAddressHistory() {
        ApiResponse<List<Address>> res = client.getAddressHistory("ETH");
        assertTrue(res.isSuccess());
    }

    public void testGetInternalAddressInfo() {
        ApiResponse<InternalAddressInfo> res = client.getInternalAddressInfo("ETH", "0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a");
        assertTrue(res.isSuccess());
    }

    public void testGetInternalAddressInfoBatch() {
        ApiResponse<List<InternalAddressInfo>> res = client.getInternalAddressInfoBatch("ETH", "0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a,0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a");
        assertTrue(res.isSuccess());
    }

    public void testGetTransactionById() {
        ApiResponse<Transaction> res = client.getTransactionById("20210422193807000343569000002370");
        assertTrue(res.isSuccess());
    }

    public void testGetTransactionByTxId() {
        ApiResponse<List<Transaction>> res = client.getTransactionByTxId("0x5d5396c3992ed524bf68a22a7ab6ae503f0349354ad69bc5204d5214085d4e9f");
        assertTrue(res.isSuccess());
        System.out.println(res.getResult());
        assertTrue(res.getResult().size() > 0);
    }

    public void testGetTransactionsById() {
        ApiResponse<List<Transaction>> res = client.getTransactionsById(null, Side.Any, null, null, null, 2, null);
        assertTrue(res.isSuccess());
    }

    public void testGetTransactionsByTime() {
        ApiResponse<List<Transaction>> res = client.getTransactionsByTime(null, Side.Any, null, 0, 0, 2, null);
        assertTrue(res.isSuccess());
        assertTrue(res.getResult().size() > 0);
    }

    public void testGetPendingTransactions() {
        ApiResponse<List<Transaction>> pendingTransactions = client.getPendingTransactions(null, Side.Any, null, null, 50);
        assertTrue(pendingTransactions.isSuccess());
    }

    public void testGetPendingTransaction() {
        ApiResponse<Transaction> res = client.getPendingTransaction("20200604171238000354106000006405");
        assertTrue(res.isSuccess());
    }

    public void testGetTransactionHistory() {
        ApiResponse<List<Transaction>> res = client.getTransactionHistory("ETH", Side.Any, null, null, null, 50, 0, System.currentTimeMillis(), null);
        assertTrue(res.isSuccess());
    }

    public void testWithdraw() {
        ApiResponse<String> res = client.withdraw("TETH",
                UUID.randomUUID().toString(),
                "0xb744adc8d75e115eec8e582eb5e8d60eb0972037",
                new BigInteger("1"), "cobo", null, null);
        assertTrue(res.isSuccess());
    }

    public void testQueryWithdrawInfo() {
        ApiResponse<Transaction> res = client.queryWithdrawInfo("teth29374893624");
        System.out.println(res.toString());
        assertTrue(res.isSuccess());
    }

    public void testGetStakingProducts() {
        ApiResponse<List<StakingProduct>> res = client.getStakingProducts(null, Lang.ENGLISG);
        assertTrue(res.isSuccess());
        System.out.println(res.getResult());
    }

    public void testGetStakingProductById() {
        ApiResponse<StakingProduct> res = client.getStakingProductById("159145", Lang.ENGLISG);
        assertTrue(res.isSuccess());
    }

    public void testGetStakings() {
        ApiResponse<List<StakingData>> res = client.getStakings(null, Lang.ENGLISG);
        assertTrue(res.isSuccess());
    }

    public void testGetUnstakings() {
        ApiResponse<List<Unstaking>> res = client.getUnstakings(null, Lang.ENGLISG);
        assertTrue(res.isSuccess());
    }

    public void testGetStakingHistory() {
        ApiResponse<List<StakingHistory>> res = client.getStakingHistory(null, null, null, null, null);
        assertTrue(res.isSuccess());
    }

    public void testStake() {
        ApiResponse<Void> res = client.stake("159165", new BigInteger("1000000"));
        System.out.println(res.toString());
    }

    public void testUnstake() {
        ApiResponse<Void> res = client.unstake("159165", new BigInteger("1000000"));
        System.out.println(res.toString());
    }

    public void testTradingWithdraw() {
    }

    public void testGetTradingWithdrawInfo() {
    }

    public void testTradingDeposit() {
    }

    public void testGetTradingDepositInfo() {
    }

    public void testTradingTransfer() {
    }

    public void testGetTradingTransferInfo() {
    }
}