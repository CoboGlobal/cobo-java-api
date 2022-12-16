package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCCoinBalanceDetail {
    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "coin")
    private String coin;

    @JsonProperty(value = "chain_code")
    private String chainCode;

    @JsonProperty(value = "display_code")
    private String displayCode;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "balance")
    private String balance;

    @JsonProperty(value = "decimal")
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
                ", chainCode='" + chainCode + '\'' +
                ", displayCode='" + displayCode + '\'' +
                ", description='" + description + '\'' +
                ", balance='" + balance + '\'' +
                ", decimal=" + decimal +
                '}';
    }
}
