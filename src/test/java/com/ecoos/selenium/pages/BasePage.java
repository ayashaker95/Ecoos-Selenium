package com.ecoos.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver driver;

    public BasePage() {
        this.driver = driver;
    }

    public void clickElement(By Path) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Path)));
        driver.findElement(Path).click();
    }

    public void sendText(By Path, String dataInput) {
        driver.findElement(Path).sendKeys(dataInput);
    }

    public static void Wait(By Path, int TimeOut) {
        WebDriverWait wait = new WebDriverWait(driver, TimeOut);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Path)));
    }

    public void clearElementText(By Path) {
        driver.findElement(Path).clear();
    }

    public String getCurrentURL() {
        String URL = driver.getCurrentUrl();
        return URL;
    }

    public String getElementText(By path) {
        return driver.findElement(path).getText();
    }

}

