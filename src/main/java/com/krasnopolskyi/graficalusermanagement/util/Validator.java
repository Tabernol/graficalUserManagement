package com.krasnopolskyi.graficalusermanagement.util;

import com.krasnopolskyi.graficalusermanagement.exception.ValidationException;
import com.krasnopolskyi.graficalusermanagement.model.User;

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
            throw new ValidationException("The name must be at least 2 characters.");
        }
    }


}
