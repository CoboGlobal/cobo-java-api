package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCListBalances {
    @JsonProperty(value = "coin_data")
    private List<MPCCoinBalanceDetail> coinData;

    @JsonProperty(value = "total")
    private Integer total;

    public List<MPCCoinBalanceDetail> getCoinData() {
        return coinData;
    }

    public void setCoinData(List<MPCCoinBalanceDetail> coinData) {
        this.coinData = coinData;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
                "coinData=" + coinData +
                ", total=" + total +
                '}';
    }
}
