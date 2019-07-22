
package com.ecoos.selenium.pages;

import com.ecoos.selenium.locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ecoos.selenium.commons.Constants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }
    public void OpenCategory(String categoryName) {
        try{
            WaitForElement(6000);
        By xpath = genarateXpath(Constants.Category, categoryName);
        clickElement(xpath);
    }catch (Exception e){
            System.out.println("EX :OpenCategory"+ e.getMessage());
        }
    }
    public void OpenAssetView() {
        try {
            boolean visible = driver.findElement(Locators.SelectAssetBtn).isDisplayed();
            if (visible) {
                clickElement(Locators.SelectAssetBtn);
            } else {
                WebElement AssetToolCollapse = driver.findElement(Locators.collapseExpandAssetview);
                AssetToolCollapse.click();
                clickElement(Locators.SelectAssetBtn);
            }
        } catch (Exception e) {
            System.out.println("Ex: OpenAssetView :  " + e.getMessage());
        }
    }
    public void SelectAssetsFromMenu(String Assets) {
        try {
            System.out.println("Begin");
                By xpath = By.xpath("//label[@for='chk" + Assets + "']");
                WebElement element = driver.findElement(xpath);
                element.click();
                WebElement input = driver.findElement(By.xpath("//input[@id='chk"+Assets+"']"));
                String AssetLevel = input.getAttribute("ng-model");
                String className = input.getAttribute("class");
                System.out.println(AssetLevel);
                switch(AssetLevel.charAt(0)){
                    case 's':
                        Assert.assertTrue(className.contains("ng-not-empty"));
                        System.out.println("SecondChild");
                        break;
                    case 'c':
                        Assert.assertTrue(className.contains("ng-not-empty"));
                        System.out.println("child");
                        break;
                    case 'a':
                        Assert.assertTrue(className.contains("ng-not-empty"));
                        System.out.println("parent");
                        break;
                }
                WaitForElement(500);
                System.out.println("clicked");


        }catch(Exception e){
            System.out.println("Ex:Selectassets" +e.getMessage());
        }
    }
    public int SelectAllAssets(){
        clickElement(Locators.SelectAllAssets);
        WebElement SelectAll = driver.findElement(By.id("chkAll"));
         String checked = SelectAll.getAttribute("checked");
         Assert.assertEquals(checked,"true");
        List <WebElement> elements = driver.findElements(Locators.CheckBoxes);
        for( WebElement element :elements.subList(1,elements.size())){
            String ClassName = element.getAttribute("class");
            System.out.println(ClassName);
            boolean Selected = ClassName.contains("ng-not-empty");
            Assert.assertTrue(Selected);
        }
        return elements.size();
    }
    public void ClickApplyButton()throws Exception{
        clickElement(Locators.ApplyButton);
        WaitForElement(6000);
    }
}


