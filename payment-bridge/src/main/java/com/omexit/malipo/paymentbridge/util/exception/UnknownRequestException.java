package com.omexit.paymentbridge.core.util.exception;


import com.omexit.paymentbridge.core.util.types.ErrorCode;

/**
 * Created by aomeri on 12/9/2015.
 */
public class UnknownRequestException extends Exception {
    private static final long serialVersionUID = 48598860123L;
    private String developerMessage;
    private ErrorCode errorCode;
    private String message;

    public UnknownRequestException(String message, String developerMessage, ErrorCode errorCode) {
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
