package com.digital.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class ChromeWebDriver implements Waits{
    public static WebDriver driver;

    public static WebDriver loadChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");


        driver = new ChromeDriver(options);
        ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
        chromeWebDriver.setUpImplicitWait(driver);
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public WebDriver.Timeouts setUpImplicitWait(WebDriver driver) {
        return Waits.super.setUpImplicitWait(driver);
    }
}
