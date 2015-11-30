package com.domain.product;

import com.domain.salesTax.Tax;
import com.rules.tax.DefaultTaxApplier;
import com.rules.tax.TaxApplier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 26-11-2015.
 */
public class Product implements TaxCalculableProduct {

    private final String productName;
    private final BigDecimal productPrice;
    private int productCount = 1;
    private BigDecimal salesTax = BigDecimal.ZERO;
    private TaxApplier<Product> taxApplier = new DefaultTaxApplier();
    private ProductType productType;
    private List<Tax> taxesApplicableOnProducts = new ArrayList<>();
    private ProductCategory productCategory;
    private String productDescriptionString;

    public Product(String productName, BigDecimal productPrice, ProductType productType, String productDescriptionString) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productDescriptionString = productDescriptionString;
        this.taxesApplicableOnProducts = taxApplier.getApplicableTaxes(this);
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    @Override

    public BigDecimal calculateTax() {
        for (int i = 0; i < getProductCount(); i++) {
            salesTax = salesTax.add(calculateTaxSingle());
        }
        return salesTax;
    }

    private BigDecimal calculateTaxSingle() {
        if (salesTax == BigDecimal.ZERO) {
            BigDecimal taxValue = BigDecimal.ZERO;
            for (Tax tax : taxesApplicableOnProducts) {
                taxValue = taxValue.add(tax.getTaxValue());
            }
            BigDecimal finalTax = (productPrice.multiply(taxValue));
            double finalTaxDoublue = Math.ceil(finalTax.doubleValue() / 0.05) * 0.05;
            this.salesTax = BigDecimal.valueOf(finalTaxDoublue).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return salesTax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!productName.equals(product.productName)) return false;
        if (!productPrice.equals(product.productPrice)) return false;
        return productType == product.productType;

    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        result = 31 * result + productPrice.hashCode();
        result = 31 * result + productType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", final proce = " + productPrice.add(salesTax) +
                '}';
    }

    public ProductType getProductType() {
        return productType;
    }


    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescriptionString() {
        return productDescriptionString;
    }

    public void setProductDescriptionString(String productDescriptionString) {
        this.productDescriptionString = productDescriptionString;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
