package com.digital.ui.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SauceLabsMacFireFox {

    public static RemoteWebDriver loadSauceMacFireFoxDriver(){
        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("macOS 13");
        browserOptions.setBrowserVersion("112");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<your build id>");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL("https://oauth-bekowa123-901e2:200cca8b-cdcd-48f1-9de7-ca676360d89b@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
        } catch (MalformedURLException e){
            throw  new RuntimeException(e);
        }

        return new RemoteWebDriver(url,browserOptions);
    }


    public static void main(String[] args) {
        RemoteWebDriver remoteWebDriver = loadSauceMacFireFoxDriver();
        remoteWebDriver.get("https://www.youtube.com/watch?v=Kbj2Zss-5GY&list=RDbxD7BeZE4j8&index=2");

    }

}
