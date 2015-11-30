package com.domain.salesTax;

import java.math.BigDecimal;

public class BasicSalesTax implements Tax {

    private static final BigDecimal Ten = BigDecimal.TEN;


    public BigDecimal getTaxValue() {
        return Ten.divide(BigDecimal.valueOf(100));
    }
}
