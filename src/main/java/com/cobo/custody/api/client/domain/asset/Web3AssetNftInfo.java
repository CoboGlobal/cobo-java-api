package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Web3AssetNftInfo {
    @JsonProperty(value = "asset_code")
    private String assetCode;
    @JsonProperty(value = "chain_coin")
    private String chainCoin;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private Long amount;
    @JsonProperty(value = "token_type")
    private String tokenType;
    @JsonProperty(value = "token_address")
    private String tokenAddress;

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
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

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenAddress() {
        return tokenAddress;
    }

    public void setTokenAddress(String tokenAddress) {
        this.tokenAddress = tokenAddress;
    }

    @Override
    public String toString() {
        return "{" +
                "asset_code='" + assetCode + '\'' +
                ", chain_coin='" + chainCoin + '\'' +
                ", display_code='" + displayCode + '\'' +
                ", description='" + description + '\'' +
                ", amount='" + amount + '\'' +
                ", token_type='" + tokenType + '\'' +
                ", token_address='" + tokenAddress + '\'' +
                '}';
    }
}
