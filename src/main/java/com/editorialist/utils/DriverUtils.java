package com.editorialist.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverUtils {
    public IOSDriver driverCreation(Properties config) throws MalformedURLException {
        // automationName, udid and app bundleId are mandatory
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("appium:automationName","XCUITest");
        cap.setCapability("appium:deviceName",config.getProperty("device.name"));
        cap.setCapability("appium:noReset",true);
        cap.setCapability("appium:platformName",config.getProperty("platform.name"));
        cap.setCapability("appium:platformVersion",config.getProperty("platform.version"));
        cap.setCapability("appium:bundleId",config.getProperty("bundle.id"));
        cap.setCapability("appium:udid",config.getProperty("device_udid"));

        URL url=new URL("http://127.0.0.1:4723/");

        IOSDriver driver=new IOSDriver(url,cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
