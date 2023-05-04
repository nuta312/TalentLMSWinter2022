package com.digital.ui.element_helper;

import com.digital.ui.driver.Driver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * @author Nursultan Musakunov
 */
public class WebElementActions {

    private static Logger logger = LogManager.getLogger(WebElementActions.class);


    public WebElementActions input(WebElement element,String txt){
        logger.warn("I'm trying to write " + txt + " " + element);
        waitElementToBeDisplayed(element);
        element.sendKeys(txt);
        logger.info("Succesfully write");
        return this;
    }

    public WebElementActions press(WebElement element){
        logger.warn("Trying to click the " + element);
        waitElementToBeDisplayed(element);
        element.click();
        logger.info("Successfully clicked");
        return this;
    }

    public WebElementActions waitElementToBeDisplayed(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(7))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeClickAble(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }


    public WebElementActions waitElementToBeDisplayedLocated(WebElement element,String locator){
        new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(7))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return this;
    }

    public WebElementActions pressDownAndEnter(WebElement element){
        element.sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }

    public static void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        }catch (InterruptedException e){
            System.out.println("error seconds");
        }
    }




}
