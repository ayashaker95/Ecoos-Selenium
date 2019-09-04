package com.ecoos.selenium.tests;

import com.ecoos.selenium.commons.Constants;
import com.ecoos.selenium.locators.Locators;
import com.ecoos.selenium.pages.CreateAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest{
    CreateAccount createAccount = new CreateAccount(driver);
    @Test
    public void OpenSiteSettingTest(){
        createAccount.OpenSiteSetting();
        Assert.assertTrue(driver.findElement(Locators.ChangePassword).isDisplayed());
    }

    @Test
    public void OpenAdminSettingTest(){
        createAccount.OpenAdminSetting();
        Assert.assertTrue(driver.findElement(Locators.AccountsTab).isDisplayed());
    }

    @Test
    public void OpenAccountsTabTest(){
        createAccount.OpenAccountTab();
        Assert.assertTrue(driver.findElement(Locators.AddnewAccountBtn).isDisplayed());
    }

    @Test
    public void ClickAddNewAccountTest(){
        createAccount.clickAddNewAccount();
        Assert.assertTrue(driver.findElement(Locators.AddNewAccountHerder).isDisplayed());
    }


   @Test (dataProvider="RequiredFields")
    public void CreateAccountWithRequiredFieldsTest(String AccountName, String CompanyName,String Sector)throws Exception{
        createAccount.CreateAccount(AccountName,CompanyName,Sector);
        Thread.sleep(6000);
       Assert.assertEquals(getCurrentURL(), Constants.AccountsTab);
        By xpath = By.xpath("//tr/td[contains(text(),'"+ AccountName +"')]");
        ScrollDownUntilElementView(xpath);
        Assert.assertTrue(driver.findElements(xpath).size()> 0);
    }

   @Test(dataProvider = "RequiredAndOptionalFields")
    public void CreateAccountWithRequiredAndOptionalFieldsTest(String AccountName, String CompanyName,String Sector,String Address,String Zip)throws Exception{
        createAccount.CreateAccount(AccountName,CompanyName,Sector,Address,Zip);
        Assert.assertEquals(getCurrentURL(),Constants.AccountsTab);
       By xpath = By.xpath("//tr/td[contains(text(),'"+ AccountName +"')]");
       ScrollDownUntilElementView(xpath);
       Assert.assertTrue(driver.findElements(xpath).size()> 0);
    }

    @Test(dataProvider = "OptionalFields")
    public void CreateAccountWithOptionalFieldsTest(String Address,String Zip) {
        createAccount.CreateAccount(Address,Zip);
        WebElement Save = driver.findElement(Locators.SubmitButton);
        String  flag = Save.getAttribute("disabled");
        System.out.println(flag);
        Assert.assertEquals(flag,"true");
    }

    @Test(dataProvider = "RequiredAndOptionalFields")
    public void SelectCreatedSiteTest(String AccountName, String CompanyName,String Sector,String Address,String Zip) throws Exception {
        createAccount.SelectCreatedSite(AccountName,CompanyName,Sector,Address,Zip);
        Assert.assertEquals(driver.findElement(Locators.SelectedSite).getText(),AccountName);

    }

    @DataProvider(name = "RequiredFields")
    public Object [][] getAccountInfoFromDataProvider(){
        return new Object[][]{
                { "Test", "Asal" ,"Financial Services"},
        };
    }
    @DataProvider(name = "RequiredAndOptionalFields")
    public Object [][] getAccountInfoFromDataProviderRequiredOptional(){
        return new Object[][]{
                { "Automated Account", "Asal","Financial Services","Jerusalem","00972"},
        };
    }
    @DataProvider(name = "OptionalFields")
    public Object [][] getAccountInfoFromDataProviderOptional(){
        return new Object[][]{
                {"Jerusalem","00972"},
        };
    }
}
