package com.cobo.api.client.domain;

public class Response<T> {
    T result;
    private boolean success;
    private int error_code;
    private String error_message;
    private String error_id;
    private String error_description;

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public int getError_code() {
        return error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public String getError_id() {
        return error_id;
    }

    public String getError_description() {
        return error_description;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", error_code=" + error_code +
                ", error_message='" + error_message + '\'' +
                ", error_id='" + error_id + '\'' +
                ", error_description='" + error_description + '\'' +
                ", result=" + result +
                '}';
    }
}
