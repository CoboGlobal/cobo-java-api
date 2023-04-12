package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrimeBrokerAddress {
    @JsonProperty(value = "chain_coin")
    private String chainCoin;

    @JsonProperty(value = "address")
    private String address;

    public PrimeBrokerAddress() {}

    public PrimeBrokerAddress(String chainCoin, String address) {
        this.chainCoin = chainCoin;
        this.address = address;
    }

    public String getChainCoin() {
        return chainCoin;
    }

    public void setChainCoin(String chainCoin) {
        this.chainCoin = chainCoin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PrimeBrokerAddress{" +
                "chainCoin='" + chainCoin + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
