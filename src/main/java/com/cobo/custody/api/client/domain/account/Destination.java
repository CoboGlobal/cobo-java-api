package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class Destination {
    @JsonProperty(value = "address")
    private String address;
    @JsonProperty(value = "value")
    private BigInteger value;
    @JsonProperty(value = "is_change")
    private Boolean isChange;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public Boolean getChange() {
        return isChange;
    }

    public void setChange(Boolean change) {
        isChange = change;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "address='" + address + '\'' +
                ", value=" + value +
                ", isChange=" + isChange +
                '}';
    }
}
