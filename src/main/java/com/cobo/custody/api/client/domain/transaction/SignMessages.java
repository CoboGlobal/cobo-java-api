package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SignMessages {
    @JsonProperty(value = "sign_messages")
    private List<SignMessage> signMessages;

    public List<SignMessage> getSignMessages() {
        return signMessages;
    }

    public void setSignMessages(List<SignMessage> signMessages) {
        this.signMessages = signMessages;
    }

    @Override
    public String toString() {
        return "{" +
                "signMessages='" + signMessages + '\'' +
                '}';
    }
}
