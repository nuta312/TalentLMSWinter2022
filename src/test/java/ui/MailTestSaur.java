package ui;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class MailTestSaur {


        @Test
        public void testExample() throws IOException, MailosaurException {
            // Available in the API tab of a server
            String apiKey = "hPjfMntqw7cDiNJ6cJXNi0bTk9CZMA8e";
            String serverId = "hts5dank";
            String serverDomain = "powerful-park@hts5dank.mailosaur.net";

            MailosaurClient mailosaur = new MailosaurClient(apiKey);

            MessageSearchParams params = new MessageSearchParams();
            params.withServer(serverId);

            SearchCriteria criteria = new SearchCriteria();
            //criteria.withSentTo("changing-quietly@" + serverDomain);
            criteria.withSentFrom("ulan.torobekov@gmail.com");
            criteria.withSubject("This is link for google");

            Message message = mailosaur.messages().get(params, criteria);

            assertNotNull(message);
            assertEquals("asgard", message.subject());
            System.out.println(message.subject());
            System.out.println(message.text().body());
        }
}
