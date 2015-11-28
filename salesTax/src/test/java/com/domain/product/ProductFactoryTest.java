package com.domain.product;

import com.service.product.ProductFactory;
import com.service.product.ProductFactoryImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by pankaj on 26-11-2015.
 */
public class ProductFactoryTest {

    @Test
    public void testGetProducts() throws Exception {
        String parseString = "110 imported bottle of purfume at 27.5";
        ProductFactory stringProductParser = ProductFactoryImpl.getInstance(String.class);
        List<Product> products = stringProductParser.getProducts(parseString);
        assertEquals(110, products.size());
        Product expectedProduct = new Product("imported bottle of purfume", 27.5,ProductType.OTHERS);
        assertEquals(expectedProduct, products.get(0));
    }
}