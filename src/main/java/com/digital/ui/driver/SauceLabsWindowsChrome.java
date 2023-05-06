package com.digital.ui.driver;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SauceLabsWindowsChrome {

    public static void main(String[] args){

        RemoteWebDriver remoteWebDriver = loadSauceLabWindowsChromeDriver();

        remoteWebDriver.get("https://www.youtube.com/watch?v=Kbj2Zss-5GY&list=RDbxD7BeZE4j8&index=2");
    }

    public static RemoteWebDriver loadSauceLabWindowsChromeDriver()  {

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<your build id>");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = null;

        try {
            url = new URL("https://oauth-dzanybekovaaigerim1996-4c48b:d71d6d0e-2ce7-4775-9d04-32759b26a293@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return new RemoteWebDriver(url, browserOptions);
    }



}