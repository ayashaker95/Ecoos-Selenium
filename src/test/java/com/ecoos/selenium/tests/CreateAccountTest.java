package com.ecoos.selenium.tests;

import com.ecoos.selenium.commons.Constants;
import com.ecoos.selenium.locators.Locators;
import com.ecoos.selenium.pages.CreateAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest{
    CreateAccount createAccount = new CreateAccount(driver);
    @Test
    public void OpenSiteSettingTest(){
        createAccount.OpenSiteSetting();
        Assert.assertTrue(isDisplayed(Locators.ChangePassword));
    }
    @Test
    public void OpenAdminSettingTest(){
        createAccount.OpenAdminSetting();
        Assert.assertTrue(isDisplayed(Locators.AccountsTab));
    }
    @Test
    public void OpenAccountsTabTest(){
        createAccount.OpenAccountTab();
        Assert.assertTrue(isDisplayed(Locators.AddnewAccountBtn));
    }
    @Test
    public void ClickAddNewAccountTest(){
        createAccount.clickAddNewAccount();
        Assert.assertTrue(isDisplayed(Locators.AddNewAccountHerder));
    }


   @Test
   @Parameters({"AccountName","CompanyName","Sector"})
    public void CreateAccountWithRequiredFieldsTest(String AccountName, String CompanyName,String Sector)throws Exception{
        createAccount.CreateAccount(AccountName,CompanyName,Sector);
        By accountName = By.xpath("//tr/td[contains(text(),'"+ AccountName +"')]");
        ScrollDownUntilElementView(accountName);
        Assert.assertTrue(ElementisExist(accountName));
    }

   @Test
   @Parameters({"AccountName","CompanyName","Sector","Address","Zip"})
    public void CreateAccountWithRequiredAndOptionalFieldsTest(String AccountName, String CompanyName,String Sector,String Address,String Zip)throws Exception{
        createAccount.CreateAccount(AccountName,CompanyName,Sector,Address,Zip);
       By accountName = By.xpath("//tr/td[contains(text(),'"+ AccountName +"')]");
       ScrollDownUntilElementView(accountName);
       Assert.assertTrue(ElementisExist(accountName));
    }

    @Test
    @Parameters({"Address","Zip"})
    public void CreateAccountWithOptionalFieldsTest(String Address,String Zip) {
        createAccount.CreateAccount(Address,Zip);
        WebElement Save = driver.findElement(Locators.SubmitButton);
        String  flag = Save.getAttribute("disabled");
        System.out.println(flag);
        Assert.assertEquals(flag,"true");
    }

    @Test
    @Parameters({"AccountName","CompanyName","Sector","Address","Zip"})
    public void SelectCreatedSiteTest(String AccountName, String CompanyName,String Sector,String Address,String Zip) throws Exception {
        createAccount.SelectCreatedSite(AccountName,CompanyName,Sector,Address,Zip);
        Assert.assertEquals(GetText(Locators.SelectedSite),AccountName);

    }


}
