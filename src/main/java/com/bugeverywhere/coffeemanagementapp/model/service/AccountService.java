package com.bugeverywhere.coffeemanagementapp.model.service;

import com.bugeverywhere.coffeemanagementapp.model.repository.IAccount;
import com.bugeverywhere.coffeemanagementapp.model.repository.impl.EmployeeRepositoryImpl;

public class AccountService {
    private final IAccount employeeRepository = new EmployeeRepositoryImpl();

    public boolean userLogin(String userName, String password) {
        return employeeRepository.checkLogin(userName, password);
    }
}
