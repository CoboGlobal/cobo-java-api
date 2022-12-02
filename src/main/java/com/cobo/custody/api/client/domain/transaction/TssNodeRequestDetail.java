package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TssNodeRequestDetail {
    @JsonProperty(value = "cobo_id")
    private String coboId;
    @JsonProperty(value = "request_type")
    private Integer requestType;
    @JsonProperty(value = "status")
    private Integer status;
    @JsonProperty(value = "failed_reason")
    private String failedReason;
    private String meta;

    public String getCoboId() {
        return coboId;
    }

    public void setCoboId(String coboId) {
        this.coboId = coboId;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "{" +
                "coboId='" + coboId + '\'' +
                ", requestType='" + requestType + '\'' +
                ", status='" + status + '\'' +
                ", failedReason='" + failedReason + '\'' +
                ", meta='" + meta + '\'' +
                '}';
    }
}
