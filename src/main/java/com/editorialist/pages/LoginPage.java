package com.editorialist.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    //accessibility id in ios can be found by id with IOSDriver
    @FindBy(id = "loginUsername")
    private WebElement usernameField;

    @FindBy(id = "passwordTextField")
    private WebElement passwordField;

    @FindBy(name = "SIGN IN")
    private WebElement signInButton;

    //image scroll element
    private final WebElement scrollView = FindElementByIOSNsPredicate("type == 'XCUIElementTypeScrollView'");

    public LoginPage(IOSDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        assert scrollView.isDisplayed();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
