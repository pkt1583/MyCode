package com.rules.tax;

import com.domain.product.Product;
import com.domain.salesTax.BasicSalesTax;
import com.domain.salesTax.ImportDutyTax;
import com.domain.salesTax.Tax;
import com.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 29-11-2015.
 */
public class DefaultTaxApplier implements TaxApplier<Product> {

    private TaxableCriteria<Product> taxableCriteria = new DefaultTaxableCriteria();

    @Override
    public List<Tax> getApplicableTaxes(Product product) {
        String productDescString = product.getProductDescriptionString();
        List<Tax> taxes = new ArrayList<>();
        if (productDescString.contains(Constants.IMPORTED)) {
            taxes.add(new ImportDutyTax());
        }
        if (taxableCriteria.isTaxable(product)) {
            taxes.add(new BasicSalesTax());
        }
        return taxes;
    }
}
