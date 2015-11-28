package com.domain.product;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created by pankaj on 26-11-2015.
 */
public class ProductTest {

    @Test
    public void testCalculateTaxForBook() throws Exception {
        Product product=new Product("book", 12.49,ProductType.BOOKS);
        assertEquals(0.0,product.calculateTax());
    }


    @Test
    public void testCalculateTaxForOther(){
        Product product=new Product("music CD", 14.99,ProductType.OTHERS);
        assertEquals(1.5,product.calculateTax());
    }
}