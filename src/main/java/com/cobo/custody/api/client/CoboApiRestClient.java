package com.cobo.custody.api.client;

import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.enums.SortFlagEnum;
import com.cobo.custody.api.client.domain.staking.*;
import com.cobo.custody.api.client.domain.trading.TradingDeposit;
import com.cobo.custody.api.client.domain.trading.TradingTransfer;
import com.cobo.custody.api.client.domain.trading.TradingWithdraw;
import com.cobo.custody.api.client.domain.transaction.Side;
import com.cobo.custody.api.client.domain.transaction.Transaction;

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
     * @return coinInfo
     */
    ApiResponse<CoinInfo> getCoinInfo(String coin);

    /***
     * Get new deposit address
     * @param coin coinCode
     * @param nativeSegwit use nativeSegwit address(btc only)
     * @return address info
     */
    ApiResponse<Address> newAddress(String coin, boolean nativeSegwit);

    /***
     * batch get new deposit address
     * @param coin coinCode
     * @param nativeSegwit use nativeSegwit address(btc only)
     * @param count count
     * @return
     */
    ApiResponse<NewAddresses> newAddresses(String coin, int count, boolean nativeSegwit);

    /***
     * verify deposit address
     * @param coin coin code
     * @param address address
     * @return
     */
    ApiResponse<Address> addressInfo(String coin, String address);

    /***
     * batch verify deposit address
     * @param coin coin code
     * @param addresses
     * @return
     */
    ApiResponse<Addresses> addressesInfo(String coin, List<String> addresses);

    /***
     * Verify valid address
     * @param coin coin code
     * @param address address
     * @return true - valid
     *         false- invalid
     */
    ApiResponse<Boolean> isValidAddress(String coin, String address);


    /***
     * get address history list, just support Descending result
     * @param coin coin code
     * @return address list
     */
    ApiResponse<List<Address>> getAddressHistory(String coin);

    /***
     * get address history list, just support Descending result
     * @param coin coin code
     * @param pageIndex which page, start from 0
     * @param pageLength page size, max size <= 50
     * @return
     */
    ApiResponse<List<Address>> getAddressHistory(String coin, int pageIndex, int pageLength);

    /**
     * get address history list
     * @param coin coin code
     * @param pageIndex which page, start from 0
     * @param pageLength page size, max size <= 50
     * @param sortFlagEnum 1: ascending order 0：Descending
     * @return
     */
    ApiResponse<List<Address>> getAddressHistory(String coin, int pageIndex, int pageLength, SortFlagEnum sortFlagEnum);

    /***
     * Check Loop address detail
     * @param coin coin code
     * @param address address
     * @return address info
     */
    ApiResponse<InternalAddressInfo> getInternalAddressInfo(String coin, String address);

    /***
     * Verify loop address list
     * @param coin coin code
     * @param addresses address
     * @return address list
     */
    ApiResponse<List<InternalAddressInfo>> getInternalAddressInfoBatch(String coin, String addresses);
    /***
     * get transaction list
     * @param txId - Cobo Transaction ID
     * @return transaction list
     */
    ApiResponse<List<Transaction>> getTransactionByTxId(String txId);
    /***
     * get transaction details
     * @param id - Cobo Unique Transaction ID
     * @return transaction
     */
    ApiResponse<Transaction> getTransactionById(String id);

    /***
     * Obtain the list of confirmed transactions through ID query(deposit&withdraw)
     * @param coin coin code
     * @param side Deposit/withdrawal
     * @param address Deposit/withdrawal address is optional. If not included, all address history will be returned.
     * @param maxId The transaction history ID limit is optional. If not included, will by default return the most recent records.
     * @param minId Optional. If included, the sequence will be changed to time ASC. If not included, will by default return the most recent records, time DESC.
     * @param limit Page size is optional. If not included, the default size will be 50, and the maximum size will also be 50.
     * @param includeFinancial Request all transactions. If it is passed in, return all transactions(Including stacking, trading)
     * @return
     */
    ApiResponse<List<Transaction>> getTransactionsById(String coin, Side side,
                                                       String address, String maxId,
                                                       String minId, int limit, String includeFinancial);

    /***
     * Obtain the list of confirmed transactions through time query(deposit&withdraw)
     * @param coin coin code
     * @param side Deposit/withdrawal
     * @param address Deposit/withdrawal address is optional. If not included, all address history will be returned.
     * @param beginTime Begin timestamp(milliseconds). If set, transactions whose transaction confirmation time is less than or equal to this will not be returned.
     * @param endTime End time stamp (milliseconds). If it is passed in, the transactions whose transaction confirmation time is greater than or equal to this will not be returned.
     * @param limit Page size is optional. If not included, the default size will be 50, and the maximum size will also be 50.
     * @param includeFinancial    Request all transactions. If it is passed in, return all transactions(Including stacking, trading)
     * @return
     */
    ApiResponse<List<Transaction>> getTransactionsByTime(String coin, Side side,
                                                         String address, long beginTime,
                                                         long endTime, int limit, String includeFinancial);

    /***
     * Get pending transaction list (before confirmingThreshold reached)
     * @param coin Coin code (Does not return all currencies)
     * @param side    Deposit/withdrawal
     * @param maxId The transaction history ID limit is optional. If not included, will by default return the most recent records.
     * @param minId Optional. If included, the sequence will be changed to time ASC. If not included, will by default return the most recent records, time DESC.
     * @param limit Page size is optional. If not included, the default size will be 50, and the maximum size will also be 50.
     * @return
     */
    ApiResponse<List<Transaction>> getPendingTransactions(String coin, Side side,
                                                          String maxId,
                                                          String minId, int limit);

    /***
     * Get Pending Deposit Details
     * @param id Transaction ID
     * @return transaction detail
     */
    ApiResponse<Transaction> getPendingTransaction(String id);

    /***
     * Get Transaction History
     * @param coin Coin code (Does not return all currencies)
     * @param side Deposit/withdrawal
     * @param address Deposit/withdrawal address is optional. If not included, all address history will be returned.
     * @param maxId The transaction history ID limit is optional. If not included, will by default return the most recent records.
     * @param minId Optional. If included, the sequence will be changed to time ASC. If not included, will by default return the most recent records, time DESC.
     * @param limit Page size is optional. If not included, the default size will be 50, and the maximum size will also be 50.
     * @param beginTime Begin timestamp(milliseconds). If set, transactions whose confirmation times are shorter than this value will not be returned.
     * @param endTime
     * @param includeFinancial
     * @return
     */
    ApiResponse<List<Transaction>> getTransactionHistory(String coin, Side side,
                                                         String address, String maxId,
                                                         String minId, int limit, long beginTime,
                                                         long endTime, String includeFinancial);

    /***
     * Submit Withdrawal Request
     * @param coin coin code
     * @param requestId Withdrawal request ID (Universally unique ID for each user's withdraw request)
     * @param address Withdrawal address
     * @param amount Please note that the withdrawal amount should be expressed in terms of the respective coin's smallest unit. For example, if 1 BTC is to be withdrawn, the amount should be multiplied by 100,000,000 (Satoshis)
     * @param memo Needed when you withdraw EOS, XRP, IOST
     * @param forceExternal Non-empty means: force the transaction on-chain even if it's a Loop Tx
     * @param forceInternal Non-empty means: force the transaction off-chain even if it's not a Loop Tx, if it cannot be handled as a Loop tx, it will be rejected
     * @return ""
     */
    ApiResponse<String> withdraw(String coin, String requestId, String address, BigInteger amount, String memo,
                                 String forceExternal, String forceInternal);

    /***
     * Get Withdrawal Information
     * @param requestId Withdrawal Request ID
     * @return
     */
    ApiResponse<Transaction> queryWithdrawInfo(String requestId);

    /***
     * Get All Staking Product List
     * @param coin coin code
     * @param lang Language of product description(zh,en(default))
     * @return product list
     */
    ApiResponse<List<StakingProduct>> getStakingProducts(String coin, Lang lang);

    /***
     * Get a Staking Product Details
     * @param productId Unique ID for staking product
     * @param lang Language of product description(zh,en(default))
     * @return staking product details
     */
    ApiResponse<StakingProduct> getStakingProductById(String productId, Lang lang);

    /***
     * Get Staking Data
     * @param coin coin code
     * @param lang Language of product description(zh,en(default))
     * @return staking list
     */
    ApiResponse<List<StakingData>> getStakings(String coin, Lang lang);

    /***
     * Get Unstaking Data
     * @param coin coin code
     * @param lang Language of product description(zh,en(default))
     * @return unstaking list
     */
    ApiResponse<List<Unstaking>> getUnstakings(String coin, Lang lang);

    /***
     * Get All Staking History
     * @param coin coin code
     * @param type stake, unstake,reward
     * @param maxId max id
     * @param limit Limit of the list, Max.50
     * @param productId product id
     * @return
     */
    ApiResponse<List<StakingHistory>> getStakingHistory(String coin, String type, String maxId, String limit, String productId);

    /**
     * Stake
     *
     * @param productId product id
     * @param amount    stake amount
     * @return
     */
    ApiResponse<Void> stake(String productId, BigInteger amount);

    /**
     * Unstake
     *
     * @param productId product id
     * @param amount    unstake amount
     * @return
     */
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
