package ui;
import com.digital.Listeners.ScreenshotListener;
import com.digital.ui.driver.Driver;
import com.digital.ui.driver.DriverActions;
<<<<<<< HEAD
import com.digital.ui.element_helper.WebElementActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
=======
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.UserPage.FilesPage;
import com.digital.ui.pages.UserPage.PageGroups;
import com.digital.ui.pages.UserPage.UsersOptions;
import com.digital.ui.pages.UserPage.UsersPage;
>>>>>>> master
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

<<<<<<< HEAD
@Listeners(ScreenshotListener.class)
public abstract class BaseUiTest  {

    public WebDriver driver;
    private static Logger logger = LogManager.getLogger(BaseUiTest.class);
=======

public abstract class BaseUiTest implements DriverActions {

    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public FilesPage filesPage;
    public PageGroups pageGroups;
    public UsersOptions usersOptions;
    public UsersPage usersPage;

>>>>>>> master

    @BeforeClass
    public void setUp() {
        logger.info("setup method is called");
        driver = Driver.getDriver();
        driver.navigate().to("https://dmc312.talentlms.com/index");
        driver = Driver.getDriver();
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

