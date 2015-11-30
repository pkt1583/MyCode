package com.interfaces.input;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by pankaj on 30-11-2015.
 */
public class console implements InputReader<String,String> {
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
}
