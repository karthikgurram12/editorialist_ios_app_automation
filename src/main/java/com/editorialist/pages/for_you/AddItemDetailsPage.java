package com.editorialist.pages.for_you;

import com.editorialist.pages.BasePage;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddItemDetailsPage extends BasePage {

    @FindBy(id = "quickAddItemNameTextView")
    private WebElement itemNameTextField;

    @FindBy(id = "Category")
    private WebElement selectCategory;

    @FindBy(id = "Select Designer")
    private WebElement selectDesigner;

    @FindBy(id = "Select Size")
    private WebElement selectSize;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='APPLY']")
    private WebElement applyButton;

    @FindBy(id = "ADD TO CLOSET")
    private WebElement addToClosetButton;

    public AddItemDetailsPage(IOSDriver driver) {
        super(driver);
    }

    public void enterTextToItemName(String itemName){
        itemNameTextField.isDisplayed();
        itemNameTextField.sendKeys(itemName);
    }

    public void selectCategory(String topLevelCategory, String subCategory){
        // assert selectCategory.isDisplayed();
        selectCategory.click();

        //selecting top level category
        driver.findElement(By.id(topLevelCategory)).click();

        //selecting top level category
        driver.findElement(By.id(subCategory)).click();
    }

    public void selectDesigner(String designerName){
        selectDesigner.click();

        //selecting designer
        //driver.findElement(By.id(designerName)).click();
        //selecting first designer as the page doesn't mapped correctly to options
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='designerClicked'])[1]")).click();
    }

    public void selectSize(String size){
        selectSize.click();

        //selecting designer
        driver.findElement(By.id(size)).click();
        applyButton.click();
    }

    public void clickOnAddToClosestButton(){
        assert addToClosetButton.isDisplayed();
        addToClosetButton.click();
    }
}
