package com.cobo.api.client.impl;

import com.cobo.api.client.CoboApiClientFactory;
import com.cobo.api.client.CoboApiRestClient;
import com.cobo.api.client.domain.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

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
        printDoc("Get org info","ApiResponse<OrgInfo> orgInfo = client.getOrgInfo()",res.getResult());
    }

    public void testGetCoinInfo() {
        ApiResponse<CoinInfo> res = client.getCoinInfo("ETH");
        assertTrue(res.isSuccess());
        printDoc("Get coin info","ApiResponse<CoinInfo> coinInfo = client.getCoinInfo(\"ETH\")",res.getResult());
    }

    public void testNewAddress() {
        ApiResponse<Address> res = client.newAddress("ETH", false);
        assertTrue(res.isSuccess());
        printDoc("Get new address","ApiResponse<Address> res = client.newAddress(\"ETH\", false);",res.getResult());
    }

    public void testNewAddresses() {
        ApiResponse<NewAddresses> res = client.newAddresses("ETH", 4, false);
        assertTrue(res.isSuccess());
        printDoc("Batch get new addresses","ApiResponse<Address> res = client.newAddress(\"ETH\", false);",res.getResult());
    }

    public void testAddressInfo() {
        ApiResponse<Address> res = client.addressInfo("ETH", "0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee");
        assertTrue(res.isSuccess());
        printDoc("Get address info","ApiResponse<Address> res = client.addressInfo(\"ETH\", \"0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee\");",res.getResult());
    }

    public void testAddressesInfo() {
        List<String> list = new ArrayList<>();
        list.add("0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee");
        list.add("0xe105a42297428575086387de415900a08765a8af");
        list.add("0x641733cde30e99fe0d6082c2ed96601c37a1718b");
        list.add("0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d");

        ApiResponse<Addresses> res = client.addressesInfo("ETH", list);
        assertTrue(res.isSuccess());
        printDoc("Batch get address info","List<String> list = new ArrayList<>();\n" +
                "        list.add(\"0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee\");\n" +
                "        list.add(\"0xe105a42297428575086387de415900a08765a8af\");\n" +
                "        list.add(\"0x641733cde30e99fe0d6082c2ed96601c37a1718b\");\n" +
                "        list.add(\"0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d\");\n" +
                "\n" +
                "        ApiResponse<Addresses> res = client.addressesInfo(\"ETH\", list);",res.getResult());
    }

    public void testIsValidAddress() {
        ApiResponse<Boolean> res = client.isValidAddress("ETH", "0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d");
        assertTrue(res.getResult());
        printDoc("Is valid address","ApiResponse<Boolean> res = client.isValidAddress(\"ETH\", \"0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d\");",res.getResult());
    }

    public void testGetAddressHistory() {
        ApiResponse<List<Address>> res = client.getAddressHistory("ETH");
        assertTrue(res.isSuccess());
        printDoc("Get address history","ApiResponse<List<Address>> res = client.getAddressHistory(\"ETH\");",res.getResult());
    }

    public void testGetInternalAddressInfo() {
        ApiResponse<InternalAddressInfo> res = client.getInternalAddressInfo("ETH", "0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a");
        assertTrue(res.isSuccess());
        printDoc("Get internal address info","ApiResponse<InternalAddressInfo> res = client.getInternalAddressInfo(\"ETH\", \"0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a\");",res.getResult());
    }

    public void testGetInternalAddressInfoBatch() {
        ApiResponse<List<InternalAddressInfo>> res = client.getInternalAddressInfoBatch("ETH", "0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a,0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a");
        assertTrue(res.isSuccess());
        printDoc("Batch get internal address info","ApiResponse<List<InternalAddressInfo>> res = client.getInternalAddressInfoBatch(\"ETH\", \"0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a,0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a\");",res.getResult());
    }

    public void testGetTransaction() {
        ApiResponse<Transaction> res = client.getTransactionById("20210422193807000343569000002370");
        assertTrue(res.isSuccess());
        printDoc("Get transaction Details", "ApiResponse<Transaction> res = client.getTransactionById(\"20210422193807000343569000002370\");", res.getResult());
    }

    public void testGetTransactionsById() {
        ApiResponse<List<Transaction>> res = client.getTransactionsById(null, Side.Any, null, null, null, 2, null);
        assertTrue(res.isSuccess());
        printDoc("Obtain the list of confirmed transactions through ID query(deposit&withdraw)","ApiResponse<List<Transaction>> res = client.getTransactionsById(null, Side.Any, null, null, null, 2, null);",res.getResult());
    }

    public void testGetTransactionsByTime() {
        ApiResponse<List<Transaction>> res = client.getTransactionsByTime(null, Side.Any, null, 0, 0, 2, null);
        assertTrue(res.isSuccess());
        assertTrue(res.getResult().size() > 0);
        printDoc("Obtain the list of confirmed transactions through time query(deposit&withdraw)",
                "ApiResponse<List<Transaction>> res = client.getTransactionsByTime(null, Side.Any, null, 0, 0, 2, null);",res.getResult());

    }

    public void testGetPendingTransactions() {
        ApiResponse<List<Transaction>> pendingTransactions = client.getPendingTransactions(null, Side.Any, null, null, 50);
        assertTrue(pendingTransactions.isSuccess());
        printDoc("Get pending transactions","ApiResponse<List<Transaction>> pendingTransactions = client.getPendingTransactions(null, Side.Any, null, null, 50);",pendingTransactions.getResult());
    }

    public void testGetPendingTransaction() {
        ApiResponse<Transaction> res = client.getPendingTransaction("20200604171238000354106000006405");
        assertTrue(res.isSuccess());
        printDoc("Get pending transaction by id","ApiResponse<Transaction> res = client.getPendingTransaction(\"20200604171238000354106000006405\");",res.getResult());
    }

    public void testGetTransactionHistory() {
        ApiResponse<List<Transaction>> res = client.getTransactionHistory("ETH", Side.Any, null, null, null, 50, 0, System.currentTimeMillis(), null);
        assertTrue(res.isSuccess());
        res.getResult().forEach(t->{
            System.out.println(t.getCoin());
        });
        printDoc("Get transaction history","ApiResponse<List<Transaction>> res = client.getTransactionHistory(\"ETH\", Side.Any, null, null, null, 50, 0, System.currentTimeMillis(), null);", res.getResult());
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

    public void testGetTransactionById() {
        ApiResponse<String> res = client.withdraw("XTN",
                "api_request20210520",
                "mumMe9wWeLb26oGKf334CKiRYiWMpmKpUp",
                "0.00000547", "", null,
                null);
        System.out.println(res.toString());
    }

    public void testWithdraw() {
        ApiResponse<String> res = client.withdraw("TETH",
                "api_request_id_8888888",
                "0xb744adc8d75e115eec8e582eb5e8d60eb0972037",
                "1", "cobo", null, "true");
        //assertTrue(res.isSuccess());
        System.out.println(res);
        printDoc("Submit Withdraw Request","ApiResponse<String> res = client.withdraw(\"TETH\",\n" +
                "                \"api_request_id_8888888\",\n" +
                "                \"0xb744adc8d75e115eec8e582eb5e8d60eb0972037\",\n" +
                "                \"1\", null, \"true\", null);",res.getResult());
    }

    public void testQueryWithdrawInfo() {
        ApiResponse<Transaction> res = client.queryWithdrawInfo("web_send_by_user_819_1621570527307");
        System.out.println(res.toString());
        assertTrue(res.isSuccess());
        printDoc("Get Withdraw Infomation","ApiResponse<Transaction> res = client.queryWithdrawInfo(\"wr_web_send_by_user_6_1575956443374\");", res.getResult());
    }

    public void testGetStakingProducts() {
        ApiResponse<List<StakingProduct>> res = client.getStakingProducts(null, Lang.ENGLISG);
        assertTrue(res.isSuccess());
        printDoc("2. Get All Staking Product List","ApiResponse<List<StakingProduct>> res = client.getStakingProducts(null, Lang.CHINESE);", res.getResult());
    }

    public void testGetStakingProductById() {
        ApiResponse<StakingProduct> res = client.getStakingProductById("159145", Lang.ENGLISG);
        assertTrue(res.isSuccess());
        printDoc("1. Get a Staking Product Details","ApiResponse<List<StakingProduct>> res = client.getStakingProducts(null, Lang.CHINESE);", res.getResult());
    }

    public void testGetStakings() {
        ApiResponse<List<StakingProduct>> res = client.getStakings(null, Lang.ENGLISG);
        assertTrue(res.isSuccess());
        System.out.println(res.getResult());
        printDoc("5. Get Staking Data","ApiResponse<List<StakingProduct>> res = client.getStakings(null, Lang.ENGLISG);", res.getResult());
    }

    public void testGetUnstakings() {
        ApiResponse<List<Unstaking>> res = client.getUnstakings(null, Lang.ENGLISG);
        assertTrue(res.isSuccess());
        System.out.println(res.getResult());
        printDoc("6. Get Unstaking Data","ApiResponse<List<Unstaking>> res = client.getUnstakings(null, Lang.ENGLISG);", res.getResult());
    }

    public void testGetStakingHistory() {
        ApiResponse<List<StakingHistory>> res = client.getStakingHistory(null, null, null, null, null);
        assertTrue(res.isSuccess());
        printDoc("7. Get All Staking History",
                "ApiResponse<List<StakingHistory>> res = client.getStakingHistory(null, null, null, null, null);", res.getResult());
    }

    public void testStake() {
    }

    public void testUnstake() {
    }
}