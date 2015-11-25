package com.pkt.pack1;

import java.io.StringReader;
import java.math.BigDecimal;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

/**
 * Created by pankaj on 26-11-2015.
 */
public class Product {
    private final String productName;
    private final BigDecimal productPrice;
    public Product(String productName,BigDecimal productPrice){
        this.productName=productName;
        this.productPrice=productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        return !(productPrice != null ? !productPrice.equals(product.productPrice) : product.productPrice != null);

    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
