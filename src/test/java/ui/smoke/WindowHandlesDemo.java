package ui.smoke;

import com.digital.ui.driver.BrowserHelper;
import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;

import java.awt.dnd.DragGestureEvent;

public class WindowHandlesDemo {
    public static void main(String[] args) {

        BrowserHelper browserHelper = new BrowserHelper();
        browserHelper.open("https://demoqa.com/browser-windows");
        Driver.getDriver().findElement(By.id("tabButton")).click();
        Driver.getDriver().findElement(By.id("tabButton")).click();
        Driver.getDriver().findElement(By.id("tabButton")).click();
        browserHelper.switchToWindow(1);
        browserHelper.switchToWindow(2);
        browserHelper.switchToWindow(0);


    }
}
