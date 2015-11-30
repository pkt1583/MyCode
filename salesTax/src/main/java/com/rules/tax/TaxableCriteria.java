package com.rules.tax;

/**
 * Created by pankaj on 29-11-2015.
 */
public interface TaxableCriteria<T> {
    boolean isTaxable(T product);
}
