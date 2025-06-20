package com.bugeverywhere.app.viewmodel;

import com.bugeverywhere.app.model.service.AccountService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {
    private final StringProperty userName = new SimpleStringProperty("");
    private final StringProperty password = new SimpleStringProperty("");
    private final StringProperty message = new SimpleStringProperty("");

    private final AccountService accountService;

    public LoginViewModel() {
        this.accountService = new AccountService();
    }

    public boolean loginProcess(){
        String userNaem = userName.get();
        String pass = password.get();
        boolean isLogin = accountService.userLogin(userNaem, pass);
        if (!isLogin) {
            message.set("Sai tên đăng nhập hoặc mật khẩu");
        }
        return isLogin;
    }
    public StringProperty userNameProperty() {
        return userName;
    }
    public StringProperty passwordProperty() {
        return password;
    }
    public StringProperty messageProperty() {
        return message;
    }
}
