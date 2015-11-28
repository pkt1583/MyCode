package com.interfaces.input;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

/**
 * Created by pankaj on 28-11-2015.
 */
public interface InputReader<T, U> extends Iterator<U> {

    // U readInput(T inputSourceStream) throws URISyntaxException;
    void openReader() throws URISyntaxException, IOException;

    void close() throws IOException;
}
