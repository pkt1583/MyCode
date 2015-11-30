package com.interfaces.output;


import com.interfaces.output.format.OutputFormatter;

public interface OutputWriter<T, U> {
    public OutputFormatter<T, U> getOutputFormatter(T ofWhats);
}
