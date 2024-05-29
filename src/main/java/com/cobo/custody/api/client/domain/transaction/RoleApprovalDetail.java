package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RoleApprovalDetail {
    @JsonProperty(value = "role_result")
    private Integer roleResult;

    @JsonProperty(value = "review_threshold")
    private Integer reviewThreshold;

    @JsonProperty(value = "user_details")
    private Map<String, UserApprovalResult> userDetails;

    private String initiator;

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public Integer getRoleResult() {
        return roleResult;
    }

    public void setRoleResult(Integer roleResult) {
        this.roleResult = roleResult;
    }

    public Integer getReviewThreshold() {
        return reviewThreshold;
    }

    public void setReviewThreshold(Integer reviewThreshold) {
        this.reviewThreshold = reviewThreshold;
    }

    public Map<String, UserApprovalResult> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Map<String, UserApprovalResult> userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "RoleApprovalDetail{" +
                "roleResult=" + roleResult +
                ", reviewThreshold=" + reviewThreshold +
                ", userDetails=" + userDetails +
                ", initiator='" + initiator + '\'' +
                '}';
    }
}
