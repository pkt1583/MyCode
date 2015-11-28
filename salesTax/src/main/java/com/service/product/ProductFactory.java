package com.service.product;

import com.domain.product.Product;

import java.util.List;

/**
 * Created by pankaj on 26-11-2015.
 */
public interface ProductFactory {
    List<Product> getProducts(String description);
}
