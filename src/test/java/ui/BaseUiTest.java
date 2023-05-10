package ui;


import com.digital.ui.driver.Driver;
import com.digital.ui.driver.DriverActions;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.account_settings.BasicSettingsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.digital.ui.pages.UserPage.FilesPage;
import com.digital.ui.pages.UserPage.PageGroups;
import com.digital.ui.pages.UserPage.UsersOptions;
import com.digital.ui.pages.UserPage.UsersPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract class BaseUiTest implements DriverActions {
    private static Logger logger = LogManager.getLogger(BaseUiTest.class);
    public WebElementActions elementActions;
    public BasicSettingsPage basicSettingsPage;
    public LoginPage loginPage;
    public HomePage homePage;
    public WebDriver driver;
    public FilesPage filesPage;
    public PageGroups pageGroups;
    public UsersOptions usersOptions;
    public UsersPage usersPage;


    @BeforeClass
    public void setUp() {
        driver = Driver.getDriver();
        driver.navigate().to("https://nuta1bema.talentlms.com/account/basic_index");
        driver = Driver.getDriver();
        basicSettingsPage = new BasicSettingsPage();
        elementActions = new WebElementActions();
        loginPage = new LoginPage();
        homePage = new HomePage();
        filesPage = new FilesPage();
        pageGroups = new PageGroups();
        usersOptions = new UsersOptions();
        usersPage = new UsersPage();

    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}

