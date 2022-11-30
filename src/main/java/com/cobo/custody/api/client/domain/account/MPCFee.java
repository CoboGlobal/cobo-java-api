package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class MPCFee {
    @JsonProperty(value = "fee_coin_detail")
    private MPCCoin feeCoinDetail;
    @JsonProperty(value = "gas_price")
    private String gasPrice;
    @JsonProperty(value = "gas_limit")
    private BigInteger gasLimit;
    @JsonProperty(value = "fee_used")
    private String feeUsed;

    public MPCCoin getFeeCoinDetail() {
        return feeCoinDetail;
    }

    public void setFeeCoinDetail(MPCCoin feeCoinDetail) {
        this.feeCoinDetail = feeCoinDetail;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public BigInteger getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(BigInteger gasLimit) {
        this.gasLimit = gasLimit;
    }

    public String getFeeUsed() {
        return feeUsed;
    }

    public void setFeeUsed(String feeUsed) {
        this.feeUsed = feeUsed;
    }

    @Override
    public String toString() {
        return "{" +
                "feeCoinDetail='" + feeCoinDetail + '\'' +
                ", gasPrice='" + gasPrice + '\'' +
                ", gasLimit='" + gasLimit + '\'' +
                ", feeUsed='" + feeUsed + '\'' +
                '}';
    }
}
