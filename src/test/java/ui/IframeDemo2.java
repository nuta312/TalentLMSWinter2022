package ui;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IframeDemo2 {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();

        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phones", Keys.ENTER);

        List<WebElement> brandlist = driver.findElements (By.xpath("//div[@id='brandsRefinements']/ul/span/li/span/a"));

        for (WebElement s : brandlist){
            System.out.println(s.getText());
        }
    }
}
