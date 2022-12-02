package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCCoinBalanceDetail {
    private String address;
    private String coin;
    @JsonProperty(value = "chain_code")
    private String chainCode;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private String balance;

    private Integer decimal;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getDisplayCode() {
        return displayCode;
    }

    public void setDisplayCode(String displayCode) {
        this.displayCode = displayCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Integer getDecimal() {
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }

    @Override
    public String toString() {
        return "{" +
                "address='" + address + '\'' +
                ", coin='" + coin + '\'' +
                ", chain_code='" + chainCode + '\'' +
                ", display_code='" + displayCode + '\'' +
                ", description='" + description + '\'' +
                ", balance='" + balance + '\'' +
                ", decimal='" + decimal + '\'' +
                '}';
    }
}
