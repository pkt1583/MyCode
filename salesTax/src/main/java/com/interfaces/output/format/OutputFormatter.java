package com.interfaces.output.format;

/**
 * Created by pankaj on 01-12-2015.
 */
public interface OutputFormatter<T, U> {
    public T getFormattedContent(U content);
}
