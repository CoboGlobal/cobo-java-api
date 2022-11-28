package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCAddresses {
    private List<MPCAddress> addresses;
    @JsonProperty(value = "total_count")
    private Integer totalCount;

    public List<MPCAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<MPCAddress> addresses) {
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
