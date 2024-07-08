package com.editorialist.tests;

import com.editorialist.pages.LoginPage;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
    private LoginPage loginPage;

    @Test
    public void loginTest(){
        loginPage=new LoginPage(driver);
        loginPage.login(userdata.get("username").asText(), userdata.get("password").asText());
    }
}
