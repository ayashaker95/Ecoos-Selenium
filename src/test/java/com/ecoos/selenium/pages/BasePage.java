package com.ecoos.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;




public class BasePage {

    public static WebDriver driver;

    public BasePage() {
        this.driver = driver;
    }

    public static void clickElement(By Path)throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Path)));
        driver.findElement(Path).click();
        Thread.sleep(6000);
    }

    public static void sendText(By Path, String dataInput) {
        driver.findElement(Path).sendKeys(dataInput);
    }

    public static void WaitForElement( int TimeOut) throws Exception {
       Thread.sleep( TimeOut);
    }
    public static void WaitForElementToBeClickable(By path, int TimeOut){
        try{
        WebDriverWait wait = new WebDriverWait(driver,TimeOut);
        wait.until((ExpectedConditions.elementToBeClickable(path)));
    }catch (Exception e){
            System.out.println("Ex:WaitForElementToBeClickable"+e.getMessage());
        }
    }
    public static void WaitForElementToBeVisible(By path, int TimeOut){
        try{
            WebDriverWait wait = new WebDriverWait(driver,TimeOut);
            wait.until((ExpectedConditions.visibilityOfElementLocated(path)));
        }catch (Exception e){
            System.out.println("Ex:WaitForElementToBeVisible"+e.getMessage());
        }
    }


    public void clearElementText(By Path) {

        driver.findElement(Path).clear();
    }

    public String getCurrentURL() {
        String URL = driver.getCurrentUrl();
        return URL;
    }

    public static String getElementText(By path) {

        return driver.findElement(path).getText();
    }
    public By generateXpath(String Xpath,String inputData) {

        return By.xpath(Xpath+ inputData + "')]");
    }
    public void ScrollDownUntilElementView(By path) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(path);
        js.executeScript("arguments[0].scrollIntoView();", Element);

    }
    public static void ScrollDownByPixel(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Scroll");
        js.executeScript("window.scrollBy(0,50000)", "");

    }
    public List<WebElement> getListOfElement( By locatorItem) throws InterruptedException {

        List<WebElement> options = driver.findElements(locatorItem);

        return options ;
    }
    public boolean isDisplayed(By path){
        if ( driver.findElement(path).isDisplayed()){
            return true;
        }else
            return false;
    }
    public boolean ElementisExist(By path){
        if( driver.findElements(path).size()> 0) {
            return true;
        }else
            return false;
    }
    public String GetText(By path){
         return driver.findElement(path).getText();
    }


}

