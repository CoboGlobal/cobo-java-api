package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Web3NftCollections {
    @JsonProperty(value = "nft_collections")
    private List<Web3NftCollection> nftCollections;

    public List<Web3NftCollection> getNftCollections() {
        return nftCollections;
    }

    public void setNftCollections(List<Web3NftCollection> nftCollections) {
        this.nftCollections = nftCollections;
    }

    @Override
    public String toString() {
        return "{" +
                "nft_collections='" + nftCollections + '\'' +
                '}';
    }
}
