package com.service.product;

import java.util.List;

/**
 * Created by pankaj on 26-11-2015.
 */
public interface ProductParser<T, U> {
    U parse(T productDesc);

    List<ParsingValidation> getPreValidator(T toBeValidated);

    List<ParsingValidation> getPoseValidator(List<U> toBeValidated);
}
