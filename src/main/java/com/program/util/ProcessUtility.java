package com.program.util;

import org.springframework.stereotype.Component;

@Component
public class ProcessUtility {

    // Regular expression for alpha numeric characters
    private static final String ALPHA_NUMERIC_REGEX = "[^a-zA-Z0-9]+";
    private static final String SPACE = " ";

    /**
     * Remove special characters from input data
     * 
     * @param input
     * @return
     */
    public String removeSpecialChars(String input) {
        if (input != null) {
            input = input.replaceAll(ALPHA_NUMERIC_REGEX, SPACE);
        }
        return input;
    }

}
