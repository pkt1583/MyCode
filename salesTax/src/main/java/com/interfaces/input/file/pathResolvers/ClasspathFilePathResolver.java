package com.interfaces.input.file.pathResolvers;

import com.exception.input.file.IncorrectFilePathException;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by pankaj on 29-11-2015.
 */
public class ClasspathFilePathResolver implements PathResolver<Path, String> {


    @Override
    public Path getCompletePath(String filePath) throws URISyntaxException {
        String remainingPath = filePath.substring(10);
        if (remainingPath.startsWith("/")) {
            throw new IncorrectFilePathException("Classpath should not have / after :. The input path is " + filePath);
        }
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource(remainingPath);
        if (url != null) {
            return Paths.get(url.toURI());
        } else {
            throw new IncorrectFilePathException("File not found at " + filePath);
        }
    }
}
