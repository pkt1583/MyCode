package com.service.validation.input;

import com.exception.input.InvalidProductCountException;
import com.service.product.ParsingValidation;
import com.util.Errors;

/**
 * Created by pankaj on 01-12-2015.
 */
public class ZeroProductValidator implements ParsingValidation {
    @Override
    public Errors validate(Object input) {
        if(input==null){
            throw new InvalidProductCountException("Please enter some product count. Null is not valid");
        }else {
            Integer integerInput=(Integer)input;
            if(integerInput<=0){
                throw new InvalidProductCountException("Please enter product count greater than 1");
            }
        }
        return null;
    }
}
