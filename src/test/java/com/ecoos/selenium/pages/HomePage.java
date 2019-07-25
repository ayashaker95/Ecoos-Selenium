
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
  public void SelectAssetCheckBox(String asset){
      By xpath = By.xpath("//label[@for='chk" + asset + "']");
      WebElement element = driver.findElement(xpath);
      element.click();
  }
  public String getCheckBoxLevel(WebElement element, String asset){
      element = driver.findElement(By.xpath("//input[@id='chk"+asset+"']"));
      return element.getAttribute("ng-model");
  }
  public String getCheckBoxClassName(WebElement element, String asset){
      element = driver.findElement(By.xpath("//input[@id='chk"+asset+"']"));
       return element.getAttribute("class");
  }
  public String getChildCheckBoxClassName(String asset){
     WebElement element = driver.findElement(Locators.ClassNameForChildAsset);
     return element.getAttribute("class");
  }
    public String getSecondCheckBoxClassName(String asset){
        WebElement element = driver.findElement(Locators.ClassNameFor2ChildAsset);
        return element.getAttribute("class");
    }
  public boolean IsSelected (WebElement element, String assets){
      boolean isSelected;

          switch (getCheckBoxLevel(element, assets).charAt(0)) {
              case 'a':
                  if (getCheckBoxClassName(element, assets).contains("not-ng-empty"))
                  return isSelected = true;
              case 'c':
                  if (getCheckBoxClassName(element, assets).contains("not-ng-empty") && getChildCheckBoxClassName(assets).contains("not-ng-empty")) {
                      return isSelected = true;
                  }
              case 's':
                  if (getCheckBoxClassName(element, assets).contains("not-ng-empty") && getChildCheckBoxClassName(assets).contains("not-ng-empty") && getSecondCheckBoxClassName(assets).contains("ng-not-empty"));
                      return isSelected = true;
      }

      return isSelected=false;
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
    public void ClickApplyButton() throws Exception {
        List<WebElement> AllSelectedCheckBoxes = driver.findElements(By.xpath("//input[contains(@class, 'ng-not-empty')]"));
        clickElement(Locators.ApplyButton);
        WaitForElement(6000);
        if(IsParentCollapsePresent()){
            List<WebElement> ParentCollapse = driver.findElements(By.xpath("//img[@ng-init=\"isParentExpanded = vm.assetExpanded[asset.parent.AssetId];\"]"));
            for (WebElement collapse :ParentCollapse){
               if(collapse.getAttribute("ng-src").contains("collapse"))
                   collapse.click();
            }
        }
        }
    public boolean IsParentCollapsePresent(){
        Boolean isPresent = driver.findElements(By.xpath("//img[@ng-init=\"isParentExpanded = vm.assetExpanded[asset.parent.AssetId];\"]")).size() > 0 ;
        return isPresent;
    }
    public boolean IsChildCollapsePresent(){
        Boolean isPresent = driver.findElements(By.xpath("//img[@ng-init=\"isExpanded = vm.assetExpanded[fLevelAsset.AssetId];\"]")).size() > 0 ;
        return isPresent;
    }
    public boolean IsCollapsed(){
      WebElement element = driver.findElement(By.xpath("//img[@alt='Expand Icon']"));
      if (element.getAttribute("ng-src").contains("collapse")){
          return true;
      }else
          return false;
    }
}