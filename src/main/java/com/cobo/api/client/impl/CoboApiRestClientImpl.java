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
    public ApiResponse<OrgInfo> getOrgInfo() {
        return executeSync(coboApiService.getOrgInfo());
    }

    @Override
    public ApiResponse<CoinInfo> getCoinInfo(String coin) {
        return executeSync(coboApiService.getCoinInfo(coin));
    }

    @Override
    public ApiResponse<Address> newAddress(String coin, boolean native_segwit) {
        return native_segwit ?
                executeSync(coboApiService.newAddress(coin, true))
                :
                executeSync(coboApiService.newAddress(coin));

    }

    @Override
    public ApiResponse<NewAddresses> newAddresses(String coin, int count, boolean native_segwit) {
        return native_segwit ?
                executeSync(coboApiService.newAddresses(coin, count, true))
                :
                executeSync(coboApiService.newAddresses(coin, count));
    }

    @Override
    public ApiResponse<Address> addressInfo(String coin, String address) {
        return executeSync(coboApiService.addressInfo(coin, address));
    }

    @Override
    public ApiResponse<Addresses> addressesInfo(String coin, List<String> addresses) {
        String concatAddresses = addresses.stream().reduce((s1, s2) -> s1 + "," + s2).orElse("");
        return executeSync(coboApiService.addressesInfo(coin, concatAddresses));
    }

    @Override
    public ApiResponse<Boolean> isValidAddress(String coin, String address) {
        return executeSync(coboApiService.isValidAddress(coin, address));
    }

    @Override
    public ApiResponse<List<Address>> getAddressHistory(String coin) {
        return executeSync(coboApiService.getAddressHistory(coin));
    }

    @Override
    public ApiResponse<InternalAddressInfo> getInternalAddressInfo(String coin, String address) {
        return executeSync(coboApiService.getInternalAddressInfo(coin, address));
    }

    @Override
    public ApiResponse<List<InternalAddressInfo>> getInternalAddressInfoBatch(String coin, String addresses) {
        return executeSync(coboApiService.getInternalAddressInfoBatch(coin, addresses));
    }

    @Override
    public ApiResponse<Transaction> getTransactionById(String txId) {
        return executeSync(coboApiService.getTransactionById(txId));
    }

    @Override
    public ApiResponse<List<Transaction>> getTransactionsById(String coin, Side side, String address, String maxId, String minId, int limit, String includeFinancial) {
        return executeSync(coboApiService.getTransactionsById(coin, side.getValue(), address, maxId, minId, limit, includeFinancial));
    }

    @Override
    public ApiResponse<List<Transaction>> getTransactionsByTime(String coin, Side side, String address, long beginTime, long endTime, int limit, String includeFinancial) {
        return executeSync(coboApiService.getTransactionsByTime(coin,
                side.getValue(), address,
                longToString(beginTime),
                longToString(endTime),
                intToString(limit),
                includeFinancial));
    }

    @Override
    public ApiResponse<List<Transaction>> getPendingTransactions(String coin, Side side, String max_id, String min_id, int limit) {
        return executeSync(coboApiService.getPendingTransactions(coin, side.getValue(), max_id, min_id, limit == 0 ? "50" : String.valueOf(limit)));
    }

    @Override
    public ApiResponse<Transaction> getPendingTransaction(String id) {
        return executeSync(coboApiService.getPendingTransaction(id));
    }

    @Override
    public ApiResponse<List<Transaction>> getTransactionHistory(String coin, Side side, String address, String maxId, String minId, int limit, long beginTime, long endTime, String includeFinancial) {
        return executeSync(coboApiService.getTransactionHistory(coin, side.getValue(), address, maxId, minId, intToString(limit), longToString(beginTime), longToString(endTime), includeFinancial));
    }

    private String intToString(int num) {
        if (num == 0) return null;
        return String.valueOf(num);
    }

    private String longToString(long num) {
        if (num == 0) return null;
        return String.valueOf(num);
    }

}
