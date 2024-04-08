package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCUTXOAssetInfo {
    @JsonProperty(value = "chain_coin")
    private String chainCoin;
    @JsonProperty(value = "txid")
    private String txId;

    @JsonProperty(value = "vout_n")
    private Integer voutN;

    private Boolean pending;

    private MPCUTXOAsset assets;

    public String getChainCoin() {
        return chainCoin;
    }

    public void setChainCoin(String chainCoin) {
        this.chainCoin = chainCoin;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Integer getVoutN() {
        return voutN;
    }

    public void setVoutN(Integer voutN) {
        this.voutN = voutN;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public MPCUTXOAsset getAssets() {
        return assets;
    }

    public void setAssets(MPCUTXOAsset assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "MPCUTXOAssetInfo{" +
                "chainCoin='" + chainCoin + '\'' +
                ", txId='" + txId + '\'' +
                ", voutN=" + voutN +
                ", pending=" + pending +
                ", assets=" + assets +
                '}';
    }
}
