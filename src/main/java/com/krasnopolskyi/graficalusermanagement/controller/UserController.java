package com.krasnopolskyi.graficalusermanagement.controller;

import com.krasnopolskyi.graficalusermanagement.model.User;
import com.krasnopolskyi.graficalusermanagement.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.SQLException;


public class UserController {

    private UserService userService = new UserService();
    @FXML
    private Label message;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    protected void sendFormToRegister() {
        try {
            String result = userService.save(
                    new User(Long.valueOf(id.getText()), name.getText()), password.getText().getBytes());
            message.setText(result);
        } catch (SQLException e) {
            message.setText("Sorry something went wrong");
        } catch (NumberFormatException e) {
            message.setText("Id should be a number");
        }
    }


}
