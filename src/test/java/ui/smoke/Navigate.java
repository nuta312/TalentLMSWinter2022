
package ui.smoke;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Navigate {
    public static void main(String[] args) {
        Driver.getDriver().navigate().to("https://demoqa.com/browser-windows");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id='item-0']"));
        js.executeScript("arguments[0].click()", element);
        Driver.getDriver().navigate().back();
        WebElementActions.pause(3000);
        Driver.getDriver().navigate().forward();
        WebElementActions.pause(3000);
        Driver.getDriver().navigate().refresh();

    }

}

