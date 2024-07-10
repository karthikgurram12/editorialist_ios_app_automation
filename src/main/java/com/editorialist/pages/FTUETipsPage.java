package com.editorialist.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FTUETipsPage extends BasePage{
    @FindBy(id = "TipsViewController")
    private List<WebElement> userTipsController;

    @FindBy(id = "close icon")
    private WebElement closeIcon;

    public FTUETipsPage(IOSDriver driver) {
        super(driver);
    }

//    public List<WebElement> isUserTipsPageVisible(){
//        return driver.findElements(By.id("TipsViewController"));
//    }

    public void closeIfUserTipsPageIsAvailable(){
        if(userTipsController.size()>0)
            closeIcon.click();
    }
}
