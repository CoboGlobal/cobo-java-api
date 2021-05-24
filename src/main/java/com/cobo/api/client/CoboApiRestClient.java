package com.cobo.api.client;

import com.cobo.api.client.domain.*;
import com.cobo.api.client.domain.account.*;
import com.cobo.api.client.domain.staking.*;
import com.cobo.api.client.domain.trading.TradingDeposit;
import com.cobo.api.client.domain.trading.TradingTransfer;
import com.cobo.api.client.domain.trading.TradingWithdraw;
import com.cobo.api.client.domain.transaction.Side;
import com.cobo.api.client.domain.transaction.Transaction;

import java.math.BigInteger;
import java.util.List;

public interface CoboApiRestClient {
    /***
     * Check account details
     * @return account details
     */
    ApiResponse<OrgInfo> getOrgInfo();

    /***
     * get Coin details
     * @param coin coin code
     * @return
     */
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

    ApiResponse<String> withdraw(String coin, String request_id, String address, BigInteger amount, String memo,
                                 String force_external, String force_internal);

    ApiResponse<Transaction> queryWithdrawInfo(String requestId);

    ApiResponse<List<StakingProduct>> getStakingProducts(String coin, Lang lang);

    ApiResponse<StakingProduct> getStakingProductById(String product_id, Lang lang);

    ApiResponse<List<StakingData>> getStakings(String coin, Lang lang);

    ApiResponse<List<Unstaking>> getUnstakings(String coin, Lang lang);

    ApiResponse<List<StakingHistory>> getStakingHistory(String coin, String type, String maxId, String limit, String productId);

    ApiResponse<Void> stake(String productId, BigInteger amount);

    ApiResponse<Void> unstake(String productId, BigInteger amount);

    ApiResponse<TradingWithdraw> tradingWithdraw(String exchangeAccountToken,
                                                 String coin,
                                                 BigInteger amount,
                                                 String requestId);

    ApiResponse<TradingWithdraw> getTradingWithdrawInfo(String requestId);

    ApiResponse<TradingDeposit> tradingDeposit(String exchangeAccountToken,
                                               String coin,
                                               BigInteger amount,
                                               String requestId);

    ApiResponse<TradingDeposit> getTradingDepositInfo(String requestId);

    ApiResponse<TradingTransfer> tradingTransfer(String fromExchangeAccountToken,
                                                 String toExchangeAccountToken,
                                                 String coin,
                                                 BigInteger amount,
                                                 String requestId);

    ApiResponse<TradingTransfer> getTradingTransferInfo(String requestId);


}
