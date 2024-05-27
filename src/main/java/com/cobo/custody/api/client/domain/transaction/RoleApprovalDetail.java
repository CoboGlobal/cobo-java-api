package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RoleApprovalDetail {
    private Integer result;

    @JsonProperty(value = "review_threshold")
    private Integer reviewThreshold;

    @JsonProperty(value = "user_details")
    private Map<String, UserApprovalResult> userDetails;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
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
                "result=" + result +
                ", reviewThreshold=" + reviewThreshold +
                ", userDetails=" + userDetails +
                '}';
    }
}
