package com.bugeverywhere.app.model.service;

import com.bugeverywhere.app.model.repository.IAccount;
import com.bugeverywhere.app.model.repository.impl.EmployeeRepositoryImpl;

public class AccountService {
    private final IAccount employeeRepository = new EmployeeRepositoryImpl();

    public boolean userLogin(String userName, String password) {
        return employeeRepository.checkLogin(userName, password);
    }
}
