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
        Response<OrgInfo> orgInfo = client.getOrgInfo();
        assertTrue(orgInfo.isSuccess());
        System.out.println(orgInfo.getResult());
    }

    public void testGetCoinInfo() {
        Response<CoinInfo> coinInfo = client.getCoinInfo("ETH");
        assertTrue(coinInfo.isSuccess());
        System.out.println(coinInfo.getResult());
    }

    public void testNewAddress() {
        Response<Address> res = client.newAddress("ETH", false);
        assertTrue(res.isSuccess());
    }

    public void testNewAddresses() {
        Response<NewAddresses> res = client.newAddresses("ETH", 4, false);
        assertTrue(res.isSuccess());
    }

    public void testAddressInfo() {
        Response<Address> res = client.addressInfo("ETH", "0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee");
        assertTrue(res.isSuccess());
    }

    public void testAddressesInfo() {
        List<String> list = new ArrayList<>();
        list.add("0x05325e6f9d1f0437bd78a72c2ae084fbb8c039ee");
        list.add("0xe105a42297428575086387de415900a08765a8af");
        list.add("0x641733cde30e99fe0d6082c2ed96601c37a1718b");
        list.add("0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d");

        Response<Addresses> res = client.addressesInfo("ETH", list);
        assertTrue(res.isSuccess());
    }

    public void testIsValidAddress() {
        Response<Boolean> res = client.isValidAddress("ETH", "0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d");
        assertTrue(res.getResult());
        res = client.isValidAddress("ETH", "0xf3a4a281e92631cb06b53895b6db25c6ffcf7c3d11");
        assertFalse(res.getResult());
    }

    public void testGetAddressHistory() {
        Response<List<Address>> res = client.getAddressHistory("ETH");
        assertTrue(res.isSuccess());
    }

    public void testGetInternalAddressInfo() {
        Response<InternalAddressInfo> res = client.getInternalAddressInfo("ETH", "0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a");
        assertTrue(res.isSuccess());
        System.out.println(res.getResult().toString());
    }

    public void testGetInternalAddressInfoBatch() {
        Response<List<InternalAddressInfo>> res = client.getInternalAddressInfoBatch("ETH", "0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a,0xe7ebdc5bbb6c99cc8f7f2c1c83ff38aa6647f38a");
        System.out.println(res.getResult());
    }

    public void testGetTransaction() {
        Response<Transaction> res = client.getTransaction("20210422193807000343569000002370");
        assertTrue(res.isSuccess());
    }

    public void testGetTransactionsById() {
        Response<List<Transaction>> res = client.getTransactionsById(null, Side.Any, null, null, null, 50, null);
        assertTrue(res.isSuccess());
        System.out.println(res.getResult().size());
    }

    public void testGetTransactionsByTime() {
        Response<List<Transaction>> res = client.getTransactionsByTime(null, Side.Any, null,0 , 0, 50, null);
        assertTrue(res.isSuccess());
        assertTrue(res.getResult().size() > 0);
    }

    public void testGetPendingTransactions() {
        Response<List<Transaction>> pendingTransactions = client.getPendingTransactions(null, Side.Any, null, null, 50);
        assertTrue(pendingTransactions.isSuccess());
    }

    public void testGetPendingTransaction() {
        Response<Transaction> res = client.getPendingTransaction("20200604171238000354106000006405");
        assertTrue(res.isSuccess());
    }

    public void testGetTransactionHistory() {
        Response<List<Transaction>> res = client.getTransactionHistory("ETH", Side.Any, null, null, null, 50, 0, System.currentTimeMillis(), null);
        assertTrue(res.isSuccess());
        System.out.println(res.getResult().get(0));
    }
}