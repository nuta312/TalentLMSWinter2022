package ui.smoke;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo {
    @Test
    public void demo1() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/alerts");
        Driver.getDriver().findElement(By.id("alertButton")).click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

    }
}
