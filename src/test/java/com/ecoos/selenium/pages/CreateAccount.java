package com.ecoos.selenium.pages;

import com.ecoos.selenium.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class CreateAccount extends BasePage {

    public CreateAccount(WebDriver driver){
        this.driver = driver;
    }
    public void OpenSiteSetting() {
        try {
            clickElement(Locators.SiteSetting);
            WaitForElementToBeVisible(Locators.ProfileTab,10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void OpenAdminSetting(){
        try{
            clickElement(Locators.AdminSetting);
            WaitForElementToBeVisible(Locators.AccountsTab,10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void OpenAccountTab(){
        try{
            clickElement(Locators.AccountsTab);
            WaitForElementToBeClickable(Locators.AddnewAccountBtn,10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void clickAddNewAccount(){
        try{
            clickElement(Locators.AddnewAccountBtn);
            WaitForElementToBeVisible(Locators.AddNewAccountHerder,10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void CreateAccount(String AccountName, String CompanyName,String Sector ) {
        try {
            WebElement AccountNameEle = driver.findElement(Locators.AccountNameTextField);
            WebElement CompanyNameEle = driver.findElement(Locators.CompanyNameTextFiled);
            Select SectorList = new Select(driver.findElement(Locators.SectorList));
            AccountNameEle.sendKeys(AccountName);
            CompanyNameEle.sendKeys(CompanyName);
            SectorList.selectByVisibleText(Sector);
            ScrollDownUntilElementView(Locators.SubmitButton);
            WebElement Save = driver.findElement(Locators.SubmitButton);
            Save.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void CreateAccount(String AccountName, String CompanyName,String Sector,String Address ,String Zip ){
        try {
            WebElement AccountNameEle = driver.findElement(Locators.AccountNameTextField);
            WebElement CompanyNameEle = driver.findElement(Locators.CompanyNameTextFiled);
            Select SectorList = new Select(driver.findElement(Locators.SectorList));
            WebElement AddressEle = driver.findElement(Locators.AddressTextField);
            AccountNameEle.sendKeys(AccountName);
            CompanyNameEle.sendKeys(CompanyName);
            SectorList.selectByVisibleText(Sector);
            AddressEle.sendKeys(Address);
            ScrollDownUntilElementView(Locators.SubmitButton);
            WebElement ZipEle = driver.findElement(Locators.ZipTextField);
            ZipEle.sendKeys(Zip);
            WebElement Save = driver.findElement(Locators.SubmitButton);
            Save.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void CreateAccount(String Address ,String Zip ){
        try {
            WebElement AddressEle = driver.findElement(Locators.AddressTextField);
            AddressEle.sendKeys(Address);
            ScrollDownUntilElementView(Locators.SubmitButton);
            WebElement ZipEle = driver.findElement(Locators.ZipTextField);
            ZipEle.sendKeys(Zip);
            WebElement Save = driver.findElement(Locators.SubmitButton);
            Save.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SelectCreatedSite(String AccountName, String CompanyName,String Sector,String Address ,String Zip )throws Exception{
        Actions action = new Actions(driver);
        CreateAccount(AccountName, CompanyName,Sector , Address,Zip);
        WebElement element = driver.findElement(Locators.SitesList);
        element.click();
        By path = By.xpath("//li/div[contains(string(),\""+AccountName+"\")]");
        ScrollDownUntilElementView(path);
        WebElement account = driver.findElement(By.xpath("//li/div[contains(string(),\""+AccountName+"\")]"));
        action.doubleClick(account).perform();
        }
}


