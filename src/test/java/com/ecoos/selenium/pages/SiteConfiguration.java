package com.ecoos.selenium.pages;

import com.ecoos.selenium.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SiteConfiguration extends BasePage {

    public SiteConfiguration(WebDriver driver){

        this.driver = driver ;
    }
    public void OpenProtocolTab(){
        try{
        clickElement(Locators.ProtocolTab);
       }catch (Exception E){
        E.printStackTrace();
        }
    }

    public String CreateProtocol(String FullName)throws Exception {

            WebElement element = driver.findElement(Locators.AddNewItem);
            element.click();
            Thread.sleep(500);
            WebElement Id = driver.findElement(By.id("id"));
            String ProtcolId = Id.getAttribute("value");
            WebElement fullName = driver.findElement(By.name("fullName"));
            fullName.sendKeys(FullName);
            WebElement Save = driver.findElement(Locators.SaveButton);
            Save.click();
            return ProtcolId;
    }

    public void OpenQuestionTab(){
        try {
            clickElement(Locators.QuestionsTab);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void CreateQuestion(String ProtocolId ,String QuestionName )throws Exception{
        Thread.sleep(6000);
        WebElement element = driver.findElement(Locators.AddNewItem);
        element.click();
        WebElement protocolId = driver.findElement(By.id("protocol"));
        protocolId.sendKeys(ProtocolId);
        WebElement QName = driver.findElement(By.id("text"));
        QName.sendKeys(QuestionName);
        ScrollDownUntilElementView(Locators.SaveButton);
        clickElement(Locators.SaveButton);
    }

    public void SortIdDescending (){
        try {
            Thread.sleep(600);
            Actions actions = new Actions(driver);
            WebElement element = driver.findElement(Locators.IdCell);
            actions.doubleClick(element).perform();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

