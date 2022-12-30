package com.cobo.custody.mpc;

import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboMPCApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.MPCBalance;
import com.cobo.custody.api.client.domain.account.MPCCoinBalanceDetail;
import com.cobo.custody.api.client.domain.account.MPCListBalances;
import com.cobo.custody.api.client.domain.transaction.EstimateFeeDetails;
import com.cobo.custody.api.client.domain.transaction.MPCPostTransaction;
import com.cobo.custody.api.client.impl.LocalSigner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MPCFundCollection {
    private String MPCAPISecret = "";
    private CoboMPCApiRestClient mpcClient;
    private Env TestEnv = Env.SANDBOX;

    public MPCFundCollection() throws Exception {
        MPCAPISecret = System.getProperty("MPCApiSecret");
        mpcClient = CoboApiClientFactory.newInstance(
                new LocalSigner(MPCAPISecret),
                TestEnv,
                false).newMPCRestClient();
    }

    public static void main(String[] args) throws Exception {
        MPCFundCollection mpcFundCollection = new MPCFundCollection();
        String coin = "GETH";
        String toAddr = "0x4222cc0781d2588e8f6f8259ff5ecf083429013b";
        BigInteger toAmount = new BigInteger("1002");
        String feeFromAddr = "0x943de9312cddcc9769ab82527848c02b70c0bf95";
        Boolean success = mpcFundCollection.fundCollection(coin, toAddr, toAmount, feeFromAddr);
        System.out.println(success);
    }

    public Boolean fundCollection(String coin, String toAddr, BigInteger toAmount, String feeFromAddress) {
        ApiResponse<Boolean> response = mpcClient.isValidAddress(coin, toAddr);
        if (!response.isSuccess()) {
            return false;
        }
        // 校验toAddr和apikey
        ApiResponse<MPCBalance> balanceResponse = mpcClient.getBalance(toAddr, null, coin);
        if (!balanceResponse.isSuccess()) {
            return false;
        }
        ApiResponse<EstimateFeeDetails> feeResponse = mpcClient.estimateFee(coin, toAmount, toAddr, null);
        if (!feeResponse.isSuccess()) {
            return false;
        }

        // 获取余额总数
        Integer pageIndex = 0;
        Integer pageLength = 50;
        ApiResponse<MPCListBalances> balances = mpcClient.listBalances(coin, pageIndex, pageLength);
        if (!balances.isSuccess()) {
            return false;
        }
        Integer total = balances.getResult().getTotal();
        if (total <= 0) {
            return false;
        }

        // 获取所有余额数据
        List<MPCCoinBalanceDetail> allBalances = new ArrayList<>();
        while (pageIndex * pageLength < total) {
            balances = mpcClient.listBalances(coin, pageIndex, pageLength);
            allBalances.addAll(balances.getResult().getCoinData());
            pageIndex += pageLength;
        }

        // 钱包下所有余额总额汇总
        BigInteger allBalanceAmount = new BigInteger("0");
        for (MPCCoinBalanceDetail balanceDetail : allBalances) {
            BigInteger balance = new BigInteger(balanceDetail.getBalance());
            allBalanceAmount = allBalanceAmount.add(balance);
        }

        if (allBalanceAmount.compareTo(toAmount) >= 0) {
            BigInteger transferAllAmount = new BigInteger("0");
            for (MPCCoinBalanceDetail balanceDetail : allBalances) {
                if (feeResponse.getResult().getFeeCoin().equals(coin)) {
                    // 归集币种和手续费币种一致
                    BigInteger transferAmount = transfer(balanceDetail.getCoin(), balanceDetail.getAddress(), toAddr, toAmount.subtract(transferAllAmount));
                    transferAllAmount = transferAllAmount.add(transferAmount);
                } else {
                    // 归集币种和手续费币种不一致
                    BigInteger transferAmount = tokenTransfer(balanceDetail.getCoin(), balanceDetail.getAddress(), toAddr, feeFromAddress, toAmount.subtract(transferAllAmount));
                    transferAllAmount = transferAllAmount.add(transferAmount);
                }

                if (transferAllAmount.compareTo(toAmount) >= 0) {
                    return true;
                }
            }

            // 归集币种和手续费币种一致时，由于交易费用缺少导致总转账金额小于需要转账金额，直接从feeFromAddress提取到toAddr
            if (feeResponse.getResult().getFeeCoin().equals(coin) && transferAllAmount.compareTo(toAmount) < 0) {
                BigInteger transferAmount = transfer(coin, feeFromAddress, toAddr, toAmount.subtract(transferAllAmount));
                transferAllAmount = transferAllAmount.add(transferAmount);
            }

            return transferAllAmount.compareTo(toAmount) >= 0;
        } else {
            return false;
        }
    }

    public BigInteger tokenTransfer(String coin, String fromAddr, String toAddr, String feeAddr, BigInteger toAmount) {
        String requestId = String.valueOf(System.currentTimeMillis());
        // 校验地址和apikey(mpc钱包)
        ApiResponse<MPCBalance> mpcBalance = mpcClient.getBalance(fromAddr, null, coin);
        if (!mpcBalance.isSuccess()) {
            return new BigInteger("0");
        }
        if (mpcBalance.getResult().getCoinData().size() == 0) {
            return new BigInteger("0");
        }
        MPCCoinBalanceDetail balanceDetail = mpcBalance.getResult().getCoinData().get(0);
        BigInteger balance = new BigInteger(balanceDetail.getBalance());
        BigInteger realToAmount = toAmount.compareTo(balance) > 0 ? balance : toAmount;

        // 预估交易手续费
        ApiResponse<EstimateFeeDetails> estimateFee = mpcClient.estimateFee(coin, realToAmount, toAddr, null);
        if (!estimateFee.isSuccess()) {
            return new BigInteger("0");
        }
        if (Objects.equals(estimateFee.getResult().getFeeCoin(), coin)) {
            return new BigInteger("0");
        }
        BigInteger gasLimit = estimateFee.getResult().getAverage().getGasLimit();
        BigInteger gasPrice = estimateFee.getResult().getAverage().getGasPrice();
        BigInteger gasFee = gasLimit.multiply(gasPrice);

        // 校验feeAddr有充足的手续费
        ApiResponse<MPCBalance> feeAddrBalance = mpcClient.getBalance(feeAddr, null, estimateFee.getResult().getFeeCoin());
        if (!feeAddrBalance.isSuccess()) {
            return new BigInteger("0");
        }
        if (feeAddrBalance.getResult().getCoinData().size() == 0) {
            return new BigInteger("0");
        }
        MPCCoinBalanceDetail feeAddrBalanceDetail = feeAddrBalance.getResult().getCoinData().get(0);
        if (new BigInteger(feeAddrBalanceDetail.getBalance()).compareTo(gasFee) < 0) {
            return new BigInteger("0");
        }

        // fromAddr 交易手续费用不足时，补充交易手续费
        ApiResponse<MPCBalance> fromAddrFeeBalanceResponse = mpcClient.getBalance(fromAddr, null, estimateFee.getResult().getFeeCoin());
        if (!fromAddrFeeBalanceResponse.isSuccess()) {
            return new BigInteger("0");
        }
        if (fromAddrFeeBalanceResponse.getResult().getCoinData().size() == 0) {
            ApiResponse<MPCPostTransaction> transferFeeResponse = mpcClient.createTransaction(coin, requestId, feeAddr, toAddr, gasFee,
                    null, null, null, null, null, null);
            if (!transferFeeResponse.isSuccess()) {
                return new BigInteger("0");
            }
        } else {
            MPCCoinBalanceDetail fromAddrFeeBalanceDetail = fromAddrFeeBalanceResponse.getResult().getCoinData().get(0);
            BigInteger fromAddrFeeBalance = new BigInteger(fromAddrFeeBalanceDetail.getBalance());
            if (fromAddrFeeBalance.compareTo(gasFee) < 0) {
                ApiResponse<MPCPostTransaction> transferFeeResponse = mpcClient.createTransaction(coin, requestId, feeAddr, toAddr, gasFee.subtract(fromAddrFeeBalance),
                        null, null, null, null, null, null);
                if (!transferFeeResponse.isSuccess()) {
                    return new BigInteger("0");
                }
            }
        }

        // fromAddr转账toAddr
        ApiResponse<MPCPostTransaction> response = mpcClient.createTransaction(coin, requestId, fromAddr, toAddr, realToAmount,
                null, null, null, null, null, null);
        if (response.isSuccess()) {
            return realToAmount;
        } else {
            return new BigInteger("0");
        }
    }

    public BigInteger transfer(String coin, String fromAddr, String toAddr, BigInteger toAmount) {
        String requestId = String.valueOf(System.currentTimeMillis());
        // 校验fromAddr和apikey(mpc钱包)
        ApiResponse<MPCBalance> mpcBalance = mpcClient.getBalance(fromAddr, null, coin);
        if (!mpcBalance.isSuccess()) {
            return new BigInteger("0");
        }
        if (mpcBalance.getResult().getCoinData().size() == 0) {
            return new BigInteger("0");
        }
        MPCCoinBalanceDetail balanceDetail = mpcBalance.getResult().getCoinData().get(0);

        // 预估手续费
        ApiResponse<EstimateFeeDetails> estimateFee = mpcClient.estimateFee(coin, new BigInteger(balanceDetail.getBalance()), toAddr, null);
        if (!estimateFee.isSuccess()) {
            return new BigInteger("0");
        }
        BigInteger balance = new BigInteger(balanceDetail.getBalance());
        BigInteger gasLimit = estimateFee.getResult().getAverage().getGasLimit();
        BigInteger gasPrice = estimateFee.getResult().getAverage().getGasPrice();
        BigInteger gasFee = gasLimit.multiply(gasPrice);
        // 如果余额小于或等于手续费，则不再归集
        if (balance.compareTo(gasFee) <= 0) {
            return new BigInteger("0");
        }

        BigInteger realToAmount = toAmount.compareTo(balance.subtract(gasFee)) > 0 ? balance.subtract(gasFee) : toAmount;
        ApiResponse<MPCPostTransaction> response = mpcClient.createTransaction(coin, requestId, fromAddr, toAddr, realToAmount,
                null, null, null, null, null, null);
        if (response.isSuccess()) {
            return realToAmount;
        } else {
            return new BigInteger("0");
        }

    }
}
