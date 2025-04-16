package com.bugeverywhere.coffeemanagementapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int employeeID;
    private String employeeName;
    private String userName;
    private String password;
    private List<Role> employeeRoles;
}
