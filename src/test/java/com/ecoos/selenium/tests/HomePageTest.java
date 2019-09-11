package com.ecoos.selenium.tests;

import com.ecoos.selenium.pages.BasePage;
import com.ecoos.selenium.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    HomePage homePage = new HomePage(driver);

    @Test(dataProvider = "category")
    public void OpenCategoryTest(String category) throws Exception {
        homePage.OpenCategory(category);
        BasePage.WaitForElement(6000);
        WebElement element = driver.findElement(By.xpath("//span[@class='name "+category+"']"));
       String categoryName= element.getAttribute("class");
       Assert.assertEquals(categoryName, "name "+category+"");
    }
    @Test
    public void TestAssetView() throws Exception {
        homePage.OpenAssetView();
        BasePage.WaitForElement(8000);
        Assert.assertTrue(homePage.getCurrentURL().contains("new-select-asset"));
    }
   @Test(dataProvider = "Assets")
    public void SelectAssetsFromMenuTest(String Assets) throws Exception {

        WebElement element = driver.findElement(By.id("chk"+Assets+""));
        BasePage.WaitForElement(5000);
        homePage.SelectAssetCheckBox(Assets);
        homePage.IsSelected(element ,Assets);
        BasePage.WaitForElement(5000);

    }
    @Test
    public void ClickApplyButtonTest()throws Exception{
        homePage.ClickApplyButton();
    }

    /*@Test
    public void SelectAllAssetsTest(){
        homePage.SelectAllAssets();

    }*/
    @DataProvider(name ="Assets")
    public Object[][] getAssetsFromDataProvider(){
        return  new Object[][]{
                { "Western Spent Smoke Stack" }};
    }
    @DataProvider(name = "category")
    public Object [][] getCategoriesFromDataProvider(){
        return new Object[][]{
                {"energy"}
        };
    }
    @DataProvider(name = "ExpectedAssets")
    public Object [][] getExpectedAssetsFromDataProvider(){
        return new Object[][]{
                {"Office"},
                {"Whole site"},
                {"Western Spent Smoke Stack"}
        };
    }
}