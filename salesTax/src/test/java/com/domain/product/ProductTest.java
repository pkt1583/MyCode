package com.domain.product;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;


/**
 * Created by pankaj on 26-11-2015.
 */
public class ProductTest {

    @Test
    public void testCalculateTaxForBook() throws Exception {
        Product product = new Product("book", new BigDecimal("12.49"), ProductType.BOOKS,"1  Book at 12.49");
        product.setProductCount(1);
        assertEquals(0.0,product.calculateTax().doubleValue());
    }


    @Test
    public void testCalculateTaxForOther(){
        Product product = new Product("music CD", new BigDecimal("14.99"), ProductType.OTHERS,"1 music CD at 14.99");
        assertEquals(1.5,product.calculateTax().doubleValue());
        product.setProductCount(1);
    }
}