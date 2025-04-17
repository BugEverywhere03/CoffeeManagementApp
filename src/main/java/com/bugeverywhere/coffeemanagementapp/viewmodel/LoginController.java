package com.bugeverywhere.coffeemanagementapp.viewmodel;

import com.bugeverywhere.coffeemanagementapp.model.service.AccountService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label messageLabel;


    @FXML
    protected void onLoginButtonClick()  {
        String useName = usernameField.getText();
        String password = passwordField.getText();
        AccountService  accountService = new AccountService();
        if (accountService.userLogin(useName, password)){
           try {
               FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/bugeverywhere/coffeemanagementapp/home.fxml"));
               Scene scene = usernameField.getScene();
               Parent parent = fxmlLoader.load();
               scene.setRoot(parent);
               Stage stage = (Stage) scene.getWindow();
               stage.setScene(scene);
               stage.setTitle("Home");
               stage.setResizable(false);
               stage.setMaximized(true);
               stage.show();
           }catch (IOException e){
               e.printStackTrace();
           }
        }else{
            messageLabel.setText("Đăng nhập thất bại");
        }
    }
}