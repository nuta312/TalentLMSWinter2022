package ui.smoke;

import com.digital.Listeners.ScreenshotListener;
import com.digital.annotations.TestCase;
import com.digital.ui.driver.Driver;
import io.qameta.allure.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.BaseUiTest;
import ui.BaseUiTest;

import java.net.MalformedURLException;


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

        Driver.getDriver().get("https://www.google.com/");
        System.out.println("This is example test");
        Assert.assertTrue(true);


    }
}