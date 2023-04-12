package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCNftBalanceDetail {
    @JsonProperty(value = "nft_code")
    private String nftCode;
    @JsonProperty(value = "token_id")
    private String tokenId;
    @JsonProperty(value = "address")
    private String address;
    @JsonProperty(value = "chain_code")
    private String chainCode;
    @JsonProperty(value = "contract_address")
    private String contractAddress;
    private Integer balance;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "{" +
                "nftCode=" + nftCode +
                ", tokenId=" + tokenId +
                ", address=" + address +
                ", chainCode=" + chainCode +
                ", contractAddress=" + contractAddress +
                ", balance=" + balance +
                '}';
    }
}
