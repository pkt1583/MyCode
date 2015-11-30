package com.service.product;

import com.util.Errors;

/**
 * Created by pankaj on 01-12-2015.
 */
public interface ParsingValidation<T> {
    public Errors validate(T input);
}
