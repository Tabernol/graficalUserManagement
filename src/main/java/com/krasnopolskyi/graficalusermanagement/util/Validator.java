package com.krasnopolskyi.graficalusermanagement.util;

import com.krasnopolskyi.graficalusermanagement.exception.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void validatePassword(byte[] bytes) throws ValidationException {
        String password = new String(bytes);
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(password);

        boolean isMatch = matcher.find();
        if (!isMatch) {
            throw new ValidationException("The password must contains a special character.");
        }
        if (password.trim().length() < 8) {
            throw new ValidationException("The password must be longer than 7 characters.");
        }
    }


    public static void validateName(String name) throws ValidationException {
        if (name.trim().length() < 2) {
            throw new ValidationException("The name must consist of at least 2 characters.");
        }
        if (name.trim().length() > 80) {
            throw new ValidationException("The name must less than 80 characters.");
        }
    }

    public static void validateId(Long id) throws ValidationException {
        if (id <= 0) {
            throw new ValidationException("Id must be positive.");
        }
    }
}
