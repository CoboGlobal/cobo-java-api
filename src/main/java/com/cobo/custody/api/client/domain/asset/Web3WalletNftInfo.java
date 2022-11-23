package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Web3WalletNftInfo {
    @JsonProperty(value = "nft_code")
    private String nftCode;
    @JsonProperty(value = "chain_code")
    private String chainCode;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private Double amount;
    private String standard;
    @JsonProperty(value = "contract_address")
    private String contractAddress;
    @JsonProperty(value = "token_id")
    private String tokenId;

    public String getNftCode() {
        return nftCode;
    }

    public void setNftCode(String nftCode) {
        this.nftCode = nftCode;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
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
                ", chain_code='" + chainCode + '\'' +
                ", display_code='" + displayCode + '\'' +
                ", description='" + description + '\'' +
                ", amount='" + amount + '\'' +
                ", standard='" + standard + '\'' +
                ", contract_address='" + contractAddress + '\'' +
                ", token_id='" + tokenId + '\'' +
                '}';
    }
}
