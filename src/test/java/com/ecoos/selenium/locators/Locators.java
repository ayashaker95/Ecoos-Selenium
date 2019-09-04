package com.ecoos.selenium.locators;

import org.openqa.selenium.By;

public class Locators {


    public static By LoginButton  = By.xpath("//button");
    public static By UserName = By.id("Username");
    public static By Password = By.id("Password");
    public static By InvalidMessage = By.xpath("//div[@class='error-message ng-binding']");
    public static By collect = By.xpath("//a[@ui-sref='dashboard.collect']");
    public static By Logout = By.xpath("//div[5]/a/img");
    public static By category = By.xpath("//div[@class='collect-categories']/div[contains(@class,'collect-category ");
    public static By SelectAssetBtn = By.xpath("//button[@href='/new-select-asset/3']");
    public static By collapseExpandAssetview = By.xpath("//i[@ng-click='assetToolsCollapse = !assetToolsCollapse']");
    public static By SelectAllAssets = By.xpath("//label[@for='chkAll']");
    public static By ApplyButton = By.id("BtnSaveBottom");
    public static  By CheckBoxes = By.xpath("//input[@type='checkbox']");
    public static By ClassNameForChildAsset = By.xpath("//div[@ng-repeat=\"childAsset in asset.parent.firstLevelChildren\"]//parent::div/div/span/input");
    public static By ClassNameFor2ChildAsset = By.xpath("//div[@ng-repeat=\"secondChild in childAsset.children\"]/parent::div/div/span/input");
    public static By SetParameters = By.xpath("//img[@title=\"Set Parameters\"]");
    public static  By CalcInput = By.xpath("//input[@name='input']");
    public static By ContinueBtn = By.xpath("//button[contains(text(),'Continue')]");
    public static By totalValue = By.xpath("//div/input[@readonly='readonly']");
    public static By SiteSetting = By.xpath("//a[contains(text(),'ECO-OS Admin')]");
    public static By ProfileTab = By.xpath("//a[contains(text(),'Profile')]");
    public static By AdminSetting = By.xpath("//li[6]/a[contains(text(),'Admin')]");
    public static By AccountsTab = By.xpath("//li[1]/a[contains(text(),'Accounts')]");
    public static By AddnewAccountBtn = By.xpath("//a[@title=\"Add new site\"]");
    public static By AddNewAccountHerder = By.xpath("//h1[contains(text(),'Add New Account')]");
    public static By ChangePassword = By.xpath("//a[contains(text(),'Change Password')]");
    public static By ProtocolTab = By.xpath("//a[contains(text(),'Protocols')]");
    public static By AddNewItem = By.xpath("//button[@ng-click=\"vm.addRow()\"]");
    public static By AccountNameTextField = By.xpath("//input[@placeholder=\"Account Name\"]");
    public static By CompanyNameTextFiled = By.xpath("//input[@placeholder=\"Company Name\"]");
    public static By SectorList = By.xpath("//select[@ng-model=\"vm.account.sectorId\"]");
    public static By AddressTextField = By.xpath("//input[@placeholder=\"Enter Address\"]");
    public static By SubmitButton = By.xpath("//button[@type=\"submit\"]");
    public static By ZipTextField = By.xpath("//input[@placeholder=\"Zip code\"]");
    public static By SitesList = By.xpath("//a[@href=\"/dashboard/sites\"]");
    public static By SelectedSite = By.xpath("//a[@href=\"/dashboard/sites\"]/p[1]");
    public static By QuestionsTab = By.xpath("//a[contains(text(),'Questions')]");
    public static By SaveButton = By.xpath("//button[@ng-click=\"vm.save()\"]");

}