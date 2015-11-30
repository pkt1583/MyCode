package com.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pankaj on 01-12-2015.
 */
//TODO: complete this later
public class Errors {
    private Map<String, String> moreErrors = new HashMap<>();

    public boolean hasErrorMessages() {
        return moreErrors.size() > 0;
    }

    public Map<String, String> getAllErrorMessages() {
        return moreErrors;//should be immutable. But le tit be fo rnow
    }

}
