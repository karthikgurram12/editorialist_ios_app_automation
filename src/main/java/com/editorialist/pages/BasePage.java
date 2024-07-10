package com.editorialist.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    protected AppiumDriver driver;

    public BasePage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Method to find element by iOSNsPredicateString
    public WebElement FindElementByIOSNsPredicate(String predicate){
        return driver.findElement(AppiumBy.iOSNsPredicateString(predicate));
    }

    public void selectOptionFromDropDown(WebElement element, String text){
        Select select=new Select(element);
        select.selectByVisibleText(text);
    }
}
