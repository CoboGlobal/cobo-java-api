package com.cobo.api.client.impl;

import com.cobo.api.client.CoboApiClientFactory;
import com.cobo.api.client.CoboApiRestClient;
import com.cobo.api.client.domain.*;
import com.cobo.api.client.domain.account.*;
import com.cobo.api.client.domain.staking.*;
import com.cobo.api.client.domain.transaction.Side;
import com.cobo.api.client.domain.transaction.Transaction;
import junit.framework.TestCase;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CoboApiRestClientImplTest extends TestCase {
    private final String apiKey = "0397ef0d81938bcf9587466ee33ab93caa77677416ada3297e70e92aa42245d99e";
    private final String apiSecret = "e7e73fabdd9edb8bddf947954c400a63bf93edc57abf170544ec570757df5453";
    private final String coboPub = "032f45930f652d72e0c90f71869dfe9af7d713b1f67dc2f7cb51f9572778b9c876";
    private CoboApiRestClient client;

    public void setUp() throws Exception {
        super.setUp();
        client = CoboApiClientFactory.newInstance(
                apiKey,
                new LocalSigner(apiSecret),
                coboPub).newRestClient();
    }

    public void tearDown() throws Exception {
    }

    public void testGetOrgInfo() {
        ApiResponse<OrgInfo> res = client.getOrgInfo();
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
        res.getResult().forEach(t-> System.out.println(t.getCoin()));
    }
    void printDoc(String desc, String code, Object o) {
        System.out.println(String.format("#### %s", desc));
        System.out.println("```java");
        System.out.println(String.format("%s", code));
        System.out.println("```");
        System.out.println("<details>");
        System.out.println("<summary>View Response</summary>");
        System.out.println("\n");
        System.out.println("```java");
        System.out.println(String.format("%s",printObject(o)));
        System.out.println("```");
        System.out.println("</details>\n");
    }
    String printObject(Object o) {
        if (o instanceof List) {
            List<Object> list = (List<Object>) o;
            if (list.size() > 5) {
                return list.subList(0,5).toString();
            } else {
                return o.toString();
            }

        } else {
            return o.toString();
        }
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