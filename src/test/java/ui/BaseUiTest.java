package ui;


import com.digital.ui.driver.Driver;
import com.digital.ui.driver.DriverActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract class BaseUiTest implements DriverActions {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = Driver.getDriver();
        driver.get("https://dmc312.talentlms.com/index");
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
