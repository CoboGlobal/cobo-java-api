package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TssNodeKeyReShareMeta {
    @JsonProperty(value = "cobo_id")
    private String coboId;
    @JsonProperty(value = "old_threshold")
    private Integer oldThreshold;
    @JsonProperty(value = "old_node_ids")
    private List<String> oldNodeIds;
    @JsonProperty(value = "new_threshold")
    private Integer newThreshold;
    @JsonProperty(value = "new_node_ids")
    private List<String> newNodeIds;

    public String getCoboId() {
        return coboId;
    }

    public void setCoboId(String coboId) {
        this.coboId = coboId;
    }

    public Integer getOldThreshold() {
        return oldThreshold;
    }

    public void setOldThreshold(Integer oldThreshold) {
        this.oldThreshold = oldThreshold;
    }

    public List<String> getOldNodeIds() {
        return oldNodeIds;
    }

    public void setOldNodeIds(List<String> oldNodeIds) {
        this.oldNodeIds = oldNodeIds;
    }

    public Integer getNewThreshold() {
        return newThreshold;
    }

    public void setNewThreshold(Integer newThreshold) {
        this.newThreshold = newThreshold;
    }

    public List<String> getNewNodeIds() {
        return newNodeIds;
    }

    public void setNewNodeIds(List<String> newNodeIds) {
        this.newNodeIds = newNodeIds;
    }

    @Override
    public String toString() {
        return "{" +
                "coboId='" + coboId +
                ", oldThreshold='" + oldThreshold +
                ", oldNodeIds='" + oldNodeIds +
                ", newThreshold='" + newThreshold +
                ", newNodeIds='" + newNodeIds +
                '}';
    }
}
