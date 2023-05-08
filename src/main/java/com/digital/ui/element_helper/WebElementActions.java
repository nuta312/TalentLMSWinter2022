package com.digital.ui.element_helper;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Nursultan Musakunov
 */
public class WebElementActions {

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
    public WebElementActions fileupload(WebElement element,String txt){
        element.sendKeys(txt);
        return this;
    }
    public WebElementActions waitElementToBeDisplayed(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeClickAble(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementActions pressDownAndEnter(WebElement element){
        element.sendKeys(Keys.DOWN,Keys.ENTER);
        return this;
    }


}
