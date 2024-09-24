package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCChains {
    @JsonProperty(value = "wallet_name")
    private String walletName;

    @JsonProperty(value = "chain_codes")
    private List<String> chainCodes;

    public List<String> getChainCodes() {
        return chainCodes;
    }

    public void setChainCodes(List<String> chainCodes) {
        this.chainCodes = chainCodes;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    @Override
    public String toString() {
        return "{" +
                "chain_codes='" + chainCodes + '\'' +
                ", walletName='" + walletName + '\'' +
                '}';
    }
}
