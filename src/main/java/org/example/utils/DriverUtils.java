package org.example.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverUtils {
    public IOSDriver driverCreation() throws MalformedURLException {
        // automationName, udid and app bundleId are mandatory
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("appium:automationName","XCUITest");
        cap.setCapability("appium:deviceName","Karthik iPhone");
        cap.setCapability("appium:noReset",true);
        cap.setCapability("appium:platformName","iOS");
        cap.setCapability("appium:platformVersion","17.5");
        cap.setCapability("appium:bundleId","com.ProjectyxLLC.Projectyx.Appstore");
        cap.setCapability("appium:udid","00008030-001A2DEC14D8C02E");

        URL url=new URL("http://127.0.0.1:4723/");

        IOSDriver driver=new IOSDriver(url,cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
