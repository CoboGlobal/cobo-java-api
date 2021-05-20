package com.cobo.api.client;

import com.cobo.api.client.domain.*;
import retrofit2.Call;
import retrofit2.http.Query;

import java.util.List;

public interface CoboApiRestClient {
    ApiResponse<OrgInfo> getOrgInfo();

    ApiResponse<CoinInfo> getCoinInfo(String coin);

    ApiResponse<Address> newAddress(String coin, boolean native_segwit);

    ApiResponse<NewAddresses> newAddresses(String coin, int count, boolean native_segwit);

    ApiResponse<Address> addressInfo(String coin, String address);

    ApiResponse<Addresses> addressesInfo(String coin, List<String> addresses);

    ApiResponse<Boolean> isValidAddress(String coin, String address);

    ApiResponse<List<Address>> getAddressHistory(String coin);

    ApiResponse<InternalAddressInfo> getInternalAddressInfo(String coin, String address);

    ApiResponse<List<InternalAddressInfo>> getInternalAddressInfoBatch(String coin, String addresses);

    ApiResponse<Transaction> getTransactionById(String id);

    ApiResponse<List<Transaction>> getTransactionsById(String coin, Side side,
                                                       String address, String maxId,
                                                       String minId, int limit, String includeFinancial);

    ApiResponse<List<Transaction>> getTransactionsByTime(String coin, Side side,
                                                         String address, long beginTime,
                                                         long endTime, int limit, String includeFinancial);

    ApiResponse<List<Transaction>> getPendingTransactions(String coin, Side side,
                                                          String max_id,
                                                          String min_id, int limit);

    ApiResponse<Transaction> getPendingTransaction(String id);

    ApiResponse<List<Transaction>> getTransactionHistory(String coin, Side side,
                                                         String address, String maxId,
                                                         String minId, int limit, long beginTime,
                                                         long endTime, String includeFinancial);

    ApiResponse<String> withdraw(String coin, String request_id, String address,String amount, String memo,
                                 String force_external, String force_internal);

    ApiResponse<Transaction> queryWithdrawInfo(String requestId);

    ApiResponse<List<StakingProduct>> getStakingProducts(String coin, Lang lang);
    ApiResponse<StakingProduct> getStakingProductById(String product_id, Lang lang);
    ApiResponse<List<StakingProduct>> getStakings(String coin, Lang lang);
    ApiResponse<List<Unstaking>> getUnstakings(String coin, Lang lang);
    ApiResponse<List<StakingHistory>> getStakingHistory(String coin, String type, String maxId, String limit, String productId);
    ApiResponse<Void> stake(String productId, String amount);
    ApiResponse<Void> unstake(String productId, String amount);

}
