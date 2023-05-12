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
    public Alert switchAlert(){
        return Driver.getDriver().switchTo().alert();
    }

    public void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        switchAlert().accept();
    }

    private Alert getAlert() {
        return null;
    }

    public void dismissAlert(){
        getAlert().dismiss();
    }

    public void sendKeysAlert(String text){
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


