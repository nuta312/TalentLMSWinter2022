package com.digital.ui.element_helper;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Nursultan Musakunov
 */
public class WebElementActions {

    Actions actions = new Actions(Driver.getDriver());


    public WebElementActions input(WebElement element,String txt){
        waitElementToBeDisplayed(element);
        element.sendKeys(txt);
        return this;
    }

    public WebElementActions press(WebElement element){
        waitElementToBeClickAble(element);
        element.click();
        return this;
    }

    public WebElementActions waitElementToBeDisplayed(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeClickAble(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(40))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementActions pressDownAndEnter(WebElement element){
        element.sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }

    public WebElementActions pressUpAndEnter(WebElement element){
        waitElementToBeClickAble(element);
        element.sendKeys(Keys.UP,Keys.ENTER);
        return this;
    }

    public WebElementActions moveToElement (WebElement element){
        actions.moveToElement(element).perform();
        return this;
    }

    public static void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        }catch (InterruptedException e){
            System.out.println("error seconds");
        }
    }

    public WebElementActions customAssertEquals(WebElement element, String str) {
        waitElementToBeDisplayed(element);
        Assert.assertEquals(element.getText(), str);
        return this;
    }


}
