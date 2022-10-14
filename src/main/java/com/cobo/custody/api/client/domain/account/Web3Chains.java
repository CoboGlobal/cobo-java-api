package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Web3Chains {
    @JsonProperty(value = "chain_codes")
    private List<String> chainCodes;

    public List<String> getChainCodes() {
        return chainCodes;
    }

    public void setChainCodes(List<String> chainCodes) {
        this.chainCodes = chainCodes;
    }

    @Override
    public String toString() {
        return "{" +
                "chain_codes='" + chainCodes + '\'' +
                '}';
    }
}
