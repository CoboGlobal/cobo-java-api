package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class MPCUTXOBRC20Asset {

    private BigInteger value;
    private Integer decimal;
    @JsonProperty(value = "cobo_coin_code")
    private String coinCode;

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public Integer getDecimal() {
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    @Override
    public String toString() {
        return "MPCUTXOBRC20Asset{" +
                "value=" + value +
                ", decimal=" + decimal +
                ", coinCode='" + coinCode + '\'' +
                '}';
    }
}
