package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class EstimateFeeDetail {
    @JsonProperty(value = "fee_per_byte")
    private BigInteger feePerByte;
    @JsonProperty(value = "gas_price")
    private BigInteger gasPrice;
    @JsonProperty(value = "gas_limit")
    private BigInteger gasLimit;

    @JsonProperty(value = "fee_amount")
    private BigInteger feeAmount;

    @JsonProperty(value = "fee_reserved")
    private BigInteger feeReserved;

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

    public BigInteger getFeeReserved() {
        return feeReserved;
    }

    public void setFeeReserved(BigInteger feeReserved) {
        this.feeReserved = feeReserved;
    }

    @Override
    public String toString() {
        return "{" +
                "feePerByte='" + feePerByte + '\'' +
                ", gasPrice='" + gasPrice + '\'' +
                ", gasLimit='" + gasLimit + '\'' +
                ", feeAmount='" + feeAmount + '\'' +
                ", feeReserved='" + feeReserved + '\'' +
                '}';
    }
}
