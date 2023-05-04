package com.digital.ui.element_helper;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class AlertHelper {

    private WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public AlertHelper() throws MalformedURLException {
    }

    public Alert switchAlert() throws MalformedURLException {
        return Driver.getDriver().switchTo().alert();
    }

    public void acceptAlert() throws MalformedURLException {
        wait.until(ExpectedConditions.alertIsPresent());
        switchAlert().accept();
    }
    public void dismissAlert() throws MalformedURLException {
        wait.until(ExpectedConditions.alertIsPresent());
        switchAlert().dismiss();
    }


    public void sendKeysAlert(String text) throws MalformedURLException {
        wait.until(ExpectedConditions.alertIsPresent());
        switchAlert().sendKeys(text);
        switchAlert().accept();
    }

    private boolean isAlertPresent(){
        try {
            driver.switchTo().alert().accept();
            return true;
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
        return false;
    }


}
