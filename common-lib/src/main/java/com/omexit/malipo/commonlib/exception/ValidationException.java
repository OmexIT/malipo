package com.omexit.malipo.commonlib.exception;


import com.omexit.malipo.commonlib.types.ErrorCode;

/**
 * Created by aomeri on 12/9/2015.
 */
public class ValidationException extends Exception {
    private static final long serialVersionUID = 48598860124L;
    private String developerMessage;
    private ErrorCode errorCode;
    private String message;

    public ValidationException(String message, String developerMessage, ErrorCode errorCode) {
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
