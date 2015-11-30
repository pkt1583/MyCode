package com.domain.salesTax;

import java.math.BigDecimal;

public class ImportDutyTax extends MultipleTax {
    private static final BigDecimal five = new BigDecimal("5");

    public BigDecimal getTaxValue() {
        return five.divide(BigDecimal.valueOf(100));
    }
}
