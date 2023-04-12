package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCNftCollection {
    @JsonProperty(value = "nft_code")
    private String nftCode;
    @JsonProperty(value = "chain_code")
    private String chainCode;
    @JsonProperty(value = "display_code")
    private String displayCode;
    private String description;
    private String standard;
    @JsonProperty(value = "contract_address")
    private String contractAddress;

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

    @Override
    public String toString() {
        return "{" +
                "nft_code='" + nftCode + '\'' +
                ", chain_code='" + chainCode + '\'' +
                ", display_code='" + displayCode + '\'' +
                ", description='" + description + '\'' +
                ", standard='" + standard + '\'' +
                ", contract_address='" + contractAddress + '\'' +
                '}';
    }
}
