package ui;


import com.digital.Listeners.ScreenshotListener;
import com.digital.ui.driver.Driver;
import com.digital.ui.driver.DriverActions;
import com.digital.ui.element_helper.WebElementActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public abstract class BaseUiTest  {

    public WebDriver driver;
    private static Logger logger = LogManager.getLogger(BaseUiTest.class);

    @BeforeClass
    public void setUp() {
        logger.info("setup method is called");
        driver = Driver.getDriver();
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
