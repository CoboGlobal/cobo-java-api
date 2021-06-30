package com.cobo.custody.api.client.exception;

import com.cobo.custody.api.client.CoboApiError;

/**
 * An exception which can occur while invoking methods of the Cobo API.
 */
public class CoboApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
    /**
     * Error response object returned by Cobo API.
     */
    private CoboApiError error;

    /**
     * Instantiates a new Cobo api exception.
     *
     * @param error an error response object
     */
    public CoboApiException(CoboApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new Cobo api exception.
     */
    public CoboApiException() {
        super();
    }

    /**
     * Instantiates a new Cobo api exception.
     *
     * @param message the message
     */
    public CoboApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Cobo api exception.
     *
     * @param cause the cause
     */
    public CoboApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Cobo api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public CoboApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Cobo API, or null if no response object was returned (e.g. server returned 500).
     */
    public CoboApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getErrorMessage();
        }
        return super.getMessage();
    }
}
