package com.bugeverywhere.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private Connection connection = null;
    private static final String URL_PATH = PropertiesManager.getPropertyValue("db.url");
    private static final String USER_NAME = PropertiesManager.getPropertyValue("db.username");
    private static final String PASSWORD= PropertiesManager.getPropertyValue("db.password");
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL_PATH, USER_NAME, PASSWORD);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
}
