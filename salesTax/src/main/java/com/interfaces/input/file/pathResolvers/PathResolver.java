package com.interfaces.input.file.pathResolvers;

import java.net.URISyntaxException;

/**
 * Created by pankaj on 28-11-2015.
 */
public interface PathResolver<Path, String> {
    Path getCompletePath(String pathInString) throws URISyntaxException;
}
