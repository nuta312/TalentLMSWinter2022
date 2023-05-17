package ui;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.*;
import java.io.IOException;


import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
public class IFrameDemo {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();

        driver.navigate().to("https://www.amazon.com/");
//        driver.switchTo().frame("frame1");
//        WebElement element = driver.findElement(By.id("sampleHeading"));
//        System.out.println(element.getText());
//        driver.switchTo().defaultContent();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone14", Keys.ENTER);
        List<WebElement> brandList = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/span/li/span/a"));

        for (WebElement s : brandList) {
            System.out.println(s.getText());
        }
    }


    @Test
    public void testExample() throws IOException, MailosaurException {
        // Available in the API tab of a server
        String apiKey = "1iBqzd6Gkd1EhESHWvlzn0aqZy0l1yCo";
        String serverId = "iaczgwzs";
        String serverDomain = "beat-car@iaczgwzs.mailosaur.net";

        MailosaurClient mailosaur = new MailosaurClient(apiKey);

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo("asdas@" + serverDomain);

        Message message = mailosaur.messages().get(params, criteria);

        assertNotNull(message);
        assertEquals("My email subject", message.subject());
    }
}
