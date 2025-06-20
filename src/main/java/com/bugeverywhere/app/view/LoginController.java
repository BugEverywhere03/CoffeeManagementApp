package com.bugeverywhere.app.view;

import com.bugeverywhere.app.viewmodel.LoginViewModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label messageLabel;

    private LoginViewModel loginViewModel;


    @FXML
    protected void onLoginButtonClick()  {
        if (loginViewModel.loginProcess()){
            Platform.runLater(this::showHomeView);
        }
    }

    private void setUpBindings(){
        usernameField.textProperty().bindBidirectional(loginViewModel.userNameProperty());
        passwordField.textProperty().bindBidirectional(loginViewModel.passwordProperty());
        messageLabel.textProperty().bind(loginViewModel.messageProperty());
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginViewModel = new LoginViewModel();
        setUpBindings();
    }

    private void showHomeView(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/bugeverywhere/app/fxml/home.fxml"));
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
    }
}