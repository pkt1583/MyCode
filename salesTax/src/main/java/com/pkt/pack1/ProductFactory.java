package com.pkt.pack1;

import java.util.List;

/**
 * Created by pankaj on 26-11-2015.
 */
public interface ProductFactory {
    List<Product> getProducts(String description);
}
