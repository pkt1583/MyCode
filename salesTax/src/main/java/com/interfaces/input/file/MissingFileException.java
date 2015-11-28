package com.interfaces.input.file;

/**
 * Created by pankaj on 28-11-2015.
 */
public class MissingFileException extends RuntimeException {
    public MissingFileException() {
        super();
    }

    public MissingFileException(String s) {
        super(s);
    }

    public MissingFileException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public MissingFileException(Throwable throwable) {
        super(throwable);
    }

    protected MissingFileException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
