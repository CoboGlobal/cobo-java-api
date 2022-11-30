package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MPCAddresses {
    private List<MPCAddress> addresses;
    @JsonProperty(value = "total")
    private Integer total;

    public List<MPCAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<MPCAddress> addresses) {
        this.addresses = addresses;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{" +
                "addresses='" + addresses + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
