package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UTXO {
    @JsonProperty(value = "tx_hash")
    private String txHash;
    @JsonProperty(value = "vout_n")
    private Integer voutN;
    @JsonProperty(value = "address")
    private String address;
    @JsonProperty(value = "amount")
    private Integer amount;
    @JsonProperty(value = "is_coinbase")
    private Boolean isCoinbase;
    @JsonProperty(value = "confirmed_number")
    private Integer confirmedNumber;

    @JsonProperty(value = "locked")
    private Boolean locked;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getCoinbase() {
        return isCoinbase;
    }

    public void setCoinbase(Boolean coinbase) {
        isCoinbase = coinbase;
    }

    public Integer getConfirmedNumber() {
        return confirmedNumber;
    }

    public void setConfirmedNumber(Integer confirmedNumber) {
        this.confirmedNumber = confirmedNumber;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "{" +
                "txHash='" + txHash + '\'' +
                ", voutN=" + voutN +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", isCoinbase=" + isCoinbase +
                ", confirmedNumber=" + confirmedNumber +
                ", locked=" + locked +
                '}';
    }
}
