package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstimateFeeDetails {
    private EstimateFeeDetail slow;
    private EstimateFeeDetail average;
    private EstimateFeeDetail fast;

    private EstimateFeeDetail custom;

    @JsonProperty(value = "fee_coin")
    private String feeCoin;

    @JsonProperty(value = "fee_decimal")
    private Integer feeDecimal;

    @JsonProperty(value = "rbf_minimum_limit")
    private Integer rbfMinimumLimit;

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

    public EstimateFeeDetail getCustom() {
        return custom;
    }

    public void setCustom(EstimateFeeDetail custom) {
        this.custom = custom;
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

    public Integer getRbfMinimumLimit() {
        return rbfMinimumLimit;
    }

    public void setRbfMinimumLimit(Integer rbfMinimumLimit) {
        this.rbfMinimumLimit = rbfMinimumLimit;
    }

    @Override
    public String toString() {
        return "{" +
                "slow='" + slow + '\'' +
                ", average='" + average + '\'' +
                ", fast='" + fast + '\'' +
                ", custom='" + custom + '\'' +
                ", feeCoin='" + feeCoin + '\'' +
                ", feeDecimal='" + feeDecimal + '\'' +
                ", rbfMinimumLimit='" + rbfMinimumLimit + '\'' +
                '}';
    }
}
