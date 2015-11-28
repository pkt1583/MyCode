package com.domain.salesTax;

import java.math.BigDecimal;

/**
 * Created by pankaj on 25-11-2015.
 */
public class ImportDutyTax extends MultipleTax {
    private static final BigDecimal five = new BigDecimal("5");
    public BigDecimal getTaxValue() {
        return five;
    }
}
