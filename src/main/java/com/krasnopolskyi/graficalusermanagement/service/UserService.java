package com.krasnopolskyi.graficalusermanagement.service;

import com.krasnopolskyi.graficalusermanagement.exception.ValidationException;
import com.krasnopolskyi.graficalusermanagement.model.User;
import com.krasnopolskyi.graficalusermanagement.repository.UserRepository;
import com.krasnopolskyi.graficalusermanagement.util.Validator;

import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }


    public String save(User user, byte[] bytes) throws SQLException {
        try {
            Validator.validateName(user.getName());
            Validator.validatePassword(bytes);
        } catch (ValidationException e) {
            return e.getMessage();
        }

        if (userRepository.isIdExist(user.getId())) {
            return "User with this ID already exists";
        }
        // there must be a better coder here, but this is just an example
        String encodedPassword = Base64.getEncoder().encodeToString(bytes);
        userRepository.save(user.getId(), user.getName(), encodedPassword);
        return "User has saved successfully.";
    }

    public Optional<User> getRandom() throws SQLException {
        return userRepository.getRandom();
    }

}
