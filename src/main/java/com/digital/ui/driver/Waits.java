package com.digital.ui.driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public interface Waits {

    Integer implicitWaitTime = 20;

    default WebDriver.Timeouts setUpImplicitWait(WebDriver driver){
       return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
    }

    WebDriver.Timeouts setUpImplicitWait();
}
