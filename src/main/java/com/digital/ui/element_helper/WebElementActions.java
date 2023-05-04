package com.digital.ui.element_helper;

import com.digital.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    Actions actions = new Actions(Driver.getDriver());


    public WebElementActions input(WebElement element,String txt){
        logger.warn("I am trying to write " + txt + " " + element);
        waitElementToBeDisplayed(element);
        element.sendKeys(txt);
        logger.info("Successfully write");
        return this;
    }

    public WebElementActions press(WebElement element){
        logger.warn("Trying to click the " + element);
        waitElementToBeDisplayed(element);
        element.click();
        logger.info("Successfully clicked the " + element);
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
            logger.warn("Waiting something");
            TimeUnit.MILLISECONDS.sleep(milliseconds);
            logger.info("Success");
        }catch (InterruptedException e){
            logger.error(e.getMessage());
        }
    }
        public WebElementActions scrollDown() {
            Actions actions = new Actions(Driver.getDriver());
            actions.scrollByAmount(0, 250).perform();
        return this;
    }



    public WebElementActions pressJs(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
        return this;
    }


    public Actions getActions() {
        return new Actions(Driver.getDriver());
    }
}
//    public FilesPage editNameOfFile (String fileName,String fileNameNew) {
//        try {
//            actions.moveToElement(Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + fileName + "')]"))).perform();
//            WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + fileName + "')]//i[contains(@alt,'Edit file')]"));
//            actions.moveToElement(deleteBtn).click().perform();
//            renameFile(fileNameNew);
//            elementActions.press(updateFileOptinos); // кнопка подтвердить
//            return this;
//        } catch (NoSuchElementException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public FilesPage deleteFile(String fileName){
//        try {
//            actions.moveToElement(Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]"))).perform();
//            WebElement deleteBtn = Driver.getDriver().findElement(By.xpath("//tr[contains(., '"+fileName+"')]//i[contains(@title,'Delete')]"));
//            new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5))
//                    .until(ExpectedConditions.visibilityOf(deleteBtn));
//            actions.moveToElement(deleteBtn).click().perform();
//
//            new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5))
//                    .until(ExpectedConditions.visibilityOf(confirmDialog));
//
//            actions.moveToElement(confirmDelete).click().perform();
//            Thread.sleep(3000);
//            return this;
//        } catch (NoSuchElementException e){
//            System.out.println("Такого файла нету");
//            return null;
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public WebElementActions scrollDown() {
//        actions.scrollByAmount(0, 250).perform();
//        return this;
//    }



//    public WebElementActions pressJs(WebElement element){
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("arguments[0].click();", element);
//        return this;
//    }
