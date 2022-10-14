package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Web3TransactionInfo {
    @JsonProperty(value = "tx_info")
    private Web3Transaction txInfo;

    public Web3Transaction getTxInfo() {
        return txInfo;
    }

    public void setTxInfo(Web3Transaction txInfo) {
        this.txInfo = txInfo;
    }

    @Override
    public String toString() {
        return "{" +
                "tx_info='" + txInfo + '\'' +
                '}';
    }
}
