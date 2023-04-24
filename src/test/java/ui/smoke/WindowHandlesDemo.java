package ui.smoke;

import com.digital.ui.driver.BrowserHelper;
import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WindowHandlesDemo {

    public static void main(String[] args) {


        BrowserHelper browserHelper = new BrowserHelper();

        browserHelper.open("https://demoqa.com/browser-windows");
        Driver.getDriver().findElement(By.id("tabButton")).click();
        Driver.getDriver().findElement(By.id("tabButton")).click();
        Driver.getDriver().findElement(By.id("tabButton")).click();
        WebElementActions.pause(2000);
        browserHelper.switchToWindow(1);
        WebElementActions.pause(2000);
        browserHelper.switchToWindow(2);
        WebElementActions.pause(2000);
        browserHelper.switchToParentWindow();
        WebElementActions.pause(2000);
    }


}
