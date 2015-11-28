package com.service.product;

/**
 * Created by pankaj on 26-11-2015.
 */
public interface ProductParser<T, U> {
    U parse(T productDesc);
}
