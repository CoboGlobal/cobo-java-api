package com.cobo.custody.api.client.domain.account;

import java.util.List;

public class MPCAddress {
    private String address;
    private Integer type;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "address='" + address + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
