package com.cobo.custody.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statement {
    private String id;
    @JsonProperty(value = "user_id")
    private String userId;
    private String pubkey;
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPubkey() {
        return pubkey;
    }

    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", pubkey='" + pubkey + '\'' +
                ", status=" + status +
                '}';
    }
}
