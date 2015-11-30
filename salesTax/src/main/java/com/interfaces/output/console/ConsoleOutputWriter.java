package com.interfaces.output.console;


import com.domain.product.Product;
import com.interfaces.output.OutputWriter;
import com.interfaces.output.format.OutputFormatter;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.List;

public class ConsoleOutputWriter implements OutputWriter<String, List<Product>> {

    public void writeToConsole(List<Product> output) {
        String listToStringFormatter = getOutputFormatter("ListToStringFormatterWithNewLineSeperator").getFormattedContent(output);
        BufferedOutputStream br = new BufferedOutputStream(System.out);
        try {
            br.write(listToStringFormatter.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public OutputFormatter<String, List<Product>> getOutputFormatter(String ofWhat) {
        return new OutputFormatter<String, List<Product>>() {
            @Override
            public String getFormattedContent(List<Product> ofWhat) {
                return null;
            }
        };
    }
}
