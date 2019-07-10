package com.ecoos.selenium.pages;

import org.openqa.selenium.By;
import com.ecoos.selenium.pages.BasePage;
import com.ecoos.selenium.locators.Locators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        this.driver= driver;
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
            Wait(null, 6);

        } catch (Exception e) {
            System.out.println("Ex: Login :  " + e.getMessage());

        }
    }
}