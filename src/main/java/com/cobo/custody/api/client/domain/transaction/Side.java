package com.cobo.custody.api.client.domain.transaction;

public enum Side {
    Deposit("deposit"),
    Withdraw("withdraw"),
    Any(null);

    String value;

    Side(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
