package com.editorialist.tests;

import com.editorialist.pages.FTUETipsPage;
import com.editorialist.pages.HomePage;
import com.editorialist.pages.LoginPage;
import com.editorialist.pages.ModeSelectionPage;
import com.editorialist.pages.for_you.AddItemDetailsPage;
import com.editorialist.pages.for_you.ForYouPage;
import com.editorialist.utils.DriverUtils;
import com.editorialist.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import io.appium.java_client.ios.IOSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    IOSDriver driver;
    Properties config;
    protected JsonNode userdata;
    protected JsonNode testdata;
    DriverUtils driverUtils=new DriverUtils();

    @BeforeSuite
    public void setup() throws IOException {
        config = new Properties();

        //reading config values from config.properties
        try(InputStream inputStream = getClass().getClassLoader().
                getResourceAsStream("properties//config.properties")){
            if(inputStream == null){
                logger.info("Sorry, unable to find config.properties file");
                return;
            }
            config.load(inputStream);
        }catch (IOException ex){
            ex.printStackTrace();
        }

        //loading required login credentials to JsonNode
        userdata=JsonUtils.getHighLevelKey("src//test//resources//test_accounts.json",
                config.getProperty("test_account"));

        //test data
        testdata = userdata.get("test_data");

        // IOSDriver Creation
        driver=driverUtils.driverCreation(config);

        // Initialize Page Object Initialization
        setupPages();

    }

    @AfterSuite
    public void teardown(){
        if(driver!=null) {
            driver.quit();
        }
        logger.info("session terminated");
    }

    // Page Object Classes
    protected LoginPage loginPage;
    protected ModeSelectionPage modeSelectionPage;
    protected FTUETipsPage ftueTipsPage;

    protected HomePage homePage;

    protected ForYouPage forYouPage;

    protected AddItemDetailsPage addItemDetailsPage;

    public void setupPages(){
        loginPage = new LoginPage(driver);
        modeSelectionPage = new ModeSelectionPage(driver);
        ftueTipsPage = new FTUETipsPage(driver);
        homePage = new HomePage(driver);
        forYouPage = new ForYouPage(driver);
        addItemDetailsPage = new AddItemDetailsPage(driver);
    }
}
