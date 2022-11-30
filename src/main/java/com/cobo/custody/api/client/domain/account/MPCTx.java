package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCTx {
    @JsonProperty(value = "tx_hash")
    private String txHash;

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    @Override
    public String toString() {
        return "{" +
                "txHash='" + txHash + '\'' +
                '}';
    }
}
