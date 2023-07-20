package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TssNodes {
    @JsonProperty(value = "tss_nodes")
    private List<TssNode> tssNodes;

    public List<TssNode> getTssNodes() {
        return tssNodes;
    }

    public void setTssNodes(List<TssNode> tssNodes) {
        this.tssNodes = tssNodes;
    }

    @Override
    public String toString() {
        return "TssNodes{" +
                "tssNodes=" + tssNodes +
                '}';
    }
}
