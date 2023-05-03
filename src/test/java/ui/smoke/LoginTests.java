package ui.smoke;

import com.digital.annotations.TestCase;
import com.digital.ui.driver.Driver;
import io.qameta.allure.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseUiTest;

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

        Driver.getDriver().get("https://www.youtube.com/watch?v=Kbj2Zss-5GY&list=RDbxD7BeZE4j8&index=2");
        System.out.println("This is example test");
        Assert.assertTrue(false);

    }
}