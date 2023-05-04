package com.digital.ui.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SauceLabsMacSafari {

    public static RemoteWebDriver loadSauceLabMacSafariDriver() {
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setPlatformName("macOS 13");
        browserOptions.setBrowserVersion("16");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "<your build id>");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);
        URL url = null;
        try {
            url = new URL("https://oauth-aisanerlanova8-054ba:ad2fc7fa-353e-4100-ae00-79460b2c01b9@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
       return new RemoteWebDriver(url, browserOptions);
    }

    public static void main(String[] args) {
        RemoteWebDriver remoteWebDriver = loadSauceLabMacSafariDriver();
        remoteWebDriver.get("https://www.youtube.com/watch?v=NfG-AGejUKg");
    }

}
