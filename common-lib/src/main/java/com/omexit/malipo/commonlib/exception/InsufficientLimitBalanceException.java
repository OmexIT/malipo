package com.omexit.malipo.commonlib.exception;


import com.omexit.malipo.commonlib.types.ErrorCode;

/**
 * Created by Antony on 7/19/2016.
 */
public class InsufficientLimitBalanceException extends Exception {

    private static final long serialVersionUID = 48598860121L;
    private String developerMessage;
    private ErrorCode errorCode;
    private String message;

    public InsufficientLimitBalanceException(String message, String developerMessage, ErrorCode errorCode) {
        super(message);
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
