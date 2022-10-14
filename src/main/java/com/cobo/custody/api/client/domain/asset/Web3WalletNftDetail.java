package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Web3WalletNftDetail {
    @JsonProperty(value = "nft_code")
    private String nftCode;
    @JsonProperty(value = "chain_coin")
    private String chainCoin;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private Double balance;
    @JsonProperty(value = "token_type")
    private String tokenType;
    @JsonProperty(value = "token_address")
    private String tokenAddress;
    @JsonProperty(value = "token_id")
    private String tokenId;


    public String getNftCode() {
        return nftCode;
    }

    public void setNftCode(String nftCode) {
        this.nftCode = nftCode;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    @Override
    public String toString() {
        return "{" +
                "nft_code='" + nftCode + '\'' +
                ", chain_coin='" + chainCoin + '\'' +
                ", display_code='" + displayCode + '\'' +
                ", description='" + description + '\'' +
                ", balance='" + balance + '\'' +
                ", token_type='" + tokenType + '\'' +
                ", token_address='" + tokenAddress + '\'' +
                ", token_id='" + tokenId + '\'' +
                '}';
    }
}
