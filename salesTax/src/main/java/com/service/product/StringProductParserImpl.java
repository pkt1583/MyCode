package com.service.product;

import com.domain.product.Product;
import com.service.validation.input.ZeroProductValidator;
import com.service.validation.input.ZeroProductCostValidator;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pankaj on 26-11-2015.
 */
//create abstract class for input validation
public class StringProductParserImpl implements ProductParser<String, Product> {


    public Product parse(String productStringToBeParsed) {
        Scanner scanner = new Scanner(productStringToBeParsed);
        int numberOfProducts = scanner.nextInt();
        new ZeroProductValidator().validate(numberOfProducts); //BAD
        StringBuilder productName = new StringBuilder();
        BigDecimal productCost = BigDecimal.ZERO;
        while (scanner.hasNext()) {
            String nextElement = scanner.next();
            if (!"at".equals(nextElement)) {
                productName.append(nextElement);
                productName.append(" ");
            } else {
                productCost = scanner.nextBigDecimal();
            }
        }
        List<ParsingValidation> parsingValidations=getPreValidator(null);
        for(ParsingValidation parsingValidation:parsingValidations){
            parsingValidation.validate(productCost);
        }
        Product product = new Product(productName.toString().trim(), productCost, ProductTypeIdentifier.getProductTypeIdentifier(productName.toString()), productStringToBeParsed);
        product.setProductCount(numberOfProducts);
        return product;
    }

    @Override
    public List<ParsingValidation> getPreValidator(String toBeValidated) {
        List<ParsingValidation> parsingValidations=new LinkedList<>();
        parsingValidations.add(new ZeroProductCostValidator());
        return parsingValidations;
    }

    @Override
    public List<ParsingValidation> getPoseValidator(List<Product> toBeValidated) {
        return null;
    }

}
