package com.pkt.pack1;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pankaj on 26-11-2015.
 */
public class StringProductParserImplTest {

    @Test
    public void testParse() throws Exception {
        String parseString="110 imported bottle of purfume at 27.5";
        StringProductParserImpl stringProductParser=new StringProductParserImpl();
        List<Product> products= stringProductParser.parse(parseString);
        assertEquals(110,products.size());
        Product expectedProduct=new Product("imported bottle of purfume",new BigDecimal(27.5));
        assertEquals(expectedProduct,products.get(0));
    }
}