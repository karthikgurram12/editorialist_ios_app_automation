package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "loginUsername")
    private WebElement usernameField;

    @iOSXCUITFindBy(accessibility = "passwordTextField")
    private WebElement passwordField;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }
}
