package com.editorialist.tests;

import com.editorialist.pages.LoginPage;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

    @Test
    public void loginTest(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(config.getProperty("email"), config.getProperty("password"));
    }
}
