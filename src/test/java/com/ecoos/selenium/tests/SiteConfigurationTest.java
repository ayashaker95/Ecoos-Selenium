package com.ecoos.selenium.tests;

import com.ecoos.selenium.locators.Locators;
import com.ecoos.selenium.pages.SiteConfiguration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SiteConfigurationTest extends BaseTest {

    SiteConfiguration siteConfiguration = new SiteConfiguration(driver);

    @Test
    public void OpenProtocolTabTest(){
        siteConfiguration.OpenProtocolTab();
        Assert.assertTrue(isDisplayed(Locators.AddNewItem));
    }

    @Test
    @Parameters({"ProtocolName"})
    public void CreateProtocolTest(String ProtocolName)throws Exception{
        siteConfiguration.CreateProtocol(ProtocolName);
        siteConfiguration.SortIdDescending();
        By protctolName = By.xpath("//div[@title=\""+ProtocolName+"\"]");
        Assert.assertTrue(isDisplayed(protctolName));
    }

    @Test
    public void OpenQuestionTabTest(){
        siteConfiguration.OpenQuestionTab();
        Assert.assertTrue(isDisplayed(Locators.AddNewItem));
    }
    @Test
    @Parameters({"ProtocolName","QuestionName"})
    public void CreateQuestionTest(String ProtocolName ,String QuestionName)throws Exception{
        siteConfiguration.OpenProtocolTab();
        String ProtocolId = siteConfiguration.CreateProtocol(ProtocolName);
        System.out.println(ProtocolId);
        siteConfiguration.OpenQuestionTab();
        siteConfiguration.CreateQuestion(ProtocolId,QuestionName);
        By questionName = By.xpath("//div[@title=\""+QuestionName+"\"]");
        Assert.assertTrue(isDisplayed(questionName));
    }
    @Test
    @Parameters({"ProtocolId","QuestionName","DataPointID"})
    public void CreateQuestionWithConnectingDPTest(String ProtocolId,String QuestionName,String DataPointID )throws Exception{
        siteConfiguration.OpenQuestionTab();
        siteConfiguration.CreateQuestionWithConnectingDP(ProtocolId,QuestionName,DataPointID);
        By questionName = By.xpath("//div[@title=\""+QuestionName+"\"]");
        Assert.assertTrue(isDisplayed(questionName));
    }
}
