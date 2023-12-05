package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class GetSendMaxDetail {
    @JsonProperty(value = "coin")
    private String coin;
    @JsonProperty(value = "coin_decimal")
    private Integer coinDecimal;
    @JsonProperty(value = "fee_coin")
    private String feeCoin;
    @JsonProperty(value = "fee_decimal")
    private Integer feeDecimal;
    @JsonProperty(value = "fee_per_byte")
    private BigInteger feePerByte;
    @JsonProperty(value = "gas_price")
    private BigInteger gasPrice;
    @JsonProperty(value = "gas_limit")
    private BigInteger gasLimit;

    @JsonProperty(value = "fee_amount")
    private BigInteger feeAmount;
    @JsonProperty(value = "max_send_value")
    private BigInteger maxSendValue;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Integer getCoinDecimal() {
        return coinDecimal;
    }

    public void setCoinDecimal(Integer coinDecimal) {
        this.coinDecimal = coinDecimal;
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

    public BigInteger getFeePerByte() {
        return feePerByte;
    }

    public void setFeePerByte(BigInteger feePerByte) {
        this.feePerByte = feePerByte;
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(BigInteger gasPrice) {
        this.gasPrice = gasPrice;
    }

    public BigInteger getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(BigInteger gasLimit) {
        this.gasLimit = gasLimit;
    }

    public BigInteger getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigInteger feeAmount) {
        this.feeAmount = feeAmount;
    }

    public BigInteger getMaxSendValue() {
        return maxSendValue;
    }

    public void setMaxSendValue(BigInteger maxSendValue) {
        this.maxSendValue = maxSendValue;
    }

    @Override
    public String toString() {
        return "GetSendMaxDetail{" +
                "coin='" + coin + '\'' +
                ", coinDecimal=" + coinDecimal +
                ", feeCoin='" + feeCoin + '\'' +
                ", feeDecimal=" + feeDecimal +
                ", feePerByte=" + feePerByte +
                ", gasPrice=" + gasPrice +
                ", gasLimit=" + gasLimit +
                ", feeAmount=" + feeAmount +
                ", maxSendValue=" + maxSendValue +
                '}';
    }
}
