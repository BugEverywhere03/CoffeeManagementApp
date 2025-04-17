package com.bugeverywhere.coffeemanagementapp.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {
    private static DatabaseConfig instance = null;
    private static final String URL_PATH = "jdbc:mysql://localhost:3306/coffeedb?user=root&password=123456&trustServerCertificate=true&useSSL=false&&allowPublicKeyRetrieval=true";
    private Connection connection = null;
    private DatabaseConfig() {
        try {
            connection = DriverManager.getConnection(URL_PATH);
            System.out.println("Connected to database");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
}
