package com.cobo.custody.api.client.domain.account;

import com.cobo.custody.api.client.domain.asset.MPCNftBalanceDetail;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCListBalances {
    @JsonProperty(value = "coin_data")
    private List<MPCCoinBalanceDetail> coinData;

    @JsonProperty(value = "nft_data")
    private List<MPCNftBalanceDetail> nftData;

    @JsonProperty(value = "total")
    private Integer total;

    public List<MPCCoinBalanceDetail> getCoinData() {
        return coinData;
    }

    public void setCoinData(List<MPCCoinBalanceDetail> coinData) {
        this.coinData = coinData;
    }

    public List<MPCNftBalanceDetail> getNftData() {
        return nftData;
    }

    public void setNftData(List<MPCNftBalanceDetail> nftData) {
        this.nftData = nftData;
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
                ", nftData=" + nftData +
                ", total=" + total +
                '}';
    }
}
