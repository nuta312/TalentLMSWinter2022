package ui.smoke;

import com.digital.ui.driver.Driver;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class Mailosaur {
    @Test

    public void testExample() throws IOException, MailosaurException {
        // Available in the API tab of a server
        String apiKey = "lfRkjfAvAMhakKiUzdb87bxJTx5q0WPh";
        String serverId = "avbjycu5";
        String serverDomain = "remember-smell@avbjycu5.mailosaur.net";

        MailosaurClient mailosaur = new MailosaurClient(apiKey);

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();
//        criteria.withSentTo("typical-start@avbjycu5.mailosaur.net" + serverDomain);
        criteria.withSentFrom("aisanerlanova8@gmail.com");
        criteria.withSubject("This is link for google");

        Message message = mailosaur.messages().get(params, criteria);

        assertNotNull(message);
        assertEquals("This is link for google", message.subject());
        System.out.println(message.subject());
        System.out.println(message.text().body());
        System.out.println("------------");
        System.out.println(message.html().links().get(0).href());
        String url = message.html().links().get(0).href();
        Driver.getDriver().get(url);
    }
}
