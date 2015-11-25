package com.pkt.pack1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pankaj on 26-11-2015.
 */
public class StringProductParserImpl implements ProductParser<String, List<Product>> {
    public List<Product> parse(String productStringToBeParsed) {
        List<Product> products=new ArrayList<Product>();
        Scanner scanner=new Scanner(productStringToBeParsed);
       int numberOfProducts=scanner.nextInt();
        StringBuilder productName=new StringBuilder();
        BigDecimal productCost=null;
        while(scanner.hasNext()){
            String nextElement=scanner.next();
            if(!"at".equals(nextElement)){
                productName.append(nextElement);
                productName.append(" ");
            }else {
                productCost=scanner.nextBigDecimal();
            }
        }
        for(int i=0;i<numberOfProducts;i++) {
            Product product = new Product(productName.toString().trim(), productCost);
            products.add(product);
        }
        return products;
    }
}
