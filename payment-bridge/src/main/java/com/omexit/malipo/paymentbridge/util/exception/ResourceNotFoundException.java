package com.omexit.paymentbridge.core.util.exception;


import com.omexit.paymentbridge.core.util.types.ErrorCode;

/**
 * Created by Antony on 7/19/2016.
 */
public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 48598860122L;
    private String developerMessage;
    private ErrorCode errorCode;
    private String message;

    public ResourceNotFoundException(String message, String developerMessage, ErrorCode errorCode) {
        super(developerMessage);
        this.developerMessage = developerMessage;
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
