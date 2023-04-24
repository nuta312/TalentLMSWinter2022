package com.digital.ui.driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public interface Waits {

    Integer implicitWaitTime = 20;

     WebDriver.Timeouts setUpImplicitWait();


    WebDriver.Timeouts setUpImplicitWait(WebDriver driver);
}
