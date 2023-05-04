package ui.smoke;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.dnd.DragGestureEvent;

public class Navigate {
    @Test
    public void test123() throws InterruptedException {
        Driver.getDriver().navigate().to("https://demoqa.com/alerts");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"item-0\"]/span"));
        js.executeScript("arguments[0].click()",element);
        Driver.getDriver().navigate().back();
        Thread.sleep(3000);
        Driver.getDriver().navigate().forward();
        Thread.sleep(3000);
        Driver.getDriver().navigate().refresh();
        Thread.sleep(3000);
    }
}
