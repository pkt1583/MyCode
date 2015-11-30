package com.service.validation.input;

import com.exception.input.NegativeInputException;
import com.service.product.ParsingValidation;
import com.util.Errors;

import java.math.BigDecimal;

/**
 * Created by pankaj on 01-12-2015.
 */
public class ZeroProductCostValidator implements ParsingValidation {
    public ZeroProductCostValidator() {
    }

    @Override
    public Errors validate(Object input) {
        if (input == null) {
            throw new NullPointerException("Product cost is entered as null");
        } else {
            BigDecimal productCost = (BigDecimal) input;
            if (productCost.intValue() < 0) {
                throw new NegativeInputException("Please enter product cost greater than 0. The entered value is " + input);
            }
        }
        return null; //OK for now. Implement later
    }
}
