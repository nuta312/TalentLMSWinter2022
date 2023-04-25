package ui.smoke;

import com.digital.ui.driver.BrowserHelper;
import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;


public class WindowHandlesDemo {

    public static void main(String[] args) {
        BrowserHelper browserHelper = new BrowserHelper();

        browserHelper.open("");
        Driver.getDriver().findElement(By.id("tabButton")).click();
//        browserHelper.switchToWindow(1);


    }
}
