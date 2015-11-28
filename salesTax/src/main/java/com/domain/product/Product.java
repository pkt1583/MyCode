package com.domain.product;

import com.domain.salesTax.Tax;
import com.domain.tax.DefaultTaxableCriteria;
import com.domain.tax.TaxableCriteria;
import com.domain.tax.rules.DefaultTaxApplier;
import com.domain.tax.rules.TaxApplier;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 26-11-2015.
 */
public class Product {

    private final String productName;
    private final double productPrice;
    private TaxableCriteria taxableCriteria = new DefaultTaxableCriteria();
    //Maybe Strategy
    private TaxApplier<String> taxApplier=new DefaultTaxApplier();
    private ProductType productType;
    private List<Tax> taxesApplicableOnProducts = new ArrayList<>();

    public Product(String productName, double productPrice, ProductType productType) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.taxesApplicableOnProducts=taxApplier.getApplicableTaxes(productName);
    }

    public void setTaxableCriteria(TaxableCriteria taxableCriteria) {
        this.taxableCriteria = taxableCriteria;
    }

    public double calculateTax() {
        double taxValue = 0;
        for (Tax tax : taxesApplicableOnProducts) {
            if (taxableCriteria.isTaxable(this)) {
                taxValue = taxValue + tax.getTaxValue().doubleValue();
            }
        }
        double finalTax=(productPrice * taxValue) / 100;
        DecimalFormat decimalFormat= (DecimalFormat) DecimalFormat.getInstance();
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        decimalFormat.applyPattern("#.##");
        //return Double.valueOf(decimalFormat.format(finalTax));
        return Math.round(finalTax*20.0)/20.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.productPrice, productPrice) != 0) return false;
        return !(productName != null ? !productName.equals(product.productName) : product.productName != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productName != null ? productName.hashCode() : 0;
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    public ProductType getProductType() {
        return productType;
    }
}
