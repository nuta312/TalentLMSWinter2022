package com.digital.ui.element_helper;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertHelper {
    @Test
    public void demo1() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/alerts");
        Driver.getDriver().findElement(By.id("alertButton")).click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        Thread.sleep(5000);

        Driver.getDriver().findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        Driver.getDriver().findElement(By.id("confirmButton")).click();
        alert.dismiss();
        Driver.getDriver().findElement(By.id("promtButton")).click();
        alert.sendKeys("John Dou");
        alert.accept();
    }

    private WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public Alert getAlert() {
        // наш драйвер переключается на алерт
        return driver.switchTo().alert();
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        getAlert().accept();
    }

    public void dismissAlert() {
        getAlert().dismiss();
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert().accept();
            return true;
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        return false;
    }

}
