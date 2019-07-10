package com.ecoos.selenium.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = "src/test/resources/config.properties";
    private static String url;
    private static String userName;
    private static String password;
    private static String browserName;
    private static String chromedriverPath ;
    private static String geckodriverPath ;

    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
        url = prop.getProperty("url");
        userName = prop.getProperty("username");
        password = prop.getProperty("password");
        browserName = prop.getProperty("browserName");
        chromedriverPath = prop.getProperty("chromedriverPath");
        geckodriverPath = prop.getProperty("geckodriverPath");
    }

    public String getURL() {
        return url;
    }

    public String getChromedriverPath() {
        return chromedriverPath;
    }
    public String getgeckodriverPath() {
        return geckodriverPath;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    public String getBrowserName() {
        return browserName;
    }

}

