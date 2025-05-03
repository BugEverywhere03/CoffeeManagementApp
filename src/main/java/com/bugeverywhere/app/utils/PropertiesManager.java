package com.bugeverywhere.app.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    private static Properties databaseProperties = new Properties();
    private static final String DATABASE_PROPERTIES_FILE_PATH = "/com/bugeverywhere/app/config/database.properties";

    static {
        loadDatabaseProperties();
    }
    public static void loadDatabaseProperties(){
        try (InputStream inputStream = PropertiesManager.class.getResourceAsStream(DATABASE_PROPERTIES_FILE_PATH)){
            databaseProperties.load(inputStream);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        return databaseProperties.getProperty(key);
    }

}
