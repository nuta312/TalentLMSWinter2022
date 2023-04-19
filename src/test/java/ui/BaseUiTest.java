package ui;

import com.digital.ui.driver.Driver;
import com.digital.ui.driver.DriverActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseUiTest implements DriverActions {

    public WebDriver driver = Driver.getDriver();

    @BeforeClass
    public void setUp(){

    }
    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}
