package ui;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserNavigation {
    public static void main(String[] args) {

        Driver.getDriver().navigate().to("https://demoqa.com/tool-tips");
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        Driver.getDriver().navigate().refresh();
    }

    @Test
    public void test123(){
        Driver.getDriver().navigate().to("https://demoqa.com/alerts");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        WebElement element= Driver.getDriver().findElement(By.xpath());
//        js.executeScript();
    }
}
