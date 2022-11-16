package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCWalletAsset {
    @JsonProperty(value = "coin_data")
    private List<MPCAssetCoinInfo> coinInfoList;

    public List<MPCAssetCoinInfo> getCoinInfoList() {
        return coinInfoList;
    }

    public void setCoinInfoList(List<MPCAssetCoinInfo> coinInfoList) {
        this.coinInfoList = coinInfoList;
    }

    @Override
    public String toString() {
        return "{" +
                "coin_infos='" + coinInfoList + '\'' +
                '}';
    }
}
