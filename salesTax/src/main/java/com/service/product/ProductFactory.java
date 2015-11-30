package com.service.product;

import com.domain.product.Product;

/**
 * Created by pankaj on 26-11-2015.
 */
public interface ProductFactory {
    Product getProducts(String description);
}
