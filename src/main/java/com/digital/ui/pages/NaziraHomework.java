package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class NaziraHomework extends LoginPage {
    WebDriver driver = Driver.getDriver();
    Actions action =new Actions(driver);
    @FindBy (xpath = "//button[@title='Play']")
    WebElement playButton;
    @FindBy (xpath ="//button[@title='Mute']")
    WebElement soundButton;
    @FindBy (xpath ="//button[@title='Fullscreen']")
    WebElement fullscreenButton;

    public NaziraHomework openSite(){
        driver.get("https://nwinter2022.talentlms.com/account/cms_index");
        return this;
    }
    public NaziraHomework TestPage() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300);");
        Thread.sleep(3000);
        playButton.click();
        Thread.sleep(3000);
        action.moveToElement(soundButton).perform();
        Thread.sleep(500);
        soundButton.click();
        Thread.sleep(3000);
        action.moveToElement(fullscreenButton).perform();
        Thread.sleep(500);
        fullscreenButton.click();
        Thread.sleep(1000);
        fullscreenButton.sendKeys(Keys.ESCAPE);
        return this;

    }
    public NaziraHomework closeSite () throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        return this;
    }

}
