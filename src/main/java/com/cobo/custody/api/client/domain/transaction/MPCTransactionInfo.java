package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCTransactionInfo {
    @JsonProperty(value = "tx_info")
    private MPCTransaction txInfo;

    public MPCTransaction getTxInfo() {
        return txInfo;
    }

    public void setTxInfo(MPCTransaction txInfo) {
        this.txInfo = txInfo;
    }

    @Override
    public String toString() {
        return "{" +
                "tx_info='" + txInfo + '\'' +
                '}';
    }
}
