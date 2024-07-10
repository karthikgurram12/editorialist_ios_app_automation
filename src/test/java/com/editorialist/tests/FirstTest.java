package com.editorialist.tests;

import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.login(userdata.get("username").asText(), userdata.get("password").asText());

        //verify user lands on mode selection page for first time user experience
        modeSelectionPage.onModeSelectionPage();
        //user selects client mode
        modeSelectionPage.selectClientMode();

        //wait for what's new page and validate user tips page is displayed and then click on close icon on top right
        Thread.sleep(5000);
        ftueTipsPage.closeIfUserTipsPageIsAvailable();

    }

    @Test
    public void addItemFromForYouPageTest() throws InterruptedException {
        //verify user lands on homepage and navigate to For You tab
        homePage.onHomePage();
        homePage.navigateToForYouTab();

        //user click on add item
        forYouPage.clickOnAddButton();
        forYouPage.clickOnAddAnItem();
        forYouPage.clickOnAddItemWithPicture();

        //take a picture
        forYouPage.clickOnCameraButton();
        Thread.sleep(5000);

        //fill the add item details
        addItemDetailsPage.enterTextToItemName("item1");
        addItemDetailsPage.selectCategory("Accessories","Belts");
        addItemDetailsPage.selectDesigner("A A K S");
        addItemDetailsPage.selectSize("XXL");
        addItemDetailsPage.clickOnAddToClosestButton();
    }


}
