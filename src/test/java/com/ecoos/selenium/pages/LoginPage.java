package com.ecoos.selenium.pages;

import com.ecoos.selenium.commons.Constants;
import com.ecoos.selenium.locators.Locators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearLoginFields() {
        driver.findElement(Locators.UserName).clear();
        driver.findElement(Locators.Password).clear();
    }

    public void loginToSite(String UserName, String Password) {

        try {
            String URL = getCurrentURL();
            if (URL == Constants.Collect) {
                driver.findElement(Locators.Logout).click();
                sendText(Locators.UserName, UserName);
                sendText(Locators.Password, Password);
                clickElement(Locators.LoginButton);
            }else {
                sendText(Locators.UserName, UserName);
                sendText(Locators.Password, Password);
                clickElement(Locators.LoginButton);
            }
        }catch(Exception e){
                System.out.println("Ex: Login :  " + e.getMessage());
            }
        }
    public void LogoutFromSuite() {
        try {
            clickElement(Locators.Logout);
        } catch (Exception e) {
            System.out.println("Ex: Logout :  " + e.getMessage());
        }
    }
}