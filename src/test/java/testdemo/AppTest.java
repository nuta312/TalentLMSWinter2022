package testdemo;


import static org.junit.Assert.*;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.*;
import org.testng.annotations.Test;

import java.io.IOException;
public class AppTest {
    @Test
    public void testExample() throws IOException, MailosaurException {
        // Available in the API tab of a server
        String apiKey = "Kuvsqj39LTjWhpTIa8ehzjhDl3LhY2z5";
        String serverId = "zahxt195";
        String serverDomain = "tank-island@zahxt195.mailosaur.net";

        MailosaurClient mailosaur = new MailosaurClient(apiKey);

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();
//        criteria.withSentTo("replied-order@zahxt195.mailosaur.net" + serverDomain);
        criteria.withSentFrom("rustam_karimov2@outlook.com");
        criteria.withSubject("Hello World!");

        Message message = mailosaur.messages().get(params, criteria);

        assertNotNull(message);
        assertEquals("Hello World!", message.subject());
        System.out.println(message.subject());
        System.out.println(message.html().body());
        System.out.println(message.text().body());
    }
}
