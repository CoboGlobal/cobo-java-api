package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class MPCUtxo {
    @JsonProperty(value = "tx_hash")
    private String txHash;
    @JsonProperty(value = "vout_n")
    private Integer voutN;
    private String address;
    private BigInteger amount;
    @JsonProperty(value = "is_coinbase")
    private Boolean isCoinBase;
    @JsonProperty(value = "confirmed_number")
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

    public Boolean getCoinBase() {
        return isCoinBase;
    }

    public void setCoinBase(Boolean coinBase) {
        isCoinBase = coinBase;
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
                ", isCoinBase='" + isCoinBase + '\'' +
                ", confirmedNum='" + confirmedNum + '\'' +
                '}';
    }
}
