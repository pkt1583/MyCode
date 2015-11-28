package com.project.integration;

import com.domain.product.Product;
import com.interfaces.input.file.FileInput;
import com.service.product.ProductParser;
import com.service.product.StringProductParserImpl;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by pankaj on 29-11-2015.
 */
public class IntegrationTest {
    @Test
    public void testIntegration() throws URISyntaxException, IOException {
        FileInput fileInput = new FileInput("classpath:testCase1.txt");
        fileInput.openReader();
        double salesTax=0.0;
        while (fileInput.hasNext()){
            ProductParser<String, List< Product >> productParser=new StringProductParserImpl();
            List<Product> products=productParser.parse(fileInput.next());
            for(Product product:products){
                salesTax=salesTax+product.calculateTax();
                System.out.println("sales tax "+salesTax+" calculated for product "+product);
            }
        }
        fileInput.close();

        System.out.println(salesTax);
    }

    @Test
    public void testIntegration2() throws URISyntaxException, IOException {
        FileInput fileInput = new FileInput("classpath:testCase2.txt");
        fileInput.openReader();
        double salesTax=0.0;
        while (fileInput.hasNext()){
            ProductParser<String, List< Product >> productParser=new StringProductParserImpl();
            List<Product> products=productParser.parse(fileInput.next());
            for(Product product:products){
                salesTax=salesTax+product.calculateTax();
                System.out.println("sales tax "+salesTax+" calculated for product "+product);
            }
        }
        fileInput.close();

        System.out.println(salesTax);
    }
}
