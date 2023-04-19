package com.digital.ui.driver;

import org.openqa.selenium.WebDriver;

public interface DriverActions {
    public default void open(WebDriver driver, String url){
        driver.navigate().to(url);
    }
}
