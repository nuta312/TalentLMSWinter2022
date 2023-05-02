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

        Driver.getDriver().get("https://www.google.com/");
        System.out.println("This is example test");
<<<<<<< HEAD
        Assert.assertTrue(true);
=======
        Assert.assertTrue(false);

>>>>>>> origin/AigerimDzh
    }
}
