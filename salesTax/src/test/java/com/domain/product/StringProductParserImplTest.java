package com.domain.product;

import com.service.product.StringProductParserImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by pankaj on 26-11-2015.
 */
public class StringProductParserImplTest {

    @Test
    public void testParse() throws Exception {
        String parseString = "110 imported bottle of purfume at 27.5";
        StringProductParserImpl stringProductParser = new StringProductParserImpl();
        List<Product> products = stringProductParser.parse(parseString);
        assertEquals(110, products.size());
        Product expectedProduct = new Product("imported bottle of purfume", 27.5,ProductType.OTHERS);
        assertEquals(expectedProduct, products.get(0));

        parseString="1 book at 12.49";
        products=stringProductParser.parse(parseString);
        assertEquals(1, products.size());
        expectedProduct = new Product("book", 12.49,ProductType.BOOKS);
        assertEquals(expectedProduct, products.get(0));
    }


}