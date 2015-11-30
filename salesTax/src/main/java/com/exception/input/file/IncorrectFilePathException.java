package com.exception.input.file;

/**
 * Created by pankaj on 29-11-2015.
 */
public class IncorrectFilePathException extends RuntimeException {
    public IncorrectFilePathException() {
        super();
    }

    public IncorrectFilePathException(String s) {
        super(s);
    }

    public IncorrectFilePathException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public IncorrectFilePathException(Throwable throwable) {
        super(throwable);
    }

    protected IncorrectFilePathException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
