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

    @Override
    public String toString() {
        return "{" +
                "feePerByte='" + feePerByte + '\'' +
                ", gasPrice='" + gasPrice + '\'' +
                ", gasLimit='" + gasLimit + '\'' +
                '}';
    }
}
