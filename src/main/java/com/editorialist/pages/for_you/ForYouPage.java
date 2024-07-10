package com.editorialist.pages.for_you;

import com.editorialist.pages.BasePage;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForYouPage extends BasePage {

    @FindBy(id = "Add")
    private WebElement addButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Add An Item']")
    private WebElement addAnItem;

    @FindBy(id = "icon-pictureAction")
    private WebElement addItemWithPicture;

    @FindBy(id = "camera shutter")
    private WebElement cameraButton;

    public ForYouPage(IOSDriver driver) {
        super(driver);
    }

    public void clickOnAddButton(){
        assert addButton.isDisplayed();
        addButton.click();
    }

    public void clickOnAddAnItem(){
        assert addAnItem.isDisplayed();
        addAnItem.click();
    }

    public void clickOnAddItemWithPicture(){
        assert addItemWithPicture.isDisplayed();
        addItemWithPicture.click();
    }

    public void clickOnCameraButton(){
        assert cameraButton.isDisplayed();
        cameraButton.click();
    }
}
