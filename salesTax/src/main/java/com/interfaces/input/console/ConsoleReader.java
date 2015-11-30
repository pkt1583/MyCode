package com.interfaces.input.console;

import com.interfaces.input.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * TODO: Implement this.
 */
public class ConsoleReader implements InputReader<String, String> {
    @Override
    public void openReader() throws URISyntaxException, IOException {

    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
