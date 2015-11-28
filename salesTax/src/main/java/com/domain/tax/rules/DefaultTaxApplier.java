package com.domain.tax.rules;

import com.domain.salesTax.BasicSalesTax;
import com.domain.salesTax.ImportDutyTax;
import com.domain.salesTax.Tax;
import com.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 29-11-2015.
 */
public class DefaultTaxApplier implements TaxApplier<String> {

    @Override
    public List<Tax> getApplicableTaxes(String productDescString) {
        List<Tax> taxes=new ArrayList<>();
        if(productDescString.contains(Constants.IMPORTED)){
            taxes.add(new BasicSalesTax());
            taxes.add(new ImportDutyTax());
        }else{
            taxes.add(new BasicSalesTax());
        }
        return taxes;
    }
}
