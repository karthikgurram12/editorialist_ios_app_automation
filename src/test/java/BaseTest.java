import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utils.DriverUtils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

public class BaseTest {

    IOSDriver driver;
    Properties config;
    DriverUtils driverUtils=new DriverUtils();
    @BeforeSuite
    public void setup() throws MalformedURLException {
        config = new Properties();
        try(InputStream inputStream = getClass().getClassLoader().
                getResourceAsStream("properties//config.properties")){
            if(inputStream == null){
                System.out.println("Sorry, unable to find config.properties file");
                return;
            }
            config.load(inputStream);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        driver=driverUtils.driverCreation();
    }

    @AfterSuite
    public void teardown(){
        if(driver!=null) {
            driver.quit();
        }
        System.out.println("session terminated");
    }
}
