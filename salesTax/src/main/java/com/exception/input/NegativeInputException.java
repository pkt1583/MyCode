package com.exception.input;

/**
 * Created by pankaj on 01-12-2015.
 */
public class NegativeInputException extends RuntimeException {
    public NegativeInputException(String s) {
    super(s);
    }

    public NegativeInputException() {
        super();
    }

    public NegativeInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeInputException(Throwable cause) {
        super(cause);
    }

    protected NegativeInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
