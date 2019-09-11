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
            WebElement Id = driver.findElement(By.id("id"));
            String ProtocolId = Id.getAttribute("value");
            WebElement fullName = driver.findElement(Locators.protocolFullName);
            fullName.sendKeys(FullName);
            WebElement Save = driver.findElement(Locators.SaveButton);
            Save.click();
            return ProtocolId;
    }

    public void OpenQuestionTab(){
        try {
            clickElement(Locators.QuestionsTab);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void CreateQuestion(String ProtocolId ,String QuestionName )throws Exception{
        clickElement(Locators.AddNewItem);
        WebElement protocolId = driver.findElement(Locators.protocolId);
        for(int i=0;i<ProtocolId.length();i++){
            WebElement protocolId3 = driver.findElement(Locators.protocolId);
            protocolId.sendKeys(ProtocolId.charAt(i)+ "");
            protocolId3.click();
        }
        WebElement QName = driver.findElement(By.id("text"));
        QName.sendKeys(QuestionName);
        ScrollDownUntilElementView(Locators.SaveButton);
        clickElement(Locators.SaveButton);
    }

    public void CreateQuestionWithConnectingDP(String ProtocolId ,String QuestionName,String datapointID)throws Exception{
        clickElement(Locators.AddNewItem);
        WebElement protocolId = driver.findElement(Locators.protocolId);
        protocolId.sendKeys(ProtocolId);
        WebElement QName = driver.findElement(Locators.QuestionName);
        QName.sendKeys(QuestionName);
        clickElement(Locators.DataPointTab);
        WebElement searchForDP = driver.findElement(Locators.SearchForDP);
        searchForDP.sendKeys(datapointID+"");
        WaitForElementToBeClickable(Locators.DataPointDropDown,20);
        WebElement selectedDatapoint = driver.findElement(By.xpath("//div[@class=\"ui-select-choices-row ng-scope active\"]/span/small/span[./text()='"+datapointID+"']"));
        selectedDatapoint.click();
            clickElement(Locators.SaveButton);
        }
    public void SortIdDescending (){
        try {
            Actions actions = new Actions(driver);
            WebElement element = driver.findElement(Locators.IdCell);
            actions.doubleClick(element).perform();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
