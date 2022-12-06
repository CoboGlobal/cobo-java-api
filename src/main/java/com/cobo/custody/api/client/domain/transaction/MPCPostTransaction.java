package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MPCPostTransaction {
    @JsonProperty(value = "cobo_id")
    private String coboId;
    private Integer status;

    public String getCoboId() {
        return coboId;
    }

    public void setCoboId(String coboId) {
        this.coboId = coboId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "{" +
                "coboId='" + coboId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
