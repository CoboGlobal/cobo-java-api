package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCBalance {
    @JsonProperty(value = "coin_data")
    private List<MPCCoinBalanceDetail> coinData;

    public List<MPCCoinBalanceDetail> getCoinData() {
        return coinData;
    }

    public void setCoinData(List<MPCCoinBalanceDetail> coinData) {
        this.coinData = coinData;
    }

    @Override
    public String toString() {
        return "{" +
                "coinData=" + coinData +
                '}';
    }
}
