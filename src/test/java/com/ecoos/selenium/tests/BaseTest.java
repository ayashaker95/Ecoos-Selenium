package com.ecoos.selenium.tests;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.ecoos.selenium.commons.PropertyManager;
import com.ecoos.selenium.pages.LoginPage;
import com.ecoos.selenium.pages.BasePage;
import com.ecoos.selenium.locators.Locators;
import com.ecoos.selenium.commons.Constants;

public class BaseTest extends BasePage{
    public String UserName , Password;

    @BeforeSuite
    public void beforeSuite() {

        try {

            String url = PropertyManager.getInstance().getURL();
            String chromeDriverPath = PropertyManager.getInstance().getChromedriverPath();
            String geckoDriverPath = PropertyManager.getInstance().getgeckodriverPath();
            String BrowserName = PropertyManager.getInstance().getBrowserName();
            System.out.println(BrowserName);
            if (BrowserName.contains("chrome"))  {
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                driver = new ChromeDriver();
            } else if (BrowserName.contentEquals("firefox")) {
                System.setProperty("webdriver.gecko.driver",geckoDriverPath );
                driver = new FirefoxDriver();
            } else {
                System.out.println("Error in the browser name ");
            }
            driver.manage().window().maximize();
            driver.get(url);

        } catch (Exception e) {
            System.out.println("Ex: Base :  " + e.getMessage());

        }
    }

    @BeforeTest
    public void ValidLogin() throws InterruptedException {

        UserName = PropertyManager.getInstance().getUserName();
        Password = PropertyManager.getInstance().getPassword();
        LoginPage login = new LoginPage(driver);
        login.clearLoginFields();
        login.loginToSite("admin@ecoos.co", "ecoos6");
        BasePage.Wait(Locators.collect, 6);
        Assert.assertEquals(login.getCurrentURL(),Constants.Collect);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Test is finished");
        // driver.quit();
    }
}
