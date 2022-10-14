package com.cobo.custody.api.client.domain.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Web3ContractMethods {
    @JsonProperty(value = "contract_methods")
    private List<Web3ContractMethod> contractMethods;

    public List<Web3ContractMethod> getContractMethods() {
        return contractMethods;
    }

    public void setContractMethods(List<Web3ContractMethod> contractMethods) {
        this.contractMethods = contractMethods;
    }

    @Override
    public String toString() {
        return "{" +
                "contract_methods='" + contractMethods + '\'' +
                '}';
    }
}
