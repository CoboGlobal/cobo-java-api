package com.cobo.api.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoboApiError {


    private boolean success;
    private int error_code;
    private String error_message;
    private String error_id;

    public CoboApiError() {
    }

    public CoboApiError(boolean success, int error_code, String error_message, String error_id) {
        this.success = success;
        this.error_code = error_code;
        this.error_message = error_message;
        this.error_id = error_id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getError_id() {
        return error_id;
    }

    public void setError_id(String error_id) {
        this.error_id = error_id;
    }

    @Override
    public String toString() {
        return "CoboApiError{" +
                "success=" + success +
                ", error_code=" + error_code +
                ", error_message='" + error_message + '\'' +
                ", error_id='" + error_id + '\'' +
                '}';
    }
}
