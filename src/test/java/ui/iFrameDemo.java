package ui;

import com.digital.ui.driver.Driver;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.Key;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class iFrameDemo {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();

        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone14", Keys.ENTER);


        List<WebElement>brandlist = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/span/li/span/a"));

        for (WebElement s : brandlist){
            System.out.println(s.getText());
        }
    }
    @Test
    public void testExample() throws IOException, MailosaurException {
        // Available in the API tab of a server
        String apiKey = "Xr2Tpu19d3NmPfRUVnQpPhpAs3QQvVfX";
        String serverId = "52hb1c3k";
        String serverDomain = "line-fruit@52hb1c3k.mailosaur.net";

        MailosaurClient mailosaur = new MailosaurClient(apiKey);

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();
//        criteria.withSentTo("real-attention@" + serverDomain);
        criteria.withSentFrom("adiletkushubekov@gmail.com");
        criteria.withSubject("This is link to google");

        Message message = mailosaur.messages().get(params, criteria);

        assertNotNull(message);
        assertEquals("This is link to google", message.subject());
        System.out.println(message.subject());
        System.out.println(message.text().body());
        System.out.println(message.html().links().size());
        System.out.println(message.html().links().get(0).href());

        String url = message.html().links().get(0).href();
        Driver.getDriver().get(url);
    }
}
