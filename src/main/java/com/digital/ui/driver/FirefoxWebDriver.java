package com.digital.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;


public class FirefoxWebDriver implements Waits {
    private static WebDriver driver;

    public static WebDriver loadFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        driver = new FirefoxDriver(options);
        FirefoxWebDriver firefoxWebDriver = new FirefoxWebDriver();
        firefoxWebDriver.setUpImplicitWait(driver);
        return driver;
    }

    @Override
    public WebDriver.Timeouts setUpImplicitWait() {
        return null;
    }

    @Override
    public WebDriver.Timeouts setUpImplicitWait(WebDriver driver) {
        return null;
    }
}
