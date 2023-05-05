package com.digital.ui.element_helper;

import com.digital.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Nursultan Musakunov
 */
public class WebElementActions {

    private static Logger logger = LogManager.getLogger(WebElementActions.class);


    public WebElementActions input(WebElement element,String txt) {
        logger.warn("I am trying to write " + txt + " " + element);
        waitElementToBeDisplayed(element);
        element.sendKeys(txt);
        logger.info("Successfully write");
        return this;
    }

    public WebElementActions press(WebElement element)  {
        logger.warn("Trying to click the " + element);
        waitElementToBeClickAble(element);
        element.click();
        logger.info("Successfully clicked the " + element);
        return this;
    }

    public WebElementActions waitElementToBeDisplayed(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeClickAble(WebElement element)  {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementActions pressDownAndEnter(WebElement element){
        element.sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }

    public static void pause(Integer milliseconds){
        try {
            logger.warn("Waiting something");
            TimeUnit.MILLISECONDS.sleep(milliseconds);
            logger.info("Success");
        }catch (InterruptedException e){
            logger.error(e.getMessage());
        }
    }

    public static void rrr(){
        logger.info("Hello");
    }

    public static void main(String[] args) {
        rrr();
    }


}


