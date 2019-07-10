package com.ecoos.selenium.tests;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ecoos.selenium.pages.LoginPage;
import com.ecoos.selenium.pages.BasePage;
import com.ecoos.selenium.locators.Locators;
import com.ecoos.selenium.commons.Constants;
public class LoginTest extends BaseTest{
    @Test
    @Parameters({ "UserName", "Password" })
    public void InvalidEmail(String UserName, String Password) {

        LoginPage login = new LoginPage(driver);
        login.clearLoginFields();
        login.loginToSite(UserName, Password);
        String message = login.getElementText(Locators.InvalidMessage);
        if (message.contains(Constants.LoginErrorMsg))
            Assert.assertTrue(true);
    }

    @Test
    @Parameters({ "UserName", "Password" })
    public void InvalidPassword(String UserName, String Password) {

        LoginPage login = new LoginPage(driver);
        login.clearLoginFields();
        login.loginToSite(UserName, Password);
        String message = login.getElementText(Locators.InvalidMessage);
        if (message.contains(Constants.LoginErrorMsg))
            Assert.assertTrue(true);
    }

    @Test
    @Parameters({ "UserName", "Password" })
    public void ValidLogin() {
        LoginPage login = new LoginPage(driver);
        login.clearLoginFields();
        login.loginToSite(UserName, Password);
        BasePage.Wait(Locators.collect,6);
        Assert.assertEquals(login.getCurrentURL(), Constants.Collect);

    }

}
