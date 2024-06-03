package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BabylonStakingTransaction {
    @JsonProperty(value = "request_id")
    private String requestId;
    @JsonProperty(value = "cobo_id")
    private String coboId;
    @JsonProperty(value = "staking_info")
    private String stakingInfo;
    @JsonProperty(value = "fee_rate")
    private BigDecimal feeRate;
    @JsonProperty(value = "max_staking_fee")
    private BigInteger maxStakingFee;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCoboId() {
        return coboId;
    }

    public void setCoboId(String coboId) {
        this.coboId = coboId;
    }

    public String getStakingInfo() {
        return stakingInfo;
    }

    public void setStakingInfo(String stakingInfo) {
        this.stakingInfo = stakingInfo;
    }

    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    public BigInteger getMaxStakingFee() {
        return maxStakingFee;
    }

    public void setMaxStakingFee(BigInteger maxStakingFee) {
        this.maxStakingFee = maxStakingFee;
    }

    @Override
    public String toString() {
        return "BabylonStakingTransaction{" +
                "requestId='" + requestId + '\'' +
                ", coboId='" + coboId + '\'' +
                ", stakingInfo='" + stakingInfo + '\'' +
                ", feeRate=" + feeRate +
                ", maxStakingFee=" + maxStakingFee +
                '}';
    }
}
