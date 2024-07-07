import org.example.pages.LoginPage;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{

    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("karthik","passwrod");
        //driver.findElement(MobileBy.ACCESSIBILITY_ID)
    }


}
