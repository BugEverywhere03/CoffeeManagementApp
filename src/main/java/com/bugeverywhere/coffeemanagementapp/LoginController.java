package com.bugeverywhere.coffeemanagementapp;

import com.bugeverywhere.coffeemanagementapp.model.service.AccountService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private Button loginButton;

    @FXML
    protected void onLoginButtonClick() {
        String useName = usernameField.getText();
        String password = passwordField.getText();
        AccountService  accountService = new AccountService();
        if (accountService.userLogin(useName, password)){
            messageLabel.setText("Login Success");
        }else{
            messageLabel.setText("Login Failed");
        }
    }
}