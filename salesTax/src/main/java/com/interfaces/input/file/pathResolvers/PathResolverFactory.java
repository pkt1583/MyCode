package com.interfaces.input.file.pathResolvers;

import com.exception.input.file.IncorrectFilePathException;

import java.net.URISyntaxException;
import java.nio.file.Path;

/**
 * Created by pankaj on 28-11-2015.
 */
public enum PathResolverFactory {
    INSTANCE;

    public PathResolver<Path, String> getPathResolver(String filePath) throws URISyntaxException {
        if (filePath.startsWith("classpath:")) {
            return new ClasspathFilePathResolver();
        }
        throw new IncorrectFilePathException("Please ensure that file path is either of classpath:<path> format or full absolute path");
    }
}
