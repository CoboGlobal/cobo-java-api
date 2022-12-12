package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCRbfTransaction {
    @JsonProperty(value = "cobo_id")
    private String coboId;

    public String getCoboId() {
        return coboId;
    }

    public void setCoboId(String coboId) {
        this.coboId = coboId;
    }

    public String toString() {
        return "{" +
                "coboId='" + coboId + '\'' +
                '}';
    }
}
