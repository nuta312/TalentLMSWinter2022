package ui.smoke;

import com.digital.annotations.TestCase;
import com.digital.ui.driver.Driver;
import io.qameta.allure.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseUiTest;

import java.util.List;

@Epic("Login")
@Feature("Login functionality")
public class LoginTests extends BaseUiTest {


    @Test(description = "Verify user can login with valid credentials")
    @TestCase(id = 123)
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Nursultan")
    @Story("As a user i should be able to login")
    @Link(name = "requirements",url = "https://www.google.com/")
    public void loginWithValidCredentialsTest() {

        Driver.getDriver().get("https://demoqa.com/webtables");
        WebElement e = Driver.getDriver().findElement(By.id("addNewRecordButton"));
        List<WebElement> names = Driver.getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div/div/div[1]"));
        for(WebElement b : names) {
            System.out.println(b.getText());
        }

    }
}





//import org.openqa.selenium.*;
//        import org.openqa.selenium.remote.DesiredCapabilities;
//        import java.net.MalformedURLException;
//        import java.net.URL;
//        import org.openqa.selenium.remote.RemoteWebDriver;
//        import org.testng.Assert;
//        import org.testng.annotations.*;
//
//public class Grid_2 {
//    WebDriver driver;
//    String baseUrl, nodeURL;
//    @BeforeTest
//    public void setUpWthrows MalformedURLException {
//        baseUrl = "http://newtours.demoaut.com/";
//        nodeURL = "http://192.168.1.4:5566/wd/hub";
//        DesiredCapabilities capability = DesiredCapabilities.firefox();
//        capability. setBrowserName("firefox");
//        capability. setPlatform(Platform.XP);
//        driver = new RemoteWebDriver(new URL(nodeURL), capability);
//    }
//    @AfterTest
//    public void afterTest() {
//        driver.quit();
//    }
//    @Test
//    public void simpleTest() {
//        driver.get(baseUr1);
//        Assert.assertEquas("Welcome: Mercury Tours", driver.getTitle()); }
//}