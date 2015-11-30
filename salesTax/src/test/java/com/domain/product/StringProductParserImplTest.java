package com.domain.product;

import com.exception.input.NegativeInputException;
import com.service.product.StringProductParserImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by pankaj on 26-11-2015.
 */
public class StringProductParserImplTest {

    @Test
    public void testParse() throws Exception {
        String parseString = "110 imported bottle of purfume at 27.5";
        StringProductParserImpl stringProductParser = new StringProductParserImpl();
        Product products = stringProductParser.parse(parseString);
        assertEquals(110, products.getProductCount());
        Product expectedProduct = new Product("imported bottle of purfume", new BigDecimal("27.5"), ProductType.OTHERS,parseString);
        assertEquals(expectedProduct, products);

        parseString="1 book at 12.49";
        products=stringProductParser.parse(parseString);
        assertEquals(1, products.getProductCount());
        expectedProduct = new Product("book", new BigDecimal("12.49"), ProductType.BOOKS,parseString);
        assertEquals(expectedProduct, products);
    }

    @Test
    public void testNegativeInput(){
      String  parseString="1 book at -12.49";
        StringProductParserImpl stringProductParser = new StringProductParserImpl();
        try {
            Product products = stringProductParser.parse(parseString);
        }catch(NegativeInputException nee){
            return;
        }
        fail("Shoudl have failed with negative input exception");
    }


}