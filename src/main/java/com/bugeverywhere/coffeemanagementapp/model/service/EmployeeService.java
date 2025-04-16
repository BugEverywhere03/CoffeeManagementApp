package com.bugeverywhere.coffeemanagementapp.model.service;

import com.bugeverywhere.coffeemanagementapp.model.entity.Employee;
import com.bugeverywhere.coffeemanagementapp.model.repository.ICommon;
import com.bugeverywhere.coffeemanagementapp.model.repository.impl.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeService {
    private ICommon<Employee> employeeRepository = new EmployeeRepositoryImpl();

    public boolean updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public boolean deleteEmployee(Employee employee) {
        return employeeRepository.delete(employee);
    }
    public boolean insertEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> getList(){
        return employeeRepository.findAll();
    }
}
