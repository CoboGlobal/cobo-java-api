package com.cobo.custody.api.client.impl;

import com.cobo.custody.api.client.ApiSigner;
import com.cobo.custody.api.client.CoboApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.*;
import com.cobo.custody.api.client.domain.enums.SortFlagEnum;
import com.cobo.custody.api.client.domain.staking.*;
import com.cobo.custody.api.client.domain.trading.TradingDeposit;
import com.cobo.custody.api.client.domain.trading.TradingTransfer;
import com.cobo.custody.api.client.domain.trading.TradingWithdraw;
import com.cobo.custody.api.client.domain.transaction.Side;
import com.cobo.custody.api.client.domain.transaction.Transaction;
import org.bouncycastle.util.encoders.Hex;

import java.math.BigInteger;
import java.util.List;

import static com.cobo.custody.api.client.impl.CoboApiServiceGenerator.createService;
import static com.cobo.custody.api.client.impl.CoboApiServiceGenerator.executeSync;

public class CoboApiRestClientImpl implements CoboApiRestClient {
    private final CoboApiService coboApiService;

    public CoboApiRestClientImpl(ApiSigner signer, Env env, boolean debug) {
        coboApiService = createService(CoboApiService.class, signer, env, debug);
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
    public ApiResponse<Address> newAddress(String coin, boolean nativeSegwit) {
        return nativeSegwit ?
                executeSync(coboApiService.newAddress(coin, true))
                :
                executeSync(coboApiService.newAddress(coin));

    }

    @Override
    public ApiResponse<NewAddresses> newAddresses(String coin, int count, boolean nativeSegwit) {
        return nativeSegwit ?
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
    public ApiResponse<List<Address>> getAddressHistory(String coin, int pageIndex, int pageLength) {
        return executeSync(coboApiService.getAddressHistory(coin, pageIndex, pageLength));
    }

    @Override
    public ApiResponse<List<Address>> getAddressHistory(String coin, int pageIndex, int pageLength, SortFlagEnum sortFlagEnum) {
        return executeSync(coboApiService.getAddressHistory(coin, pageIndex, pageLength, sortFlagEnum.getFlag()));
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
    public ApiResponse<List<Transaction>> getTransactionByTxId(String txId) {
        return executeSync(coboApiService.getTransactionByTxId(txId));
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
    public ApiResponse<List<Transaction>> getPendingTransactions(String coin, Side side, String maxId, String minId, int limit) {
        return executeSync(coboApiService.getPendingTransactions(coin, side.getValue(), maxId, minId, limit == 0 ? "50" : String.valueOf(limit)));
    }

    @Override
    public ApiResponse<Transaction> getPendingTransaction(String id) {
        return executeSync(coboApiService.getPendingTransaction(id));
    }

    @Override
    public ApiResponse<List<Transaction>> getTransactionHistory(String coin, Side side, String address, String maxId, String minId, int limit, long beginTime, long endTime, String includeFinancial) {
        return executeSync(coboApiService.getTransactionHistory(coin, side.getValue(), address, maxId, minId, intToString(limit), longToString(beginTime), longToString(endTime), includeFinancial));
    }

    @Override
    public ApiResponse<String> withdraw(String coin, String requestId, String address, BigInteger amount, String memo, String forceExternal, String forceInternal) {
        if (requestId == null || requestId.length() == 0) {
            requestId = String.format("sdk_request_id_%s_%s", Hex.toHexString(Utils.sha256(address.getBytes())).substring(0, 8), System.currentTimeMillis());
        }

        System.out.println(requestId);
        return executeSync(coboApiService.withdraw(coin, requestId, address, amount.toString(), memo, forceExternal, forceInternal));
    }

    @Override
    public ApiResponse<Transaction> queryWithdrawInfo(String requestId) {
        return executeSync(coboApiService.queryWithdrawInfo(requestId));
    }

    @Override
    public ApiResponse<List<StakingProduct>> getStakingProducts(String coin, Lang lang) {
        return executeSync(coboApiService.getStakingProducts(coin, lang.getValue()));
    }

    @Override
    public ApiResponse<StakingProduct> getStakingProductById(String productId, Lang lang) {
        return executeSync(coboApiService.getStakingProductById(productId, lang.getValue()));
    }

    @Override
    public ApiResponse<List<StakingData>> getStakings(String coin, Lang lang) {
        return executeSync(coboApiService.getStakings(coin, lang.getValue()));
    }

    @Override
    public ApiResponse<List<Unstaking>> getUnstakings(String coin, Lang lang) {
        return executeSync(coboApiService.getUnstakings(coin, lang.getValue()));
    }

    @Override
    public ApiResponse<List<StakingHistory>> getStakingHistory(String coin, String type, String maxId, String limit, String productId) {
        return executeSync(coboApiService.getStakingHistory(coin, type, maxId, limit, productId));
    }

    @Override
    public ApiResponse<Void> stake(String productId, BigInteger amount) {
        return executeSync(coboApiService.stake(productId, amount.toString()));
    }

    @Override
    public ApiResponse<Void> unstake(String productId, BigInteger amount) {
        return executeSync(coboApiService.unstake(productId, amount.toString()));
    }

    @Override
    public ApiResponse<TradingWithdraw> tradingWithdraw(String exchangeAccountToken, String coin, BigInteger amount, String requestId) {
        return executeSync(coboApiService.tradingWithdraw(exchangeAccountToken, coin, amount.toString(), requestId));
    }

    @Override
    public ApiResponse<TradingWithdraw> getTradingWithdrawInfo(String requestId) {
        return executeSync(coboApiService.getTradingWithdraw(requestId));
    }

    @Override
    public ApiResponse<TradingDeposit> tradingDeposit(String exchangeAccountToken, String coin, BigInteger amount, String requestId) {
        return executeSync(coboApiService.tradingDeposit(exchangeAccountToken, coin, amount.toString(), requestId));
    }

    @Override
    public ApiResponse<TradingDeposit> getTradingDepositInfo(String requestId) {
        return executeSync(coboApiService.getTradingDeposit(requestId));
    }

    @Override
    public ApiResponse<TradingTransfer> tradingTransfer(String fromExchangeAccountToken, String toExchangeAccountToken, String coin, BigInteger amount, String requestId) {
        return executeSync(coboApiService.tradingTransfer(fromExchangeAccountToken, toExchangeAccountToken, coin, amount.toString(), requestId));
    }

    @Override
    public ApiResponse<TradingTransfer> getTradingTransferInfo(String requestId) {
        return executeSync(coboApiService.getTradingTransfer(requestId));
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
