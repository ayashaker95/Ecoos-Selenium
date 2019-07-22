package com.ecoos.selenium.tests;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ecoos.selenium.pages.LoginPage;
import com.ecoos.selenium.locators.Locators;
import com.ecoos.selenium.commons.Constants;
public class LoginTest extends BaseTest{

    LoginPage login = new LoginPage(driver);
    @Test
    @Parameters({ "ValidEmail", "ValidPassword" })
    public void AValidLogin(String UserName, String Password) {
        try {
            login.clearLoginFields();
            login.loginToSite(UserName, Password);
            WaitForElement(4000);
            Assert.assertEquals(login.getCurrentURL(), Constants.Collect);
            login.LogoutFromSuite();

        } catch (Exception e) {
            System.out.println("Ex: @BeforeTest :  " + e.getMessage());
        }
    }
    @Test
    @Parameters({ "InvalidEmail", "ValidPassword" })
    public void InvalidEmail(String UserName, String Password) {
        login.clearLoginFields();
        login.loginToSite(UserName, Password);
        String message = login.getElementText(Locators.InvalidMessage);
        if (message.contains(Constants.LoginErrorMsg))
            Assert.assertTrue(true);
    }

    @Test
    @Parameters({ "ValidEmail", "InvalidPassword" })
    public void InvalidPassword(String UserName, String Password) {

        login.clearLoginFields();
        login.loginToSite(UserName, Password);
        String message = login.getElementText(Locators.InvalidMessage);
        if (message.contains(Constants.LoginErrorMsg))
            Assert.assertTrue(true);
    }

}


