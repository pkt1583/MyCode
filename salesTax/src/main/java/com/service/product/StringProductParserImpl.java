package com.service.product;

import com.domain.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pankaj on 26-11-2015.
 */
public class StringProductParserImpl implements ProductParser<String, List<Product>> {
    public List<Product> parse(String productStringToBeParsed) {
        List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(productStringToBeParsed);
        int numberOfProducts = scanner.nextInt();
        StringBuilder productName = new StringBuilder();
        double productCost = 0;
        while (scanner.hasNext()) {
            String nextElement = scanner.next();
            if (!"at".equals(nextElement)) {
                productName.append(nextElement);
                productName.append(" ");
            } else {
                productCost = scanner.nextDouble();
            }
        }
        for (int i = 0; i < numberOfProducts; i++) {
            Product product = new Product(productName.toString().trim(), productCost, ProductTypeIdentifier.getProductTypeIdentifier(productName.toString()));
            products.add(product);
        }
        return products;
    }
}
