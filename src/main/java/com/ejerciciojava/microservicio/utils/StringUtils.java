package com.ejerciciojava.microservicio.utils;

import java.util.Locale;

public class StringUtils {
    public static String convertToUpperCase(String lowercase) {
        return lowercase.toUpperCase(Locale.ROOT);
    }
}
