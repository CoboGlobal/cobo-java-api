package com.cobo.custody.api.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse<T> {
    T result;
    private boolean success;
    @JsonProperty(value = "error_code")
    private int errorCode;
    @JsonProperty(value = "error_message")
    private String errorMessage;
    @JsonProperty(value = "error_id")
    private String errorId;
    @JsonProperty(value = "error_description")
    private String errorDescription;

    public ApiResponse() {
    }

    public ApiResponse(T result, boolean success, int errorCode,
                       String errorMessage, String errorId,
                       String errorDescription) {
        this.result = result;
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorId = errorId;
        this.errorDescription = errorDescription;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorId() {
        return errorId;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorId='" + errorId + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                ", result=" + result +
                '}';
    }
}
