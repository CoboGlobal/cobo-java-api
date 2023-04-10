package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrimeBrokerBinderInfo {
    @JsonProperty(value = "binder_id")
    private String binderId;

    public String getBinderId() {
        return binderId;
    }

    public void setBinderId(String binderId) {
        this.binderId = binderId;
    }

    @Override
    public String toString() {
        return "PrimeBrokerBinderInfo{" +
                "binderId='" + binderId + '\'' +
                '}';
    }
}
