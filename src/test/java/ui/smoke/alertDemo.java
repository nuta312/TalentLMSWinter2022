package ui.smoke;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class alertDemo {




    @Test
    public void demo1() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/alerts");
        Driver.getDriver().findElement(By.id("alertButton")).click();
        Alert alert = Driver.getDriver().switchTo().alert();
        Thread.sleep(1000);
        alert.accept();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(7));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        Driver.getDriver().findElement(By.id("confirmButton")).click();
        Thread.sleep(1000);
        alert.dismiss();
        Driver.getDriver().findElement(By.id("promtButton")).click();
        Thread.sleep(1000);
        alert.sendKeys("Erlan");
        Thread.sleep(1000);
        alert.accept();
        WebElementActions.pause(1000);








    }
}
