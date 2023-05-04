package ui.FrameDemo;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class iframeDemo {


    public static void main(String[] args) {

        WebDriver driver = Driver.getDriver();
        driver.navigate().to("https://www.amazon.com/");

//        driver.switchTo().frame("frame1"); // Переход на iFrame чтобы видеть элементы в нём
        driver.findElement(By.xpath("//input[contains(@data-action-type,'DISMISS')]")).click();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 14",Keys.ENTER);

        List<WebElement> list = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/span/li/span/a"));
        for (WebElement li: list){
            System.out.println(li.getText());
        }
//        driver.switchTo().defaultContent();
    }
}
