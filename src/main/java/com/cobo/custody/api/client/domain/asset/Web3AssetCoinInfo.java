package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Web3AssetCoinInfo {
    private String coin;
    @JsonProperty(value = "chain_coin")
    private String chainCoin;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private Long amount;

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getChainCoin() {
        return chainCoin;
    }

    public void setChainCoin(String chainCoin) {
        this.chainCoin = chainCoin;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{" +
                "coin='" + coin + '\'' +
                ", chain_coin='" + chainCoin + '\'' +
                ", display_code='" + displayCode + '\'' +
                ", description='" + description + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
