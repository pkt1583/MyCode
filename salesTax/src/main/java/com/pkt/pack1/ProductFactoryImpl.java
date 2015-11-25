package com.pkt.pack1;

import java.util.Collections;
import java.util.List;

/**
 * Created by pankaj on 26-11-2015.
 */
public class ProductFactoryImpl implements ProductFactory {
    private  ProductParser productParser;

    private ProductFactoryImpl(ProductParser productParser){
        this.productParser=productParser;
    }

    public static ProductFactory getInstance(Class whichInstance){
        if(whichInstance.isAssignableFrom(String.class)){
            ProductFactory productFactory=new ProductFactoryImpl(new StringProductParserImpl());
            return productFactory;
        }
        return new NoOpProductFactory(null);
    }

    private static class NoOpProductFactory implements ProductFactory {

        private NoOpProductFactory(ProductParser productParser) {
         //   super(productParser);
        }

        public List<Product> getProducts(String description) {
            return Collections.emptyList();
        }
    }
    public List<Product> getProducts(String description){
        ProductParser<String,List<Product>> productParser=new StringProductParserImpl();
        return productParser.parse(description);
    }

}
