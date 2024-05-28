package com.cobo.custody.api.client.domain.transaction;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ApprovalDetails {
    private RoleApprovalDetail spender = null;
    private RoleApprovalDetail approver = null;
    private RoleApprovalDetail operator = null;
    @JsonProperty(value = "broker_user")
    private RoleApprovalDetail brokerUser = null;

    public RoleApprovalDetail getSpender() {
        return spender;
    }

    public void setSpender(RoleApprovalDetail spender) {
        this.spender = spender;
    }

    public RoleApprovalDetail getApprover() {
        return approver;
    }

    public void setApprover(RoleApprovalDetail approver) {
        this.approver = approver;
    }

    public RoleApprovalDetail getOperator() {
        return operator;
    }

    public void setOperator(RoleApprovalDetail operator) {
        this.operator = operator;
    }

    public RoleApprovalDetail getBrokerUser() {
        return brokerUser;
    }

    public void setBrokerUser(RoleApprovalDetail brokerUser) {
        this.brokerUser = brokerUser;
    }

    @Override
    public String toString() {
        return "ApprovalDetails{" +
                "spender=" + spender +
                ", approver=" + approver +
                ", operator=" + operator +
                ", brokerUser=" + brokerUser +
                '}';
    }
}
