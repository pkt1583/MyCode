package com.rules.tax;

import com.domain.product.Product;
import com.domain.product.ProductCategory;
import com.domain.product.ProductType;

/**
 * Created by pankaj on 29-11-2015.
 */
public class DefaultTaxableCriteria implements TaxableCriteria<Product> {
    @Override
    public boolean isTaxable(Product product) {
        ProductType productProductType = product.getProductType();
        ProductCategory productCategory = product.getProductCategory();
        if ((productProductType == ProductType.BOOKS || productProductType == ProductType.FOOD || productProductType == ProductType.MEDICAL) && productCategory != ProductCategory.IMPORTED) {
            return false;
        }
        return true;
    }
}
