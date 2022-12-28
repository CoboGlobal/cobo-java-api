package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstimateFeeDetails {
    private EstimateFeeDetail slow;
    private EstimateFeeDetail average;
    private EstimateFeeDetail fast;

    @JsonProperty(value = "fee_coin")
    private String feeCoin;

    @JsonProperty(value = "fee_decimal")
    private Integer feeDecimal;


    public EstimateFeeDetail getSlow() {
        return slow;
    }

    public void setSlow(EstimateFeeDetail slow) {
        this.slow = slow;
    }

    public EstimateFeeDetail getAverage() {
        return average;
    }

    public void setAverage(EstimateFeeDetail average) {
        this.average = average;
    }

    public EstimateFeeDetail getFast() {
        return fast;
    }

    public void setFast(EstimateFeeDetail fast) {
        this.fast = fast;
    }

    public String getFeeCoin() {
        return feeCoin;
    }

    public void setFeeCoin(String feeCoin) {
        this.feeCoin = feeCoin;
    }

    public Integer getFeeDecimal() {
        return feeDecimal;
    }

    public void setFeeDecimal(Integer feeDecimal) {
        this.feeDecimal = feeDecimal;
    }

    @Override
    public String toString() {
        return "{" +
                "slow='" + slow + '\'' +
                ", average='" + average + '\'' +
                ", fast='" + fast + '\'' +
                ", feeCoin='" + feeCoin + '\'' +
                ", feeDecimal='" + feeDecimal + '\'' +
                '}';
    }
}
