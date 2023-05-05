package ui.smoke;

import com.digital.Listeners.ScreenshotListener;
import com.digital.annotations.TestCase;
import com.digital.ui.driver.Driver;
import io.qameta.allure.*;

<<<<<<< HEAD
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
=======
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
>>>>>>> master
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.BaseUiTest;

<<<<<<< HEAD
import java.util.List;

@Epic("Login")
@Feature("Login functionality")
=======
import java.net.MalformedURLException;


>>>>>>> master
public class LoginTests extends BaseUiTest {

    ScreenshotListener screenshotListener = new ScreenshotListener();

    @Test(description = "Verify user can login with valid credentials")
    @TestCase(id = 123)
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Nursultan")
    @Story("As a user i should be able to login")
    @Link(name = "requirements",url = "https://www.google.com/")
    @Step("Проверка теста")
    public void loginWithValidCredentialsTest() throws MalformedURLException {

<<<<<<< HEAD
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
=======
        Driver.getDriver().get("https://www.youtube.com/watch?v=Kbj2Zss-5GY&list=RDbxD7BeZE4j8&index=2");
        System.out.println("This is example test");

        Assert.assertTrue(false);

    }
}
>>>>>>> master
