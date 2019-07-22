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

}