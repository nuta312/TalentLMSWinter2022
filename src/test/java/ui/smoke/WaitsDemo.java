package ui.smoke;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsDemo {


    @Test
    public void implicitWaitsDemo() {
        Driver.getDriver().get("https://www.google.com/");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        WebElement searchButton = Driver.getDriver().findElement(By.name("btnK"));
        searchBox.sendKeys("Selenium");
        searchButton.click();
    }

    @Test
    public void explicitWaitDemo() {
        Driver.getDriver().get("https://demoqa.com/alerts");
        Driver.getDriver().findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();

    }
    @Test
    public void fluentsWaitsDemo() {
        Driver.getDriver().get("https://demoqa.com/buttons");
        WebElement element = new FluentWait<>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .until(driver -> driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")));
        element.click();
    }

}
