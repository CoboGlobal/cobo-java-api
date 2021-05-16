package com.cobo.api.client.domain;

public enum Side {
    Deposit("deposit"),
    Withdraw("withdrawa"),
    Any(null);

    String value;

    Side(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
