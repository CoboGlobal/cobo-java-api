package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TssNodeRequestMeta {
    @JsonProperty(value = "key_gen")
    private TssNodeKeyGenMeta genMeta;
    @JsonProperty(value = "key_reshare")
    private TssNodeKeyReShareMeta reShareMeta;

    public TssNodeKeyGenMeta getGenMeta() {
        return genMeta;
    }

    public void setGenMeta(TssNodeKeyGenMeta genMeta) {
        this.genMeta = genMeta;
    }

    public TssNodeKeyReShareMeta getReShareMeta() {
        return reShareMeta;
    }

    public void setReShareMeta(TssNodeKeyReShareMeta reShareMeta) {
        this.reShareMeta = reShareMeta;
    }

    @Override
    public String toString() {
        return "{" +
                "genMeta='" + genMeta + '\'' +
                ", reShareMeta='" + reShareMeta + '\'' +
                '}';
    }
}
