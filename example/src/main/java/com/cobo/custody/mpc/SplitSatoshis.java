package com.cobo.custody.mpc;

import com.alibaba.fastjson2.JSON;
import com.cobo.custody.api.client.CoboApiClientFactory;
import com.cobo.custody.api.client.CoboMPCApiRestClient;
import com.cobo.custody.api.client.config.Env;
import com.cobo.custody.api.client.domain.ApiResponse;
import com.cobo.custody.api.client.domain.account.CoinInfo;
import com.cobo.custody.api.client.domain.transaction.GetSatoshisDetail;
import com.cobo.custody.api.client.domain.transaction.GetSatoshisDetails;
import com.cobo.custody.api.client.domain.transaction.MPCPostTransaction;
import com.cobo.custody.api.client.domain.transaction.MPCTransactionInfos;
import com.cobo.custody.api.client.impl.LocalSigner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class SplitSatoshis {
    private String MPCAPISecret = "";
    private CoboMPCApiRestClient mpcClient;
    private Env TestEnv = Env.DEV;

    public SplitSatoshis() throws Exception {
        MPCAPISecret = System.getProperty("MPCApiSecret");
        mpcClient = CoboApiClientFactory.newInstance(
                new LocalSigner(MPCAPISecret),
                TestEnv,
                false).newMPCRestClient();
    }

    static class TxHashAndVoutN {
        String txHash;
        Integer voutN;

        public TxHashAndVoutN(String txHash, Integer voutN) {
            this.txHash = txHash;
            this.voutN = voutN;
        }

        public String getTxHash() {
            return txHash;
        }

        public void setTxHash(String txHash) {
            this.txHash = txHash;
        }

        public Integer getVoutN() {
            return voutN;
        }

        public void setVoutN(Integer voutN) {
            this.voutN = voutN;
        }
    }


    public static void main(String[] args) throws Exception {
        // 单个txHash+voutN
        splitSatoshis();

        // 多个txHash+voutN
        splitSatoshisV2();
    }

    public static void splitSatoshis() throws Exception {
        SplitSatoshis splitSatoshis = new SplitSatoshis();
        String coin = "BTC";
        String txHash = "xxxx";
        Integer voutN = 0;
        // 为了构造交易中的to_address_details，提供相应的地址
        String satoshisAddress = "xxxx";

        ApiResponse<CoinInfo> coinInfo = splitSatoshis.mpcClient.getCoinInfo(coin);
        if (!coinInfo.isSuccess()) {
            return;
        }

        // 获取txHash  对应的toAddress
        ApiResponse<MPCTransactionInfos> transactions = splitSatoshis.mpcClient.transactionsByTxhash(txHash, null);
        if (!transactions.isSuccess()) {
            return;
        }
        String toAddress = transactions.getResult().getTransactions().get(0).getToAddress();

        // 获取稀有聪
        ApiResponse<GetSatoshisDetails>  rareSatoshiList = splitSatoshis.mpcClient.getRareSatoshis(coin, txHash, voutN);
        if (!rareSatoshiList.isSuccess()) {
            return;
        }

        // 判断有无稀有聪
        if (rareSatoshiList.getResult().getSatoshis().size() <= 0) {
            return;
        }

        // 拆分稀有聪
        BigInteger lastOffset = new BigInteger("0");
        ArrayList<BigInteger> outputValues = new ArrayList<>();
        boolean includeSatoshi = false;
        BigInteger dustThreshold = new BigInteger(String.valueOf(coinInfo.getResult().getDustThreshold()));
        for (GetSatoshisDetail detail : rareSatoshiList.getResult().getSatoshis()) {
            BigInteger delta = new BigInteger(detail.getOffset()).subtract(lastOffset);
            if (delta.compareTo(new BigInteger(String.valueOf(dustThreshold))) < 0) {
                includeSatoshi = true;
                continue;
            }

            if (!includeSatoshi) {
                outputValues.add(delta);
            } else {
                outputValues.add(dustThreshold);
                outputValues.add(delta.subtract(dustThreshold));
            }

            includeSatoshi = true;
            lastOffset = lastOffset.add(delta);
        }

        ArrayList<HashMap<String, Object>> toAddressDetails = new ArrayList<>();
        for (BigInteger outputValue : outputValues) {
            HashMap<String, Object> toAddressDetail = new HashMap<>();
            toAddressDetail.put("to_address", satoshisAddress);
            toAddressDetail.put("amount", outputValue);

            toAddressDetails.add(toAddressDetail);
        }

        // 转账
        String requestId = String.valueOf(System.currentTimeMillis());
        ApiResponse<MPCPostTransaction> transferFeeResponse = splitSatoshis.mpcClient.createTransaction(coin, requestId,
                null, toAddress, null, JSON.toJSONString(toAddressDetails), null, null,
                null, null, null, null, null, null, null,
                0, null);
        if (!transferFeeResponse.isSuccess()) {
            return;
        }
        // 当拆分稀有聪的交易上链后(对应transferFeeResponse)，将拆分出稀有聪的utxo，调用lock_spendable api锁定
        // 根据回调获取稀有聪交易。并拿到相应的txHash, voutN
        String satoshisTxHash = "";
        Integer satoshisVoutN = 0;
        splitSatoshis.mpcClient.lockSpendable(coin, satoshisTxHash, satoshisVoutN);
    }

    public static void splitSatoshisV2() throws Exception {
        SplitSatoshis splitSatoshis = new SplitSatoshis();
        ArrayList<TxHashAndVoutN> txHashAndVoutNs = new ArrayList<>();
        txHashAndVoutNs.add(new TxHashAndVoutN("xxxx", 0));
        txHashAndVoutNs.add(new TxHashAndVoutN("bbbb", 1));
        txHashAndVoutNs.add(new TxHashAndVoutN("ccc", 0));
        String coin = "BTC";
        // 为了构造交易中的to_address_details，提供相应的地址
        String satoshisAddress = "xxxx";
        // 为了保证手续费一定充足，提供相应的手续费对应的txHash和voutN
        String feeTxHash = "eeee";
        Integer feeVoutN = 1;

        ApiResponse<CoinInfo> coinInfo = splitSatoshis.mpcClient.getCoinInfo(coin);
        if (!coinInfo.isSuccess()) {
            return;
        }

        ArrayList<BigInteger> outputValues = new ArrayList<>();
        ArrayList<HashMap<String, Object>> inputsToSpend= new ArrayList<>();
        // 先填充一个用于手续费的地址
        HashMap<String, Object> feeMpcTxInput = new HashMap<>();
        feeMpcTxInput.put("tx_hash", feeTxHash);
        feeMpcTxInput.put("vout_n", feeVoutN);
        inputsToSpend.add(feeMpcTxInput);

        for (TxHashAndVoutN txHashAndVoutN : txHashAndVoutNs) {
            // 校验是否有txHash对应的交易，并且该交易属于该钱包
            ApiResponse<MPCTransactionInfos> transactions = splitSatoshis.mpcClient.transactionsByTxhash(txHashAndVoutN.txHash, null);
            if (!transactions.isSuccess()) {
                return;
            }

            // 填充到inputsToSpend
            HashMap<String, Object> mpcTxInput = new HashMap<>();
            mpcTxInput.put("tx_hash", txHashAndVoutN.txHash);
            mpcTxInput.put("vout_n", txHashAndVoutN.getVoutN());
            inputsToSpend.add(mpcTxInput);

            // 获取稀有聪
            ApiResponse<GetSatoshisDetails>  rareSatoshiList = splitSatoshis.mpcClient.getRareSatoshis(coin, txHashAndVoutN.txHash, txHashAndVoutN.voutN);
            if (!rareSatoshiList.isSuccess()) {
                return;
            }

            // 判断有无稀有聪
            if (rareSatoshiList.getResult().getSatoshis().size() <= 0) {
                return;
            }

            // 拆分稀有聪
            BigInteger lastOffset = new BigInteger("0");
            boolean includeSatoshi = false;
            BigInteger dustThreshold = new BigInteger(String.valueOf(coinInfo.getResult().getDustThreshold()));
            for (GetSatoshisDetail detail : rareSatoshiList.getResult().getSatoshis()) {
                BigInteger delta = new BigInteger(detail.getOffset()).subtract(lastOffset);
                if (delta.compareTo(new BigInteger(String.valueOf(dustThreshold))) < 0) {
                    includeSatoshi = true;
                    continue;
                }

                if (!includeSatoshi) {
                    outputValues.add(delta);
                } else {
                    outputValues.add(dustThreshold);
                    outputValues.add(delta.subtract(dustThreshold));
                }

                includeSatoshi = true;
                lastOffset = lastOffset.add(delta);
            }
        }


        ArrayList<HashMap<String, Object>> toAddressDetails = new ArrayList<>();
        for (BigInteger outputValue : outputValues) {
            HashMap<String, Object> toAddressDetail = new HashMap<>();
            // 这里面地址按需设置，可以设置为不同的地址
            toAddressDetail.put("to_address", satoshisAddress);
            toAddressDetail.put("amount", outputValue);

            toAddressDetails.add(toAddressDetail);
        }

        // 转账
        String requestId = String.valueOf(System.currentTimeMillis());
        HashMap<String, ArrayList<HashMap<String, Object>>> inputSelection = new HashMap<>();
        inputSelection.put("inputs_to_spend", inputsToSpend);
        HashMap<String, HashMap<String, ArrayList<HashMap<String, Object>>>> mpcExtraParameters = new HashMap<>();
        mpcExtraParameters.put("input_selection", inputSelection);
        ApiResponse<MPCPostTransaction> transferFeeResponse = splitSatoshis.mpcClient.createTransaction(coin, requestId,
                null, null, null, JSON.toJSONString(toAddressDetails), null, null,
                null, null, JSON.toJSONString(mpcExtraParameters), null, null, null, null,
                0, null);
        if (!transferFeeResponse.isSuccess()) {
            return;
        }
        // 当拆分稀有聪的交易上链后(对应transferFeeResponse)，将拆分出稀有聪的utxo，调用lock_spendable api锁定
        // 根据回调获取稀有聪交易。并拿到相应的txHash, voutN
        String satoshisTxHash = "";
        Integer satoshisVoutN = 0;
        splitSatoshis.mpcClient.lockSpendable(coin, satoshisTxHash, satoshisVoutN);
    }
}
