package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Web3WalletAsset {
    @JsonProperty(value = "coin_infos")
    private List<Web3AssetCoinInfo> coinInfoList;
    @JsonProperty(value = "nft_infos")
    private List<Web3AssetNftInfo> nftInfoList;

    public List<Web3AssetCoinInfo> getCoinInfoList() {
        return coinInfoList;
    }

    public void setCoinInfoList(List<Web3AssetCoinInfo> coinInfoList) {
        this.coinInfoList = coinInfoList;
    }

    public List<Web3AssetNftInfo> getNftInfoList() {
        return nftInfoList;
    }

    public void setNftInfoList(List<Web3AssetNftInfo> nftInfoList) {
        this.nftInfoList = nftInfoList;
    }

    @Override
    public String toString() {
        return "{" +
                "coin_infos='" + coinInfoList + '\'' +
                ", nft_infos='" + nftInfoList + '\'' +
                '}';
    }
}
