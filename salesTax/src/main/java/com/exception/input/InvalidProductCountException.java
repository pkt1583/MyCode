package com.exception.input;

/**
 * Created by pankaj on 01-12-2015.
 */
public class InvalidProductCountException extends RuntimeException {
    public InvalidProductCountException() {
        super();
    }

    public InvalidProductCountException(String message) {
        super(message);
    }

    public InvalidProductCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProductCountException(Throwable cause) {
        super(cause);
    }

    protected InvalidProductCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
