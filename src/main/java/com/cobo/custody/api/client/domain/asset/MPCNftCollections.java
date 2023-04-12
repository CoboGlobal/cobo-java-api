package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCNftCollections {
    @JsonProperty(value = "nft_collections")
    private List<MPCNftCollection> nftCollections;

    public List<MPCNftCollection> getNftCollections() {
        return nftCollections;
    }

    public void setNftCollections(List<MPCNftCollection> nftCollections) {
        this.nftCollections = nftCollections;
    }

    @Override
    public String toString() {
        return "{" +
                "nft_collections='" + nftCollections + '\'' +
                '}';
    }
}
