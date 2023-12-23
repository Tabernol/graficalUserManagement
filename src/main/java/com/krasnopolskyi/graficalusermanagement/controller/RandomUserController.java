package com.krasnopolskyi.graficalusermanagement.controller;

import com.krasnopolskyi.graficalusermanagement.model.User;
import com.krasnopolskyi.graficalusermanagement.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class RandomUserController {
    private UserService userService = new UserService();
    @FXML
    private Label showUser;

    @FXML
    protected void showRandomUser() {
        try {
            if(userService.getRandom().isPresent()){
                showUser.setText(userService.getRandom().get().toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}