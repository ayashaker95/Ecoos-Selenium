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
                sendText(Locators.UserName, UserName);
                sendText(Locators.Password, Password);
                clickElement(Locators.LoginButton);
            }
        catch(Exception e){
                System.out.println("Ex: Login :  " + e.getMessage());
            }
    }
    public void LogoutFromSuite() {
        try {
            WaitForElement(6000);
            clickElement(Locators.Logout);
        } catch (Exception e) {
            System.out.println("Ex: Logout :  " + e.getMessage());
        }
    }
    public void IsloggedIn(){
        String URL = getCurrentURL();
        if(URL == Constants.Collect)
            LogoutFromSuite();
    }
}