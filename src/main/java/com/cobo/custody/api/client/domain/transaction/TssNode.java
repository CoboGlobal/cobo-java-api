package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TssNode {
    @JsonProperty(value = "node_id")
    private String nodeId;
    private Integer type;
    private Boolean online;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "TssNode{" +
                "nodeId='" + nodeId + '\'' +
                ", type=" + type +
                ", online=" + online +
                '}';
    }
}
