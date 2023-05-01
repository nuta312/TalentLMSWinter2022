package com.digital.ui.element_helper;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    private WebDriver driver = Driver.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public Alert getAlert(){
        return driver.switchTo().alert();
    }

    public void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        getAlert().accept();
    }

    public void dismissAlert(){
        getAlert().dismiss();
    }

    public boolean isAlertPresent(){

        try{
            driver.switchTo().alert().accept();
            return true;
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
        return false;
    }
}
