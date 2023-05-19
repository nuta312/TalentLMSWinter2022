package ui.pages;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.AddUserPage;
import com.digital.ui.pages.BasePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.UsersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

    public abstract class BaseUiTest {
    public LoginPage loginPage;
    public WebElementActions webElementActions;
    public WebDriver driver;
    public Actions actions;
    public UsersPage userPage;
    public AddUserPage addUserPage;
    public BasePage basePage;

@BeforeClass
public void setUpUiTest(){
    loginPage=new LoginPage();
    webElementActions=new WebElementActions();
    driver= Driver.getDriver();
    userPage=new UsersPage();
    addUserPage=new AddUserPage();
    LoginPage loginPage=new LoginPage();

}
@AfterTest
        public void tearDown(){
    driver.close();
    driver.quit();
}
}
