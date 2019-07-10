package com.ecoos.selenium.locators;

import org.openqa.selenium.By;

public class Locators {


    public static By LoginButton  = By.xpath("//button");
    public static By UserName = By.id("Username");
    public static By Password = By.id("Password");
    public static By InvalidMessage = By.xpath("//div[@class='error-message ng-binding']");
    public static By collect = By.xpath("//a[@ui-sref='dashboard.collect']");


}