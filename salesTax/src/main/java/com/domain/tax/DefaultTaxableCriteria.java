package com.domain.tax;

import com.domain.product.Product;
import com.domain.product.ProductType;

/**
 * Created by pankaj on 29-11-2015.
 */
public class DefaultTaxableCriteria implements TaxableCriteria<Product> {
    @Override
    public boolean isTaxable(Product product) {
        ProductType productProductType = product.getProductType();
        if (productProductType == ProductType.BOOKS || productProductType == ProductType.FOOD || productProductType == ProductType.MEDICAL) {
            return false;
        }
        return true;
    }
}
