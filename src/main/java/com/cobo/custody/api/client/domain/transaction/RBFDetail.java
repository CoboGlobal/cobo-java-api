package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RBFDetail {
    @JsonProperty(value = "replaced_by")
    private String replacedBy;
    private String replaced;

    public String getReplacedBy() {
        return replacedBy;
    }

    public void setReplacedBy(String replacedBy) {
        this.replacedBy = replacedBy;
    }

    public String getReplaced() {
        return replaced;
    }

    public void setReplaced(String replaced) {
        this.replaced = replaced;
    }

    @Override
    public String toString() {
        return "{" +
                "replacedBy='" + replacedBy + '\'' +
                ", replaced='" + replaced + '\'' +
                '}';
    }
}
