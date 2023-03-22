package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCNftCollection {
    @JsonProperty(value = "nft_code")
    private String nftCode;
    @JsonProperty(value = "chain_code")
    private String chainCode;
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
                ", contract_address='" + contractAddress + '\'' +
                '}';
    }
}
