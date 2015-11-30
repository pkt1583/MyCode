package com.service.product;

import com.domain.product.Product;

/**
 * Created by pankaj on 26-11-2015.
 */
public class ProductFactoryImpl implements ProductFactory {
    private ProductParser productParser;

    private ProductFactoryImpl(ProductParser productParser) {
        this.productParser = productParser;
    }

    public static ProductFactory getInstance(Class whichInstance) {
        if (whichInstance.isAssignableFrom(String.class)) {
            ProductFactory productFactory = new ProductFactoryImpl(new StringProductParserImpl());
            return productFactory;
        }
        return new NoOpProductFactory(null);
    }

    public Product getProducts(String description) {
        ProductParser<String, Product> productParser = new StringProductParserImpl();
        return productParser.parse(description);
    }

    private static class NoOpProductFactory implements ProductFactory {

        private NoOpProductFactory(ProductParser productParser) {
            //   super(productParser);
        }

        public Product getProducts(String description) {
            return null;
        }
    }

}
