package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TssNodeKeyGenMeta {
    @JsonProperty(value = "cobo_id")
    private String coboId;
    @JsonProperty(value = "threshold")
    private Integer threshold;
    @JsonProperty(value = "node_ids")
    private List<String> nodeIds;

    public String getCoboId() {
        return coboId;
    }

    public void setCoboId(String coboId) {
        this.coboId = coboId;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public List<String> getNodeIds() {
        return nodeIds;
    }

    public void setNodeIds(List<String> nodeIds) {
        this.nodeIds = nodeIds;
    }

    @Override
    public String toString() {
        return "{" +
                "coboId='" + coboId + '\'' +
                ", threshold='" + threshold + '\'' +
                ", nodeIds='" + nodeIds + '\'' +
                '}';
    }
}
