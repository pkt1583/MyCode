package com.service.product;

import com.domain.product.ProductType;

/**
 * Created by pankaj on 29-11-2015.
 */
public class ProductTypeIdentifier {
    public static ProductType getProductTypeIdentifier(String productDescInputString) {
        if (productDescInputString.contains("book")) {
            return ProductType.BOOKS;
        } else if (productDescInputString.contains("food") || productDescInputString.contains("chocolate")) {
            return ProductType.FOOD;
        } else if (productDescInputString.contains("medical") || productDescInputString.contains("pills")) {
            return ProductType.MEDICAL;
        } else {
            return ProductType.OTHERS;
        }
    }
}
