package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class GetSatoshisDetail {
    @JsonProperty(value = "satoshi_id")
    private String satoshiId;
    private String offset;
    @JsonProperty(value = "block_height")
    private BigInteger blockHeight;
    @JsonProperty(value = "rarity_level")
    private String rarityLevel;

    public String getSatoshiId() {
        return satoshiId;
    }

    public void setSatoshiId(String satoshiId) {
        this.satoshiId = satoshiId;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public BigInteger getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(BigInteger blockHeight) {
        this.blockHeight = blockHeight;
    }

    public String getRarityLevel() {
        return rarityLevel;
    }

    public void setRarityLevel(String rarityLevel) {
        this.rarityLevel = rarityLevel;
    }

    @Override
    public String toString() {
        return "GetSatoshisDetail{" +
                "satoshiId='" + satoshiId + '\'' +
                ", offset=" + offset + '\'' +
                ", blockHeight='" + blockHeight + '\'' +
                ", rarityLevel=" + rarityLevel + '\'' +
                '}';
    }
}
