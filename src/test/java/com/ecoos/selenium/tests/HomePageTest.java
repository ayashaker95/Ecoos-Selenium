package com.ecoos.selenium.tests;

import com.ecoos.selenium.commons.Constants;
import com.ecoos.selenium.locators.Locators;
import com.ecoos.selenium.pages.BasePage;
import com.ecoos.selenium.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    HomePage homePage = new HomePage(driver);

    @Test(dataProvider = "Categories")
    public void OpenCategoryTest(String Categories) throws Exception {
        homePage.OpenCategory(Categories);
        BasePage.WaitForElement(6000);
        WebElement element = driver.findElement(By.xpath("//span[@class='name "+Categories+"']"));
       String categoryName= element.getAttribute("class");
       Assert.assertEquals(categoryName, "name "+Categories+"");
    }

    @Test
    public void TestAssetView() throws Exception {
        homePage.OpenAssetView();
        BasePage.WaitForElement(8000);
        Assert.assertTrue(homePage.getCurrentURL().contains("new-select-asset"), Constants.SelectAssetsUrl);
    }
   @Test(dataProvider = "Assets")
    public void SelectAssetsFromMen(String Assets) throws Exception {
        BasePage.WaitForElement(5000);
        homePage.SelectAssetsFromMenu(Assets);
        BasePage.WaitForElement(5000);
    }
    @Test
    public void SelectAllAssetsTest(){
        homePage.SelectAllAssets();

    }
    @Test
    public void ClickApplyButtonTest()throws Exception{
        homePage.ClickApplyButton();

    }
    @DataProvider(name ="Assets")
    public Object[][] getAssetsFromDataprovider(){
        return  new Object[][]{
                {"Office"},
                {"Whole site"},
                { "Main Stack - 54" },
                { "Western Spent Smoke Stack" }};
    }
    @DataProvider(name = "Categories")
    public Object [][] getCategoriesFromDataProvider(){
        return new Object[][]{
                {"energy"}
        };
    }
}

