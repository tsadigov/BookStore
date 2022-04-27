package com.tsadigov.ingress.utils;

import java.util.regex.Pattern;

import static com.tsadigov.ingress.bootstrap.Constants.EMAIL_PATTERN;

public class Validator {

    public static boolean isValidEmailFormat(String email) {
        return Pattern.compile(EMAIL_PATTERN)
                .matcher(email)
                .matches();
    }
}
