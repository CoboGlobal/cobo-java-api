package com.cobo.api.client.impl;

import com.cobo.api.client.ApiSigner;
import com.cobo.api.client.CoboApiRestClient;
import com.cobo.api.client.domain.*;

import java.util.List;

import static com.cobo.api.client.impl.CoboApiServiceGenerator.createService;
import static com.cobo.api.client.impl.CoboApiServiceGenerator.executeSync;

public class CoboApiRestClientImpl implements CoboApiRestClient {
    private final CoboApiService coboApiService;

    public CoboApiRestClientImpl(String apiKey, ApiSigner signer, String coboPub) {
        coboApiService = createService(CoboApiService.class, apiKey, signer, coboPub);
    }

    @Override
    public Response<OrgInfo> getOrgInfo() {
        return executeSync(coboApiService.getOrgInfo());
    }

    @Override
    public Response<CoinInfo> getCoinInfo(String coin) {
        return executeSync(coboApiService.getCoinInfo(coin));
    }

    @Override
    public Response<Address> newAddress(String coin, boolean native_segwit) {
        return native_segwit ?
                executeSync(coboApiService.newAddress(coin, true))
                :
                executeSync(coboApiService.newAddress(coin));

    }

    @Override
    public Response<NewAddresses> newAddresses(String coin, int count, boolean native_segwit) {
        return native_segwit ?
                executeSync(coboApiService.newAddresses(coin, count, true))
                :
                executeSync(coboApiService.newAddresses(coin, count));
    }

    @Override
    public Response<Address> addressInfo(String coin, String address) {
        return executeSync(coboApiService.addressInfo(coin, address));
    }

    @Override
    public Response<Addresses> addressesInfo(String coin, List<String> addresses) {
        String concatAddresses = addresses.stream().reduce((s1, s2) -> s1 + "," + s2).orElse("");
        return executeSync(coboApiService.addressesInfo(coin, concatAddresses));
    }

    @Override
    public Response<Boolean> isValidAddress(String coin, String address) {
        return executeSync(coboApiService.isValidAddress(coin, address));
    }

    @Override
    public Response<List<Address>> getAddressHistory(String coin) {
        return executeSync(coboApiService.getAddressHistory(coin));
    }

    @Override
    public Response<InternalAddressInfo> getInternalAddressInfo(String coin, String address) {
        return executeSync(coboApiService.getInternalAddressInfo(coin, address));
    }

    @Override
    public Response<List<InternalAddressInfo>> getInternalAddressInfoBatch(String coin, String addresses) {
        return executeSync(coboApiService.getInternalAddressInfoBatch(coin, addresses));
    }

    @Override
    public Response<Transaction> getTransaction(String txId) {
        return executeSync(coboApiService.getTransaction(txId));
    }

    @Override
    public Response<List<Transaction>> getTransactionsById(String coin, Side side, String address, String maxId, String minId, int limit, String includeFinancial) {
        return executeSync(coboApiService.getTransactionsById(coin, side.getValue(), address, maxId, minId, limit, includeFinancial));
    }

    @Override
    public Response<List<Transaction>> getTransactionsByTime(String coin, Side side, String address, long beginTime, long endTime, int limit, String includeFinancial) {
        return executeSync(coboApiService.getTransactionsByTime(coin,
                side.getValue(), address,
                longToString(beginTime),
                longToString(endTime),
                intToString(limit),
                includeFinancial));
    }

    @Override
    public Response<List<Transaction>> getPendingTransactions(String coin, Side side, String max_id, String min_id, int limit) {
        return executeSync(coboApiService.getPendingTransactions(coin, side.getValue(), max_id, min_id, limit == 0 ? "50" : String.valueOf(limit)));
    }

    @Override
    public Response<Transaction> getPendingTransaction(String id) {
        return executeSync(coboApiService.getPendingTransaction(id));
    }

    @Override
    public Response<List<Transaction>> getTransactionHistory(String coin, Side side, String address, String maxId, String minId, int limit, long beginTime, long endTime, String includeFinancial) {
        return executeSync(coboApiService.getTransactionHistory(coin, side.getValue(), address, maxId, minId, intToString(limit), longToString(beginTime), longToString(endTime), includeFinancial));
    }

    private String intToString(int num){
        if (num == 0) return null;
        return String.valueOf(num);
    }

    private String longToString(long num){
        if (num == 0) return null;
        return String.valueOf(num);
    }

}
