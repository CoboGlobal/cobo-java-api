package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatementId {
    @JsonProperty(value = "statement_id")
    private String statementId;

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    @Override
    public String toString() {
        return "StatementId{" +
                "statementId='" + statementId + '\'' +
                '}';
    }
}
