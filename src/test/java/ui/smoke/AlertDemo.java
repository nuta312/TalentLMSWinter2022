package ui.smoke;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo {
    @Test
    public void open() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/alerts");
        Driver.getDriver().findElement(By.id("alertButton")).click();
        Thread.sleep(2000);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();


        Driver.getDriver().findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        Driver.getDriver().findElement(By.id("confirmButton")).click();
        alert.dismiss();

        Driver.getDriver().findElement(By.id("promtButton")).click();
        alert.sendKeys("John Doe");
        alert.accept();
    }
}
