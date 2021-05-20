package com.cobo.api.client.domain;

public enum Lang {
    CHINESE("zh"),
    ENGLISG("en");

    String value;
    Lang(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
