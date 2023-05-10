package ui;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IframeDemo {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        driver.navigate().to("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());
        driver.switchTo().defaultContent();
    }


}
