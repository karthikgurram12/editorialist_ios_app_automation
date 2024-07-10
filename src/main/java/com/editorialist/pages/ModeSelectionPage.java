package com.editorialist.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModeSelectionPage extends BasePage {

    @FindBy(id = "Pro-User Mode")
    private WebElement proUserMode;
    @FindBy(id = "Client Mode")
    private WebElement clientMode;
    public ModeSelectionPage(IOSDriver driver) {
        super(driver);
    }

    public void onModeSelectionPage() throws InterruptedException {
        Thread.sleep(5000);
        assert clientMode.isDisplayed();
    }

    public void selectClientMode(){
        clientMode.click();
    }
}
