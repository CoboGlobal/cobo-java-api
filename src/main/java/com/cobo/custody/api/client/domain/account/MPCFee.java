package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
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

    @JsonProperty(value = "fee")
    private BigDecimal fee;
    @JsonProperty(value = "max_fee_amount")
    private String maxFeeAmount;

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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getMaxFeeAmount() {
        return maxFeeAmount;
    }

    public void setMaxFeeAmount(String maxFeeAmount) {
        this.maxFeeAmount = maxFeeAmount;
    }

    @Override
    public String toString() {
        return "{" +
                "feeCoinDetail='" + feeCoinDetail + '\'' +
                ", gasPrice='" + gasPrice + '\'' +
                ", gasLimit='" + gasLimit + '\'' +
                ", feeUsed='" + feeUsed + '\'' +
                ", fee='" + fee + '\'' +
                ", maxFeeAmount='" + maxFeeAmount + '\'' +
                '}';
    }
}
