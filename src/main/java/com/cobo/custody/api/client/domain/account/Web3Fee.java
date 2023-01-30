package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class Web3Fee {
    @JsonProperty(value = "fee_coin_detail")
    private Web3Coin feeCoinDetail;
    @JsonProperty(value = "gas_price")
    private String gasPrice;
    @JsonProperty(value = "gas_limit")
    private BigInteger gasLimit;
    @JsonProperty(value = "fee_used")
    private String feeUsed;

    public Web3Coin getFeeCoinDetail() {
        return feeCoinDetail;
    }

    public void setFeeCoinDetail(Web3Coin feeCoinDetail) {
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
