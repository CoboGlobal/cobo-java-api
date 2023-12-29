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
    private Env TestEnv = Env.DEV;

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

    /*
    资金归集分为两种情况：一种归集币种是链主币，一种归集币种是链代币。
    使用背景：
    1. 客户需要将钱包线所有地址的余额（或余额的一部分）归集到一个地址中。
    2. 资金归集会消耗手续费，按需使用该功能。
    具体实现逻辑如下：
    1. 校验地址toAddr是否有效。校验失败，直接退出，归集失败。
    2. 获取归集手续费币种。
    3. 汇总钱包中所有地址对应币种余额，校验余额是否大于待归集金额。如果余额小于待归集金额，直接退出，归集失败。
    4. 将钱包中每个地址余额转账到目标地址（如果地址是目标地址，则跳过不转账），直到转账金额=待归集金额为止。
    注意事项：
    1. 确保feeFromAddress属于apikey对应的custody钱包。
    2. 调用资金归集之前，如果不确定交易手续费币种，可以调用estimateFee查询。确保feeFromAddress有足够的手续费支持资金归集。
     */
    public Boolean fundCollection(String coin, String toAddr, BigInteger toAmount, String feeFromAddress) {
        if (toAmount.compareTo(new BigInteger("0")) <= 0) {
            return false;
        }

        ApiResponse<Boolean> response = mpcClient.isValidAddress(coin, toAddr);
        if (!response.isSuccess()) {
            return false;
        }
        if (!response.getResult()) {
            return false;
        }

        ApiResponse<EstimateFeeDetails> feeResponse = mpcClient.estimateFee(coin, toAmount, toAddr, null, null, null, null, null, null, null);
        if (!feeResponse.isSuccess()) {
            return false;
        }

        // 获取余额总数
        Integer pageIndex = 0;
        Integer pageLength = 50;
        ApiResponse<MPCListBalances> balances = mpcClient.listBalances(coin, pageIndex, pageLength, null);
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
            balances = mpcClient.listBalances(coin, pageIndex, pageLength, null);
            allBalances.addAll(balances.getResult().getCoinData());
            pageIndex += pageLength;
        }

        // 钱包下所有余额总额汇总。若余额地址和toAddr相同，则余额不作为归集金额。
        BigInteger allBalanceAmount = new BigInteger("0");
        for (MPCCoinBalanceDetail balanceDetail : allBalances) {
            if (Objects.equals(balanceDetail.getAddress(), toAddr)) {
                continue;
            }

            BigInteger balance = new BigInteger(balanceDetail.getBalance());
            allBalanceAmount = allBalanceAmount.add(balance);
        }

        if (allBalanceAmount.compareTo(toAmount) >= 0) {
            BigInteger transferAllAmount = new BigInteger("0");
            for (MPCCoinBalanceDetail balanceDetail : allBalances) {
                if (Objects.equals(balanceDetail.getAddress(), toAddr)) {
                    continue;
                }

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

            // 归集币种和手续费币种一致时，若由于交易费用缺少导致总转账金额小于需要转账金额，直接从其他地址提取到toAddr
            return transferAllAmount.compareTo(toAmount) >= 0;
        } else {
            return false;
        }
    }

    /*
    代币转账
    具体实现逻辑如下：
    1. 校验fromAddr是否属于apikey对应的custody钱包，是否有余额。如果余额不存在或者余额为0，则直接返回，归集金额为0。
    2. 根据地址余额、待归集金额计算出实际可以归集的余额。
    3. 预估手续费，校验该地址是否有足够的手续费，手续费不够，则需要从feeAddr向fromAddr转账，以保证资金归集时，fromAddr有足够的手续费。
    4. fromAddr向toAddr转账，转账受理成功后，即可认为归集受理成功，最终金额以custody回调为准。
     */
    public BigInteger tokenTransfer(String coin, String fromAddr, String toAddr, String feeAddr, BigInteger toAmount) {
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
        if (balance.compareTo(new BigInteger("0")) <= 0) {
            return new BigInteger("0");
        }
        BigInteger realToAmount = toAmount.compareTo(balance) > 0 ? balance : toAmount;

        // 预估交易手续费
        ApiResponse<EstimateFeeDetails> estimateFee = mpcClient.estimateFee(coin, realToAmount, toAddr, null, null, null, null, null, null, null);
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
            String requestId = String.valueOf(System.currentTimeMillis());
            ApiResponse<MPCPostTransaction> transferFeeResponse = mpcClient.createTransaction(
                    estimateFee.getResult().getFeeCoin(), requestId, gasFee, feeAddr, fromAddr, null,
                    null, null, null, null, null, null,
                    null, null, null);
            if (!transferFeeResponse.isSuccess()) {
                return new BigInteger("0");
            }
        } else {
            MPCCoinBalanceDetail fromAddrFeeBalanceDetail = fromAddrFeeBalanceResponse.getResult().getCoinData().get(0);
            BigInteger fromAddrFeeBalance = new BigInteger(fromAddrFeeBalanceDetail.getBalance());
            if (fromAddrFeeBalance.compareTo(gasFee) < 0) {
                String requestId = String.valueOf(System.currentTimeMillis());
                ApiResponse<MPCPostTransaction> transferFeeResponse = mpcClient.createTransaction(estimateFee.getResult().getFeeCoin(), requestId, gasFee.subtract(fromAddrFeeBalance), feeAddr, fromAddr,
                        null, null, null, null, null, null, null, null, null, null);
                if (!transferFeeResponse.isSuccess()) {
                    return new BigInteger("0");
                }
            }
        }

        // 注意：如果需要补充手续费，需要check手续费到账后，再进行转账操作。

        // fromAddr转账toAddr
        String requestId = String.valueOf(System.currentTimeMillis());
        ApiResponse<MPCPostTransaction> response = mpcClient.createTransaction(coin, requestId, realToAmount, fromAddr, toAddr,
                null, null, null, null, null, null, null, null, null, null);
        if (response.isSuccess()) {
            return realToAmount;
        } else {
            return new BigInteger("0");
        }
    }

    /*
    主币转账
    具体实现逻辑如下：
    1. 校验fromAddr是否属于apikey对应的custody钱包，是否有余额。如果余额不存在或者余额为0，则直接返回，归集金额为0。
    2. 根据地址余额、待归集金额、交易手续费计算出实际可以归集的余额。
    3. fromAddr向toAddr转账，转账受理成功后，即可认为归集受理成功，最终金额以custody回调为准。
     */
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
        BigInteger balance = new BigInteger(balanceDetail.getBalance());
        if (balance.compareTo(new BigInteger("0")) <= 0) {
            return new BigInteger("0");
        }

        // 预估手续费
        ApiResponse<EstimateFeeDetails> estimateFee = mpcClient.estimateFee(coin, new BigInteger(balanceDetail.getBalance()), toAddr, null, null, null, null, null, null, null);
        if (!estimateFee.isSuccess()) {
            return new BigInteger("0");
        }
        BigInteger gasLimit = estimateFee.getResult().getAverage().getGasLimit();
        BigInteger gasPrice = estimateFee.getResult().getAverage().getGasPrice();
        BigInteger gasFee = gasLimit.multiply(gasPrice);
        // 如果余额小于或等于手续费，则不再归集
        if (balance.compareTo(gasFee) <= 0) {
            return new BigInteger("0");
        }

        BigInteger realToAmount = toAmount.compareTo(balance.subtract(gasFee)) > 0 ? balance.subtract(gasFee) : toAmount;
        ApiResponse<MPCPostTransaction> response = mpcClient.createTransaction(coin, requestId, realToAmount, fromAddr, toAddr,
                null, null, null, null, null, null, null, null, null, null);
        if (response.isSuccess()) {
            return realToAmount;
        } else {
            return new BigInteger("0");
        }

    }
}
