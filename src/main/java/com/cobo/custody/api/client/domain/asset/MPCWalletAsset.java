package com.cobo.custody.api.client.domain.asset;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCWalletAsset {
    @JsonProperty(value = "coin_data")
    private List<MPCCoinBalanceDetail> coinInfoList;

    public List<MPCCoinBalanceDetail> getCoinInfoList() {
        return coinInfoList;
    }

    public void setCoinInfoList(List<MPCCoinBalanceDetail> coinInfoList) {
        this.coinInfoList = coinInfoList;
    }

    @Override
    public String toString() {
        return "{" +
                "coin_infos='" + coinInfoList + '\'' +
                '}';
    }
}
