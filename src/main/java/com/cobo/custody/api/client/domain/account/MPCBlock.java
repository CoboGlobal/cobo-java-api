package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class MPCBlock {
    @JsonProperty(value = "block_hash")
    private String blockHash;
    @JsonProperty(value = "block_height")
    private BigInteger blockHeight;
    @JsonProperty(value = "block_time")
    private Long blockTime;

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public BigInteger getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(BigInteger blockHeight) {
        this.blockHeight = blockHeight;
    }

    public Long getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(Long blockTime) {
        this.blockTime = blockTime;
    }

    @Override
    public String toString() {
        return "{" +
                "blockHash='" + blockHash + '\'' +
                ", blockHeight='" + blockHeight + '\'' +
                ", blockTime='" + blockTime + '\'' +
                '}';
    }
}
