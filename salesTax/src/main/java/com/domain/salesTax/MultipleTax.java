package com.domain.salesTax;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pankaj on 26-11-2015.
 */
public class MultipleTax implements Tax {

    private Set<Tax> taxes = new HashSet<Tax>();

    public BigDecimal getTaxValue() {
        BigDecimal defaultTaxPercetage = BigDecimal.ZERO;
        for (Tax tax : taxes) {
            defaultTaxPercetage.add(tax.getTaxValue());
        }
        return defaultTaxPercetage;
    }

    public boolean addTax(Tax tax) {
        return this.taxes.add(tax);
    }


    public Tax removeTax(Tax tax) {
        if (taxes.remove(tax)) {
            return tax;
        }
        return null;
    }
}
