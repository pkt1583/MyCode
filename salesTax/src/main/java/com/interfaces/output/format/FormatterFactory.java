package com.interfaces.output.format;

/**
 * Created by pankaj on 01-12-2015.
 */
public enum FormatterFactory {
    INSTANCE;

    public OutputFormatter getFormatter(String ofWhat) {
        //change to class type instead of String
        if (ofWhat.equals("ListToStringFormatterWithNewLineSeperator")) {
            return new ListToStringFormatterWithNewLine();
        }
        return null;
    }


}
