package ui.mailsaur;

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

public class mailosaurDemo {

    @Test
    public void testExample() throws IOException, MailosaurException {
        // Available in the API tab of a server
        String apiKey = "GEJ6Z4nCXKw2M6QA1Zpiem2vf9hOuLeg";
        String serverId = "gzeddo86";
        String serverDomain = "nine-met@gzeddo86.mailosaur.net";

        MailosaurClient mailosaur = new MailosaurClient(apiKey); //

        MessageSearchParams params = new MessageSearchParams(); // Поиск сообщений по параметрам
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();  // поиск по критериям
//        criteria.withSentTo("finally-slow@gzeddo86.mailosaur.net" + serverDomain);
        criteria.withSentFrom("bekowa123@gmail.com");
        criteria.withSubject("this is link for google");

        Message message = mailosaur.messages().get(params, criteria);  // смотреть контент сообщения

        assertNotNull(message);
//        assertEquals("Hello World", message.subject());

        System.out.println(message.subject());
        System.out.println(message.text().body());
        System.out.println(message.html().links().size());
        System.out.println("----____----");
        System.out.println(message.html().links().get(0).href());

        String url = message.html().links().get(0).href();

        Driver.getDriver().get(url);
    }
}
