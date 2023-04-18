package ui;

import com.digital.ui.driver.Driver;

public class BrowserNavigation {
    public static void main(String[] args) {

        Driver.getDriver().navigate().to("https://demoqa.com/tool-tips");
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        Driver.getDriver().navigate().refresh();
    }
}
