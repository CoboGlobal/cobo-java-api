package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class SelectedUTXO {
    @JsonProperty(value = "tx_hash")
    private String txHash;
    @JsonProperty(value = "vout_n")
    private Integer voutN;
    @JsonProperty(value = "address")
    private String address;
    @JsonProperty(value = "value")
    private BigInteger value;

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public Integer getVoutN() {
        return voutN;
    }

    public void setVoutN(Integer voutN) {
        this.voutN = voutN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SelectedUTXO{" +
                "txHash='" + txHash + '\'' +
                ", voutN=" + voutN +
                ", address='" + address + '\'' +
                ", value=" + value +
                '}';
    }
}
