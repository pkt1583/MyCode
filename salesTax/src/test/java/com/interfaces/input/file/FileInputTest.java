package com.interfaces.input.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pankaj on 29-11-2015.
 */
public class FileInputTest {

    @Test
    public void testOpenReader() {
        try {
            FileInput fileInput = new FileInput("classpath:someInput.txt");
            fileInput.openReader();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            fail("Could not open fileInput");
        }
    }

    @Test
    public void testNext() throws URISyntaxException, IOException {
        List<String> expectedElements=new LinkedList<>();
        expectedElements.add("1 book at 12.49");
        expectedElements.add("1 music CD at 14.99");
        expectedElements.add("1 chocolate bar at 0.85");
        FileInput fileInput = new FileInput("classpath:someInput.txt");
        fileInput.openReader();
        //while (fileInput.hasNext()){
            assertEquals(expectedElements.get(0),fileInput.next());
            assertEquals(expectedElements.get(1),fileInput.next());
            assertEquals(expectedElements.get(2),fileInput.next());
        //}
    }
}