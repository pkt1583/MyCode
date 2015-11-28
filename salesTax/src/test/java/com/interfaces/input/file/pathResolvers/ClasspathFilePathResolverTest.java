package com.interfaces.input.file.pathResolvers;

import com.interfaces.input.file.IncorrectFilePathException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pankaj on 29-11-2015.
 */
public class ClasspathFilePathResolverTest {

    @Test
    public void testGetCompletePathException() throws Exception {
        String filePath="classpath:/someinput.txt";
        ClasspathFilePathResolver classpathFilePathResolver=new ClasspathFilePathResolver();
        try {
            System.out.println(classpathFilePathResolver.getCompletePath(filePath));
        }catch (IncorrectFilePathException e){
            return;
        }
        fail();
    }

    @Test
    public void testGetCompletePath() throws Exception {
        String filePath="classpath:someinput.txt";
        ClasspathFilePathResolver classpathFilePathResolver=new ClasspathFilePathResolver();
        assertNotNull(classpathFilePathResolver.getCompletePath(filePath)); //fix this
    }
}