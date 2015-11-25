package com.pkt.pack1;

import java.math.BigDecimal;

/**
 * Created by pankaj on 25-11-2015.
 */
public class BasicSalesTax implements Tax {

    private static final BigDecimal Ten=BigDecimal.TEN;


    public BigDecimal getTaxValue() {
        return Ten;
    }
}
