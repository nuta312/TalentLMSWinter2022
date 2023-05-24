package com.digital.ui.element_helper;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class WebElementActions {


    private static Logger logger = LogManager.getLogger(WebElementActions.class);

    Actions actions = new Actions(Driver.getDriver());

    public WebElementActions input(WebElement element,String txt){
        logger.warn("I'm trying to write " + txt + " " + element);
        waitElementToBeDisplayed(element);
     //   element.clear();
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
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }
    public WebElementActions waitElementToBeClickAble(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20))
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

    public WebElementActions pressUpAndEnter(WebElement element){
        waitElementToBeClickAble(element);
        element.sendKeys(Keys.UP,Keys.ENTER);
        return this;
    }

    public WebElementActions customAssertEquals(WebElement element, String str) {
        waitElementToBeDisplayed(element);
        Assert.assertEquals(element.getText(), str);
        return this;
    }

}
