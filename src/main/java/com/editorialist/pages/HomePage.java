package com.editorialist.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id = "Search")
    private WebElement searchButton;
    @FindBy(id = "HOME")
    private WebElement homePageIdentifier;

    @FindBy(id = "FOR YOU")
    private WebElement forYouFooterButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='SKIP']")
    private List<WebElement> skipButton;

    public HomePage(IOSDriver driver) {
        super(driver);
    }

    public void onHomePage() throws InterruptedException {
        assert homePageIdentifier.isDisplayed();
    }

    public void skipSuggestions(){
        if(skipButton.size()>0){
            skipButton.get(0).click();
        }
    }


    public void navigateToForYouTab(){
        // skip the suggestions if displayed
        // skipSuggestions();
        assert forYouFooterButton.isDisplayed();
        forYouFooterButton.click();
    }
}
