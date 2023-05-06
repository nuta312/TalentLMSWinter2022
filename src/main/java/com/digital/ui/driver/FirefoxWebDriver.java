package com.digital.ui.driver;

<<<<<<< HEAD
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
=======
import com.digital.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
>>>>>>> master
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

<<<<<<< HEAD
public class FirefoxWebDriver implements Waits {
    private static WebDriver driver;
    public static WebDriver loadFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--disable-extensions");
//        options.addArguments("--no-sandbox");


        driver = new FirefoxDriver(options);
        FirefoxWebDriver firefoxWebDriver = new FirefoxWebDriver();
        firefoxWebDriver.setUpImplicitWait(driver);
=======
public class FirefoxWebDriver {

    public static WebDriver loadFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-extencions");
        options.addArguments("--no-sandbox");

//        if(Boolean.parseBoolean(ConfigReader.getProperty("headless"))){
//            options.addArguments("--headless");
//        }

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
>>>>>>> master
        driver.manage().window().maximize();
        return driver;
    }

<<<<<<< HEAD
    @Override
    public WebDriver.Timeouts setUpImplicitWait() {
        return null;
    }

    @Override
    public WebDriver.Timeouts setUpImplicitWait(WebDriver driver) {
        return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Waits.implicitWaitTime));
    }
=======
>>>>>>> master
}
