package ui.smoke;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import ui.BaseUiTest;

public class Navigate extends BaseUiTest {

    public static void main(String[] args) {


        Driver.getDriver().navigate().to("https://demoqa.com/alerts");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    }
}