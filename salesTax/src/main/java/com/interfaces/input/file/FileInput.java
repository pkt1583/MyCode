package com.interfaces.input.file;

import com.interfaces.input.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

/**
 * Created by pankaj on 28-11-2015.
 */
public class FileInput implements InputReader<String, String> {

    private String currentLine = null;

    private BufferedReader reader = null;

    private String inputPath;

    private Path path;
    private boolean alreadyNext;

    public FileInput(String inputPath) throws URISyntaxException {
        this.inputPath = inputPath;
        path = PathResolverFactory.INSTANCE.getPathResolver(inputPath).getCompletePath(inputPath);
    }

    @Override
    public void openReader() throws URISyntaxException, IOException {

        if (path != null && Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            reader = Files.newBufferedReader(path);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("File is missing at ");
            sb.append(path);
            throw new MissingFileException(sb.toString());
        }
    }

    /*@Override
    public List<String> readInput(String inputSourceFilePath) throws URISyntaxException {
        List<String> valuesRead=new LinkedList<>();

        return null;
    }*/

    @Override
    public void close() throws IOException {
        currentLine = null;
        reader.close();
        reader = null;
    }

    @Override
    public boolean hasNext() {
        try {
            if (!alreadyNext)
                currentLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            //throw custom application exception
        }
        if (currentLine != null && currentLine.length() != 0) {
            alreadyNext = true;
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        if (hasNext()) {
            alreadyNext = false;
            return currentLine;
        } else {
            throw new RuntimeException("Already exhausted reading entire file. Please remember to check for hasNext before calling next");
        }
    }
}
