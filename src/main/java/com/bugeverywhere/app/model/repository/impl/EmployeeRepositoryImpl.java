package com.bugeverywhere.app.model.repository.impl;

import com.bugeverywhere.app.utils.DatabaseConnection;
import com.bugeverywhere.app.model.entity.Employee;
import com.bugeverywhere.app.model.repository.IAccount;
import com.bugeverywhere.app.model.repository.ICommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements ICommon<Employee>, IAccount {
    private final DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
    @Override
    public List<Employee> findAll(){
        List<Employee> lst = new ArrayList<>();
        Connection connection = databaseConnection.getConnection();
        String query = "SELECT pk_id, ten_nhan_vien FROM Employee";
        try (PreparedStatement cmd = connection.prepareStatement(query)){
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                int employeeID = rs.getInt(1);
                String employeeName = rs.getString(2);
                lst.add(new Employee(employeeID, employeeName, null, null));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        Connection connection = databaseConnection.getConnection();
        String query = "SELECT pk_id from nhan_vien where user_name LIKE ? and password like ? LIMIT 1";
        try (PreparedStatement cmd = connection.prepareStatement(query)){
            cmd.setString(1, userName);
            cmd.setString(2, password);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                return true;
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return false;
    }
}
