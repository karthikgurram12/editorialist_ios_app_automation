package com.editorialist.tests;

import com.editorialist.utils.DriverUtils;
import io.appium.java_client.ios.IOSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    IOSDriver driver;
    Properties config;
    DriverUtils driverUtils=new DriverUtils();
    @BeforeSuite
    public void setup() throws MalformedURLException {
        config = new Properties();
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
