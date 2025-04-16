package com.bugeverywhere.coffeemanagementapp.model.repository.impl;

import com.bugeverywhere.coffeemanagementapp.config.DatabaseConfig;
import com.bugeverywhere.coffeemanagementapp.model.entity.Employee;
import com.bugeverywhere.coffeemanagementapp.model.repository.IAccount;
import com.bugeverywhere.coffeemanagementapp.model.repository.ICommon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements ICommon<Employee>, IAccount {
    private DatabaseConfig databaseConfig = DatabaseConfig.getInstance();
    @Override
    public List<Employee> findAll(){
        List<Employee> lst = new ArrayList<>();
        Connection connetion = databaseConfig.getConnection();
        String query = "SELECT EmployeeID, EmployeeName FROM Employee";
        try (PreparedStatement cmd = connetion.prepareStatement(query)){
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                int employeeID = rs.getInt(1);
                String employeeName = rs.getString(2);
                lst.add(new Employee(employeeID, employeeName, null, null, null));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }

    @Override
    public boolean save(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        return false;
    }

    @Override
    public boolean checkLogin(String userName, String password) {
        boolean isExists = false;
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT userName from Employee where userName = ? and password = ? LIMIT 1";
        try (PreparedStatement cmd = connection.prepareStatement(query)){
            cmd.setString(1, userName);
            cmd.setString(2, password);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                isExists = true;
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return isExists;
    }
}
