package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class MPCUnspentInputs {
    private String address;
    @JsonProperty(value = "tx_hash")
    private String txHash;
    @JsonProperty(value = "vout_n")
    private Integer voutN;

    private BigInteger amount;
    @JsonProperty(value = "confirmed_num")
    private Integer confirmedNum;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public Integer getConfirmedNum() {
        return confirmedNum;
    }

    public void setConfirmedNum(Integer confirmedNum) {
        this.confirmedNum = confirmedNum;
    }

    @Override
    public String toString() {
        return "{" +
                "txHash='" + txHash + '\'' +
                ", voutN='" + voutN + '\'' +
                ", address='" + address + '\'' +
                ", amount='" + amount + '\'' +
                ", confirmedNum='" + confirmedNum + '\'' +
                '}';
    }
}
