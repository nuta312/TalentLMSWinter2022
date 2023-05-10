package ui;

import com.digital.ui.driver.Driver;
import com.digital.ui.driver.DriverActions;
import com.digital.ui.pages.account_settings.E_CommercePage;
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.UserPage.FilesPage;
import com.digital.ui.pages.UserPage.PageGroups;
import com.digital.ui.pages.UserPage.UsersOptions;
import com.digital.ui.pages.UserPage.UsersPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


    public abstract class BaseUiTest implements DriverActions {

        public WebDriver driver;
        public LoginPage loginPage;
        public HomePage homePage;
        public FilesPage filesPage;
        public PageGroups pageGroups;
        public UsersOptions usersOptions;
        public UsersPage usersPage;

        public E_CommercePage e_commercePage;

        @BeforeClass
        public void setUp() {
            driver = Driver.getDriver();
            driver.navigate().to("https://dmc312.talentlms.com/index");
            driver = Driver.getDriver();
            loginPage = new LoginPage();
            homePage = new HomePage();
            filesPage = new FilesPage();
            pageGroups = new PageGroups();
            usersOptions = new UsersOptions();
            usersPage = new UsersPage();
            e_commercePage = new E_CommercePage();

        }


        @AfterClass
        public void tearDown() {
            Driver.closeDriver();
        }
    }


