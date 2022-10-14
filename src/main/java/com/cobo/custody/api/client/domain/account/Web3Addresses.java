package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Web3Addresses {
    private List<String> addresses;
    @JsonProperty(value = "total_count")
    private Integer totalCount;

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "{" +
                "addresses='" + addresses + '\'' +
                ", total_count='" + totalCount + '\'' +
                '}';
    }
}
