package com.interfaces.output.format;

import com.domain.product.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by pankaj on 01-12-2015.
 */
public class ListToStringFormatterWithNewLine implements OutputFormatter<String, List<Product>> {
    @Override
    public String getFormattedContent(List<Product> content) {
        StringBuilder sb = new StringBuilder();
        BigDecimal totalCost = BigDecimal.ZERO;
        BigDecimal totalSalesTax = BigDecimal.ZERO;
        for (Product product : content) {
            sb.append(product.getProductCount()).append(" ").append(product.getProductName()).append(" : ")
                    .append(product.getSalesTax().add(product.getProductPrice())).append(System.getProperty("line.separator"));
            totalCost = totalCost.add(product.getSalesTax().add(product.getProductPrice()));
            totalSalesTax = totalSalesTax.add(product.getSalesTax());
        }
        sb.append("Sales Taxes : ").append(totalSalesTax).append(System.getProperty("line.separator"));
        sb.append("Total : ").append(totalCost);
        return sb.toString();
    }
}
