package ui.regression;

import com.digital.ui.driver.Driver;
import com.digital.ui.pages.BrokenLinks;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrokenLinkTest {

    BrokenLinks brokenLinks = new BrokenLinks();

    @Test
    public void checkLinks() throws IOException {
        Driver.getDriver().navigate().to("https://demoqa.com/broken");
        brokenLinks.getImg();
        brokenLinks.checkLinks();
    }


}
