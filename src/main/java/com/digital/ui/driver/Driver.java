package com.digital.ui.driver;

import com.digital.config.ConfigReader;
import org.openqa.selenium.WebDriver;


public class Driver {

    private Driver() {
        // Singleton pattern
    }

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null) {
            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;

                case "sauce_windows_chrome":
                    driver = SauceLabsWindowsChrome.loadSauceLabWindowsChromeDriver();

                case "firefox":
                    driver = FirefoxWebDriver.loadFirefoxDriver();

                    break;
                case  "sauce_mac_safari":
                    driver = SauceLabsMacFireFox.loadSauceMacFireFoxDriver();

                    break;
                default:
                    throw new RuntimeException("You provided wrong browser name");
            }
        }
        return driver;
    }


    public static void closeDriver(){
        try {
            if (driver != null){
                driver.close();
                driver.quit();
                driver = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
