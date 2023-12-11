package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCNft {
    @JsonProperty(value = "nft_code")
    private String nftCode;
    @JsonProperty(value = "token_id")
    private String tokenId;
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

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
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
                "nftCode=" + nftCode +
                ", tokenId=" + tokenId +
                ", chainCode=" + chainCode +
                ", contractAddress=" + contractAddress +
                '}';
    }
}
