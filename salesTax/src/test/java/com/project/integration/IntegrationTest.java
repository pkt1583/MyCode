package com.project.integration;

import com.domain.product.Product;
import com.interfaces.input.file.FileInput;
import com.interfaces.output.format.ListToStringFormatterWithNewLine;
import com.service.product.ProductParser;
import com.service.product.StringProductParserImpl;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by pankaj on 29-11-2015.
 */
public class IntegrationTest {
    @Test
    public void testIntegration() throws URISyntaxException, IOException {
        FileInput fileInput = new FileInput("classpath:testCase1.txt");
        fileInput.openReader();
        BigDecimal salesTax = BigDecimal.ZERO;
        List<Product> productList=new ArrayList<>();
        while (fileInput.hasNext()){
            ProductParser<String, Product > productParser=new StringProductParserImpl();
            Product product=productParser.parse(fileInput.next());
            productList.add(product);
            salesTax =salesTax.add(product.calculateTax());
        }
        fileInput.close();
        assertEquals(1.50,salesTax.doubleValue());
        ListToStringFormatterWithNewLine listToStringFormatterWithNewLine=new ListToStringFormatterWithNewLine();
        System.out.println(listToStringFormatterWithNewLine.getFormattedContent(productList));
    }


    @Test
    public void testIntegration2() throws URISyntaxException, IOException {
        FileInput fileInput = new FileInput("classpath:testCase2.txt");
        fileInput.openReader();
        BigDecimal salesTax = BigDecimal.ZERO;
        List<Product> productList=new ArrayList<>();
        while (fileInput.hasNext()){
            ProductParser<String, Product > productParser=new StringProductParserImpl();
            Product product=productParser.parse(fileInput.next());
            salesTax =salesTax.add(product.calculateTax());
            productList.add(product);
        }
        fileInput.close();
        assertEquals(7.65,salesTax.doubleValue());
        ListToStringFormatterWithNewLine listToStringFormatterWithNewLine=new ListToStringFormatterWithNewLine();
        System.out.println(listToStringFormatterWithNewLine.getFormattedContent(productList));
    }

    @Test
    public void testIntegration3() throws URISyntaxException, IOException {
        FileInput fileInput = new FileInput("classpath:testCase3.txt");
        fileInput.openReader();
        BigDecimal salesTax = BigDecimal.ZERO;
        List<Product> productList=new ArrayList<>();
        while (fileInput.hasNext()){
            ProductParser<String, Product > productParser=new StringProductParserImpl();
          Product product=productParser.parse(fileInput.next());
            salesTax =salesTax.add(product.calculateTax());
            productList.add(product);
        }
        fileInput.close();
        assertEquals(6.70,salesTax.doubleValue());
        ListToStringFormatterWithNewLine listToStringFormatterWithNewLine=new ListToStringFormatterWithNewLine();
        System.out.println(listToStringFormatterWithNewLine.getFormattedContent(productList));
    }
}
