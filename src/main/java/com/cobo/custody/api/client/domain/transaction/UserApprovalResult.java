package com.cobo.custody.api.client.domain.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserApprovalResult {
    private Integer result;
    private String signature;
    @JsonProperty(value = "last_time")
    private String lastTime;
    private String language;
    private String message;
    @JsonProperty(value = "message_version")
    private String messageVersion;
    @JsonProperty(value = "extra_message")
    private String extraMessage;

    @JsonProperty(value = "transaction_type")
    private String transactionType;

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public String getExtraMessage() {
        return extraMessage;
    }

    public void setExtraMessage(String extraMessage) {
        this.extraMessage = extraMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserApprovalResult{" +
                "result=" + result +
                ", signature='" + signature + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", language='" + language + '\'' +
                ", message='" + message + '\'' +
                ", messageVersion='" + messageVersion + '\'' +
                ", extraMessage='" + extraMessage + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
