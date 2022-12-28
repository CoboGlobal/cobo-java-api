package com.cobo.custody.api.client.demo;

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

public class MPCCashSweep {
    private String MPCAPISecret = "";
    private CoboMPCApiRestClient mpcClient;
    private Env TestEnv = Env.SANDBOX;

    public void MPCCashSweep() throws Exception {
        MPCAPISecret = System.getProperty("MPCApiSecret");
        mpcClient = CoboApiClientFactory.newInstance(
                new LocalSigner(MPCAPISecret),
                TestEnv,
                false).newMPCRestClient();
    }

    public static void main(String[] args) {
        MPCCashSweep mpcCashSweep = new MPCCashSweep();
        String coin = "GETH";
        String toAddr = "";
        BigInteger toAmount = new BigInteger("1001");
        Boolean success = mpcCashSweep.cashSweep(coin, toAddr, toAmount);
        System.out.println(success);
    }

    public Boolean cashSweep(String coin, String toAddr, BigInteger toAmount) {
        ApiResponse<Boolean> response = mpcClient.isValidAddress(coin, toAddr);
        if (!response.isSuccess()) {
            return false;
        }
        ApiResponse<MPCBalance> balanceResponse = mpcClient.getBalance(toAddr, null, coin);
        if (!balanceResponse.isSuccess()) {
            return false;
        }

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

        List<MPCCoinBalanceDetail> allBalances = new ArrayList<>();
        while (pageIndex * pageLength < total) {
            balances = mpcClient.listBalances(coin, pageIndex, pageLength);
            allBalances.addAll(balances.getResult().getCoinData());
            pageIndex += pageLength;
        }

        BigInteger allBalanceAmount = new BigInteger("0");
        BigInteger allBalanceAmountWithEnoughFee = new BigInteger("0");
        for (MPCCoinBalanceDetail balanceDetail : allBalances) {
            BigInteger balance = new BigInteger(balanceDetail.getBalance());
            allBalanceAmount.add(balance);

            if (Objects.equals(balanceDetail.getAddress(), toAddr)) {
                allBalanceAmountWithEnoughFee.add(balance);
                continue;
            }

            ApiResponse<EstimateFeeDetails> estimateFee = mpcClient.estimateFee(coin, balance, toAddr, null);
            if (!estimateFee.isSuccess()) {
                continue;
            }

            BigInteger gasLimit = estimateFee.getResult().getAverage().getGasLimit();
            BigInteger gasPrice = estimateFee.getResult().getAverage().getGasPrice();

            if (Objects.equals(estimateFee.getResult().getFeeCoin(), coin)) {
                if (balance.compareTo(gasLimit.multiply(gasPrice)) > 0) {
                    allBalanceAmountWithEnoughFee.add(balance.subtract(gasLimit.multiply(gasPrice)));
                }
            } else {
                ApiResponse<MPCBalance> feeBalance = mpcClient.getBalance(balanceDetail.getAddress(), balanceDetail.getChainCode(), balanceDetail.getCoin());
                if (feeBalance.isSuccess() && feeBalance.getResult().getCoinData().size() > 0) {
                    MPCCoinBalanceDetail feeBalanceDetail = feeBalance.getResult().getCoinData().get(0);
                    if (new BigInteger(feeBalanceDetail.getBalance()).compareTo(gasLimit.multiply(gasPrice)) >= 0) {
                        allBalanceAmountWithEnoughFee.add(balance);
                    }
                }
            }
        }

        if (allBalanceAmountWithEnoughFee.compareTo(toAmount) >= 0) {
            BigInteger transferAllAmount = new BigInteger("0");
            for (MPCCoinBalanceDetail balanceDetail : allBalances) {
                if (balanceDetail.getBalance().equals(toAddr)) {
                    transferAllAmount.add(new BigInteger(balanceDetail.getBalance()));
                } else {
                    BigInteger transferAmount = transfer(balanceDetail.getCoin(), balanceDetail.getAddress(), toAddr);
                    transferAllAmount.add(transferAmount);
                }

                if (transferAllAmount.compareTo(toAmount) >= 0) {
                    return true;
                }
            }

            return false;
        } else if (allBalanceAmount.compareTo(toAmount) >= 0) {
            System.out.println("all addresses don't has enough tx fee");
            return false;
        } else {
            System.out.println("all addresses don't has enough balance");
            return false;
        }
    }

    public BigInteger transfer(String coin, String fromAddr, String toAddr) {
        String requestId = String.valueOf(System.currentTimeMillis());
        ApiResponse<MPCBalance> mpcBalance = mpcClient.getBalance(fromAddr, null, coin);
        if (!mpcBalance.isSuccess()) {
            return new BigInteger("0");
        }
        if (mpcBalance.getResult().getCoinData().size() == 0) {
            return new BigInteger("0");
        }

        MPCCoinBalanceDetail balanceDetail = mpcBalance.getResult().getCoinData().get(0);
        ApiResponse<EstimateFeeDetails> estimateFee = mpcClient.estimateFee(coin, new BigInteger(balanceDetail.getBalance()), toAddr, null);
        if (!estimateFee.isSuccess()) {
            return new BigInteger("0");
        }
        if (!Objects.equals(estimateFee.getResult().getFeeCoin(), coin)) {
            ApiResponse<MPCBalance> feeMpcBalance = mpcClient.getBalance(fromAddr, null, estimateFee.getResult().getFeeCoin());
            if (!feeMpcBalance.isSuccess()) {
                return new BigInteger("0");
            }

            ApiResponse<EstimateFeeDetails> feeEstimateFee = mpcClient.estimateFee(coin, new BigInteger(balanceDetail.getBalance()), toAddr, null);
            if (!feeEstimateFee.isSuccess()) {
                return new BigInteger("0");
            }

            MPCCoinBalanceDetail feeBalanceDetail = mpcBalance.getResult().getCoinData().get(0);
            BigInteger gasLimit = feeEstimateFee.getResult().getAverage().getGasLimit();
            BigInteger gasPrice = feeEstimateFee.getResult().getAverage().getGasPrice();
            if (new BigInteger(feeBalanceDetail.getBalance()).compareTo(gasLimit.multiply(gasPrice)) < 0) {
                return new BigInteger("0");
            }

            ApiResponse<MPCPostTransaction> response = mpcClient.createTransaction(coin, requestId, fromAddr, toAddr, new BigInteger(balanceDetail.getBalance()),
                    null, null, null, null, null, null);
            if (response.isSuccess()) {
                return new BigInteger(balanceDetail.getBalance());
            } else {
                return new BigInteger("0");
            }
        } else {
            BigInteger gasLimit = estimateFee.getResult().getAverage().getGasLimit();
            BigInteger gasPrice = estimateFee.getResult().getAverage().getGasPrice();
            if (new BigInteger(balanceDetail.getBalance()).compareTo(gasLimit.multiply(gasPrice)) <= 0) {
                return new BigInteger("0");
            }

            BigInteger amount = new BigInteger(balanceDetail.getBalance()).subtract(gasLimit.multiply(gasPrice));
            ApiResponse<MPCPostTransaction> response = mpcClient.createTransaction(coin, requestId, fromAddr, toAddr, amount,
                    null, null, null, null, null, null);
            if (response.isSuccess()) {
                return amount;
            } else {
                return new BigInteger("0");
            }
        }
    }
}
