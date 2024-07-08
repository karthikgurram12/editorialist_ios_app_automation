package com.editorialist.tests;

import com.editorialist.utils.DriverUtils;
import com.editorialist.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import io.appium.java_client.ios.IOSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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
    }

    @AfterSuite
    public void teardown(){
        if(driver!=null) {
            driver.quit();
        }
        logger.info("session terminated");
    }
}
