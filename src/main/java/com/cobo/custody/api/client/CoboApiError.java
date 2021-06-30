package com.cobo.custody.api.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoboApiError {


    private boolean success;
    @JsonProperty(value = "error_code")
    private int errorCode;
    @JsonProperty(value = "error_message")
    private String errorMessage;
    @JsonProperty(value = "error_id")
    private String errorId;

    public CoboApiError() {
    }

    public CoboApiError(boolean success, int error_code, String errorMessage, String errorId) {
        this.success = success;
        this.errorCode = error_code;
        this.errorMessage = errorMessage;
        this.errorId = errorId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    @Override
    public String toString() {
        return "CoboApiError{" +
                "success=" + success +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorId='" + errorId + '\'' +
                '}';
    }
}
