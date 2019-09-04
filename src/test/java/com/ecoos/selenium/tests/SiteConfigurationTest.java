package com.ecoos.selenium.tests;

import com.ecoos.selenium.locators.Locators;
import com.ecoos.selenium.pages.SiteConfiguration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SiteConfigurationTest extends BaseTest {

    SiteConfiguration siteConfiguration = new SiteConfiguration(driver);

    @Test
    public void OpenProtocolTabTest(){
        siteConfiguration.OpenProtocolTab();
        Assert.assertTrue(driver.findElement(Locators.AddNewItem).isDisplayed());
    }

    @Test(dataProvider = "ProtocolName")
    public void CreateProtocolTest(String ProtocolName)throws Exception{
        siteConfiguration.CreateProtocol(ProtocolName);
        siteConfiguration.SortIdDescending();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@title=\""+ProtocolName+"\"]")).isDisplayed());

    }
    @Test(dataProvider = "QuestionName")
    public void CreateQuestionTest(String ProtocolName ,String QuestionName)throws Exception{
        String ProtocolId = siteConfiguration.CreateProtocol(ProtocolName);
        siteConfiguration.OpenQuestionTab();
        siteConfiguration.CreateQuestion(ProtocolId,QuestionName);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@title=\""+ProtocolName+"\"]")).isDisplayed());
    }

    @DataProvider(name = "ProtocolName")
    public Object[][] getProtocolNameFromDataProvider(){
        return new Object[][]{
                {"AsalProtocol"}
        };
    }

    @DataProvider(name = "QuestionName")
    public Object[][] getQuestionNameFromDataProvider(){
        return new Object[][]{
                {"AsalProtocol","AsalQuestion"}
        };
    }

}
