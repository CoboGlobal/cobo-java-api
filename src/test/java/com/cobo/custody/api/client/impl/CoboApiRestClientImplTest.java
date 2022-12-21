package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.config.TESTDATA;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.enums.SortFlagEnum;
import com.cobo.custody.api.client.domain.staking.*;
import com.cobo.custody.api.client.domain.transaction.Side;
import com.cobo.custody.api.client.domain.transaction.Transaction;
import com.fasterxml.jackson.databind.JsonSerializer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CoboApiRestClientImplTest{
    //refer README "Generate Key Pair"
    private String APISecret = "";
    private CoboApiRestClient client;
    private Env TestEnv= Env.SANDBOX;
    private TESTDATA TestData = TESTDATA.SANDBOX_TESTDATA;

    @BeforeEach
    public void setUp() throws Exception {
        APISecret = System.getProperty("ApiSecret");
        if(System.getProperty("Env") == "prod"){
            TestEnv = Env.PROD;
            TestData = TESTDATA.PROD_TESTDATA;}
        else{
            TestEnv = Env.SANDBOX;
            TestData = TESTDATA.SANDBOX_TESTDATA;
        }
        client = CoboApiClientFactory.newInstance(
                new LocalSigner(APISecret),
                TestEnv,
                true).newRestClient();
    }

    public void tearDown() {
    }

    @Test
    public void testGenerateKeyPair() {
        String[] key = LocalSigner.generateKeyPair();
        System.out.println("testGenerateKeyPair");
        System.out.println(key[0]);
        System.out.println(key[1]);
    }

    @Test
    public void testGetOrgInfo() {
        ApiResponse<OrgInfo> res = client.getOrgInfo();
        System.out.println(res);
        assertTrue(res.isSuccess());
    }

    @ParameterizedTest(name="testGetValidCoinInfo({0})_{index}")
    @CsvSource({"BTC","ETH","ETH_USDT","XRP"})
    public void testGetValidCoinInfo(String coin) {
        ApiResponse<CoinInfo> res = client.getCoinInfo(coin);
        assertTrue(res.isSuccess());
    }

    @ParameterizedTest(name="testGetInvalidCoinInfo({0})_{index}")
    @CsvSource({"BTT"})
    public void testGetInvalidCoinInfo(String coin) {
        ApiResponse<CoinInfo> res = client.getCoinInfo(coin);
        System.out.println(res);
        assertFalse(res.isSuccess());
    }

    @ParameterizedTest(name="testNewValidAddress({0})_{index}")
    @CsvSource({"BTC,true","BTC,false","ETH,false","ETH_USDT,false","XRP,false"})
    public void testNewValidAddress(String coin, boolean nativeSegwit) {
        ApiResponse<Address> res = client.newAddress(coin, nativeSegwit);
        assertTrue(res.isSuccess());
    }

    @ParameterizedTest(name="testNewInvalidAddress({0})_{index}")
    @CsvSource({"BTT,true"})
    public void testNewInvalidAddress(String coin, boolean nativeSegwit){
        ApiResponse<Address> res = client.newAddress(coin, false);
        System.out.println(res);
        assertFalse(res.isSuccess());
    }

    @ParameterizedTest(name="testNewValidAddresses({0})_{index}")
    @CsvSource({"BTC,2,true","BTC,2,false","ETH,2,false","ETH_USDT,2,alse","XRP,2,false"})
    public void testNewValidAddresses(String coin, int count, boolean nativeSegwit) {
        ApiResponse<NewAddresses> res = client.newAddresses(coin, count, nativeSegwit);
        assertTrue(res.isSuccess());
    }

    @ParameterizedTest(name="testNewInvalidAddresses({0})_{index}")
    @CsvSource({"BTT,2,true","ETT,2,false"})
    public void testNewInvalidAddresses(String coin, int count, boolean nativeSegwit) {
        ApiResponse<NewAddresses> res = client.newAddresses(coin, count, nativeSegwit);
        System.out.println(res);
        assertFalse(res.isSuccess());
    }

    @ParameterizedTest(name="testValidAddressInfo({0})_{index}")
    @CsvSource({"BTC","XRP"})
    public void testValidAddressInfo(String coin) {
        ApiResponse<Address> res = client.addressInfo(coin, TestData.depositAddress.get(coin));
        assertTrue(res.isSuccess());
    }

    @ParameterizedTest(name="testInvalidAddressInfo({0})_{index}")
    @CsvSource({"BTC,3Kd5rjiLtvpHv5nhYQNTTeRLgrz4om32PJ","XRP,rndm7RphBZG6CpZvKcG9AjoFbSvcKhwLCx"})
    public void testInvalidAddressInfo(String coin, String address) {
        ApiResponse<Address> res = client.addressInfo(coin, address);
        assertFalse(res.isSuccess());
        assertEquals(res.getErrorCode(),12015);
    }

    @ParameterizedTest(name="testValidAddressInfo({0})_{index}")
    @CsvSource({"BTC","XRP"})
    public void testValidAddressesInfo(String coin) {
        ApiResponse<Addresses> res = client.addressesInfo(coin, TestData.depositAddresses.get(coin));
        assertTrue(res.isSuccess());
    }

    @ParameterizedTest(name="testInvalidAddressesInfo({0})_{index}")
    @CsvSource({"BTC,3CGPhZFgXjVQJDq1S86KiaePtqHULrbCuH:34bH3vfUYKZWFvLSUPiNjCKZGJLedNmCYu",
                "XRP,rndm7RphBZG6CpZvKcG9AjoFbSvcKhwLCx:rrBD4sBsxrpzbohAEYWH4moPSsoxupWLA|00000000"})
    public void testInvalidAddressesInfo(String coin, String addresses) {
        String address[] = addresses.split(":");
        List<String> addressesList = new ArrayList<String>();
        addressesList = Arrays.asList(address);
        ApiResponse<Addresses> res = client.addressesInfo(coin, addressesList);
        assertTrue(res.isSuccess());
        assertEquals(res.getResult().getAddresses(), "");
    }


    @ParameterizedTest(name="testIsValidAddress({0})_{index}")
    @CsvSource({"BTC,3Kd5rjiLtvpHv5nhYQNTTeRLgrz4om32PJ",
                "BTC,bc1q9unqc738dxjg5mk8zqtz33zg59cahrj29s24lp",
                "ETH,0xE410157345be56688F43FF0D9e4B2B38Ea8F7828",
                "ETH_USDT,0xEEACb7a5e53600c144C0b9839A834bb4b39E540c",
                "XRP,rndm7RphBZG6CpZvKcG9AjoFbSvcKhwLCx",
                "XRP,rGNXLMNHkUEtoo7qkCSHEm2sfMo8F969oZ|2200701580"})
    public void testIsValidAddress(String coin, String address) {
        ApiResponse<Boolean> res = client.isValidAddress(coin, address);
        assertTrue(res.isSuccess());
        assertTrue(res.getResult());
    }

    @ParameterizedTest(name="testIsInvalidAddress({0})_{index}")
    @CsvSource({"BTC,0xE410157345be56688F43FF0D9e4B2B38Ea8F7828",
                "XRP,rBWpYJhuJWBPAkzJ4kYQqHShSkkF3rgeDE"})
    public void testIsInvalidAddress(String coin, String address) {
        ApiResponse<Boolean> res = client.isValidAddress(coin, address);
        assertTrue(res.isSuccess());
        assertFalse(res.getResult());
    }

    @ParameterizedTest(name="testGetValidAddressHistory({0})_{index}")
    @CsvSource({"BTC","ETH","ETH_USDT","XRP"})
    public void testGetValidAddressHistory(String coin) {
        ApiResponse<List<Address>> res = client.getAddressHistory(coin);
        assertTrue(res.isSuccess());
    }

    @ParameterizedTest(name="testGetValidAddressHistoryWithValidPage({0})_{index}")
    @CsvSource({"BTC,1,2"})
    public void testGetValidAddressHistoryWithValidPage(String coin, int pageIndex, int pageLength) {
        ApiResponse<List<Address>> res = client.getAddressHistory(coin, pageIndex, pageLength);
        assertTrue(res.isSuccess());
    }

    @ParameterizedTest(name="testGetAddressHistoryWithInvalidPage({0})_{index}")
    @CsvSource({"BTC,1,51",
                "BTC,0,0"})
    public void testGetAddressHistoryWithInvalidPage(String coin, int pageIndex, int pageLength) {
        ApiResponse<List<Address>> res = client.getAddressHistory(coin, pageIndex, pageLength);
        assertFalse(res.isSuccess());
        assertEquals(res.getErrorCode(),1011);
    }

    @ParameterizedTest(name="testGetValidAddressHistoryWithValidPagePositiveOrder({0})_{index}")
    @CsvSource({"BTC,1,2,1"})
    public void testGetValidAddressHistoryWithValidPagePositiveOrder(String coin, int pageIndex, int pageLength, int sortFlag) {
        ApiResponse<List<Address>> res = client.getAddressHistory(coin, pageIndex, pageLength, SortFlagEnum.of(sortFlag));
        assertTrue(res.isSuccess());
    }

    @ParameterizedTest(name="testGetAddressHistoryWithInvalidPagePositiveOrder({0})_{index}")
    @CsvSource({"BTC,1,51,1", "BTC,0,0,1"})
    public void testGetAddressHistoryWithInvalidPagePositiveOrder(String coin, int pageIndex, int pageLength, int sortFlag) {
        ApiResponse<List<Address>> res = client.getAddressHistory(coin, pageIndex, pageLength, SortFlagEnum.of(sortFlag));
        assertFalse(res.isSuccess());
        assertEquals(res.getErrorCode(),1011);
    }

    @ParameterizedTest(name="testGetValidInternalAddressInfo({0})_{index}")
    @CsvSource({"BTC","XRP"})
    public void testGetValidInternalAddressInfo(String coin) {
        ApiResponse<InternalAddressInfo> res = client.getInternalAddressInfo(coin, TestData.loopAddress.get(coin));
        assertTrue(res.isSuccess());
        assertTrue(res.getResult().isInternalAddress());
    }

    @ParameterizedTest(name="testGetInvalidInternalAddressInfo({0})_{index}")
    @CsvSource({"BTC,3CGPhZFgXjVQJDq1S86KiaePtqHULrbCuH",
               "XRP,rndm7RphBZG6CpZvKcG9AjoFbSvcKhwLCx"})
    public void testGetInvalidInternalAddressInfo(String coin, String address) {
        ApiResponse<InternalAddressInfo> res = client.getInternalAddressInfo(coin, address);
        assertTrue(res.isSuccess());
        assertFalse(res.getResult().isInternalAddress());
    }

    @ParameterizedTest(name="testGetValidInternalAddressInfoBatch({0})_{index}")
    @CsvSource({"BTC","XRP"})
    public void testGetValidInternalAddressInfoBatch(String coin) {
        ApiResponse<List<InternalAddressInfo>> res = client.getInternalAddressInfoBatch(coin, TestData.loopAddresses.get(coin));
        assertTrue(res.isSuccess());
        for (int i = 0, n = res.getResult().size(); i < n; i++) {
            assertTrue(res.getResult().get(i).isInternalAddress());
        }
    }

    @Test
    public void testGetTransactionById() {
        ApiResponse<Transaction> res = client.getTransactionById(TestData.coboId);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetTransactionByTxId() {
        ApiResponse<List<Transaction>> res = client.getTransactionByTxId(TestData.txId);
        assertTrue(res.isSuccess());
        System.out.println(res.getResult());
        assertTrue(res.getResult().size() > 0);
    }

    @Test
    public void testGetTransactionsById() {
        ApiResponse<List<Transaction>> res = client.getTransactionsById(null, Side.Any, null, null, null, 2, null);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetTransactionsByTime() {
        ApiResponse<List<Transaction>> res = client.getTransactionsByTime(null, Side.Any, null, 0, 0, 2, null);
        assertTrue(res.isSuccess());
        assertTrue(res.getResult().size() > 0);
    }

    @Test
    public void testGetPendingTransactions() {
        ApiResponse<List<Transaction>> pendingTransactions = client.getPendingTransactions(null, Side.Any, null, null, 50);
        assertTrue(pendingTransactions.isSuccess());
    }

    @Test
    public void testGetPendingTransaction() {
        ApiResponse<List<Transaction>> pendingTransactions = client.getPendingTransactions(null, Side.Any, null, null, 50);
        if (pendingTransactions.getResult().size() > 0) {
            String pendingId = pendingTransactions.getResult().get(0).getId();
            ApiResponse<Transaction> res = client.getPendingTransaction(pendingId);
            assertTrue(res.isSuccess());
        }
    }

    @ParameterizedTest(name="testGetTransactionHistory({0})_{index}")
    @CsvSource({"BTC","ETH","ETH_USDT","XRP"})
    public void testGetTransactionHistory(String coin) {
        ApiResponse<List<Transaction>> res = client.getTransactionHistory(coin, Side.Any, null, null, null, 50, 0, System.currentTimeMillis(), null);
        assertTrue(res.isSuccess());
    }

    @ParameterizedTest(name="testWithdraw({0})_{index}")
    @CsvSource({"COBO_ETH,0xE410157345be56688F43FF0D9e4B2B38Ea8F7828,,1",
                "XLM,GBJDU6TPWHKGV7HRLNTIBA46MG3MB5DUG6BISHX3BF7I75H2HLPV6RJX,4e73f03b,1"})
    public void testWithdraw(String coin, String recriveAddress, String memo, String amount) {
        ApiResponse<String> res = client.withdraw(coin,
                UUID.randomUUID().toString(),
                recriveAddress,
                new BigInteger(amount), memo, null, null);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testQueryWithdrawInfo() {
        ApiResponse<Transaction> res = client.queryWithdrawInfo(TestData.withdrawId);
        System.out.println(res.toString());
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetStakingProducts() {
        ApiResponse<List<StakingProduct>> res = client.getStakingProducts(null, Lang.ENGLISG);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetStakingProductById() {
        ApiResponse<List<StakingProduct>> productsRes = client.getStakingProducts(null, Lang.ENGLISG);
        String Id = String.valueOf(productsRes.getResult().get(0).getProductId());
        ApiResponse<StakingProduct> res = client.getStakingProductById(Id, Lang.ENGLISG);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetStakings() {
        ApiResponse<List<StakingData>> res = client.getStakings(null, Lang.ENGLISG);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetUnstakings() {
        ApiResponse<List<Unstaking>> res = client.getUnstakings(null, Lang.ENGLISG);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testGetStakingHistory() {
        ApiResponse<List<StakingHistory>> res = client.getStakingHistory(null, null, null, null, null);
        assertTrue(res.isSuccess());
    }

    @Test
    public void testStake() {
        ApiResponse<List<StakingProduct>> productsRes = client.getStakingProducts("TETH", Lang.ENGLISG);
        String Id = String.valueOf(productsRes.getResult().get(0).getProductId());
        ApiResponse<Void> res = client.stake(Id, new BigInteger("1000000"));
        assertTrue(res.isSuccess());
        assertEquals(res.getResult(),null);
    }

    @Test
    public void testUnstake() {
        ApiResponse<List<StakingProduct>> productsRes = client.getStakingProducts("TETH", Lang.ENGLISG);
        String Id = String.valueOf(productsRes.getResult().get(0).getProductId());
        ApiResponse<Void> res = client.unstake(Id, new BigInteger("1000000"));
        assertTrue(res.isSuccess());
        assertEquals(res.getResult(), null);

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