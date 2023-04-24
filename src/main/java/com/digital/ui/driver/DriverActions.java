package com.digital.ui.driver;

import org.openqa.selenium.WebDriver;

public interface DriverActions {


    WebDriver driver = Driver.getDriver();
    default void open( String url) {
        driver.navigate().to(url);
    }

}
