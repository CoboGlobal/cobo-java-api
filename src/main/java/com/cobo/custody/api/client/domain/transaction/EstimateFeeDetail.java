package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class EstimateFeeDetail {
    @JsonProperty(value = "fee_per_byte")
    private String feePerByte;
    @JsonProperty(value = "gas_price")
    private String gasPrice;
    @JsonProperty(value = "gas_limit")
    private String gasLimit;

    public String getFeePerByte() {
        return feePerByte;
    }

    public void setFeePerByte(String feePerByte) {
        this.feePerByte = feePerByte;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(String gasLimit) {
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
