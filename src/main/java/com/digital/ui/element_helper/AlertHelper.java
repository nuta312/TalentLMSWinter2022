package com.digital.ui.element_helper;

<<<<<<< HEAD
=======
import com.beust.ah.A;
>>>>>>> origin/AigerimDzh
import com.digital.ui.driver.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    private WebDriver driver = Driver.getDriver();
<<<<<<< HEAD

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public Alert getAlert(){
        return driver.switchTo().alert();
=======
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public Alert switchAlert(){
        return Driver.getDriver().switchTo().alert();
>>>>>>> origin/AigerimDzh
    }

    public void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
<<<<<<< HEAD
        getAlert().accept();
    }

    public void dismissAlert(){
        getAlert().dismiss();
    }

    public boolean isAlertPresent(){

        try{
=======
        switchAlert().accept();
    }
    public void dismissAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        switchAlert().dismiss();
    }


    public void sendKeysAlert(String text){
        wait.until(ExpectedConditions.alertIsPresent());
        switchAlert().sendKeys(text);
        switchAlert().accept();
    }

    private boolean isAlertPresent(){
        try {
>>>>>>> origin/AigerimDzh
            driver.switchTo().alert().accept();
            return true;
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
        return false;
    }
<<<<<<< HEAD
=======


>>>>>>> origin/AigerimDzh
}
