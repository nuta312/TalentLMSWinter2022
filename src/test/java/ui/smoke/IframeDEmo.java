package ui.smoke;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class IframeDEmo {
    public static void main(String[] args) {
        WebElementActions elementActions = new WebElementActions();

        WebDriver driver = Driver.getDriver();
        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("Iphon4 14", Keys.ENTER);
        elementActions.scrollDown();
        List<WebElement> brandList =
                driver.findElements(By.xpath(
                        "//div[@id='brandsRefinements']/ul/span/li/span/a"));
        for (WebElement e:brandList){
            System.out.println(e.getText());
        }

    }
    @Test
    public void iframeDemo(){
        WebDriver driver = Driver.getDriver();
        driver.navigate().to("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());
    }


}
