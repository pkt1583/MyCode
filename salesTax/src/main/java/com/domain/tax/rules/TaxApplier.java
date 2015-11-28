package com.domain.tax.rules;

import com.domain.salesTax.Tax;

import java.util.List;

/**
 * Created by pankaj on 29-11-2015.
 */
public interface TaxApplier<T> {
    List<Tax> getApplicableTaxes(T productDescString);
}
