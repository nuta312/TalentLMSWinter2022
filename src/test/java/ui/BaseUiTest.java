package ui;

import com.digital.Listeners.ScreenshotListener;
import com.digital.ui.driver.Driver;
import com.digital.ui.driver.DriverActions;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.account_settings.BasicSettingsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)

public abstract class BaseUiTest implements DriverActions {
   public WebElementActions elementActions;
   public BasicSettingsPage basicSettingsPage;
    public LoginPage loginPage;
    public HomePage homePage;


    public WebDriver driver;
    @BeforeClass
    public void goToBasicSettingsPage() {
        elementActions = new WebElementActions();
        basicSettingsPage = new BasicSettingsPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        driver = Driver.getDriver();
        loginPage.openPage()
                .authorization();
        homePage.goToHomePage()
                .clickToAccountSettings();

    }


    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
