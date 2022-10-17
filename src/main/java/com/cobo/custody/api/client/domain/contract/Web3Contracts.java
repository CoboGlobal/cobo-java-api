package com.cobo.custody.api.client.domain.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Web3Contracts {
    @JsonProperty(value = "contract_addresses")
    private List<String> contractAddresses;

    public List<String> getContractAddresses() {
        return contractAddresses;
    }

    public void setContractAddresses(List<String> contractAddresses) {
        this.contractAddresses = contractAddresses;
    }

    @Override
    public String toString() {
        return "{" +
                "contract_addresses='" + contractAddresses + '\'' +
                '}';
    }
}
