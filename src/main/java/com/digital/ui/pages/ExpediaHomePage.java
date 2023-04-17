package com.digital.ui.pages;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpediaHomePage {

    private WebElementActions elementActions = new WebElementActions();

    public ExpediaHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Stays']")
    public WebElement stays;
    @FindBy(xpath = "//span[text()='Flights']")
    public WebElement flights;
    @FindBy(xpath = "//span[text()='Cars']")
    public WebElement cars;
    @FindBy(xpath = "//span[text()='Packages']")
    public WebElement packages;
    @FindBy(xpath = "//button[@aria-label='Going to']")
    public WebElement goingToBtn;
    @FindBy(id = "location-field-destination")
    public WebElement locationDestinationInputField;
    @FindBy(xpath = "//button[@data-testid='submit-button']")
    public WebElement searchBtn;

    public ExpediaHomePage goToHomePage() throws InterruptedException {
        Driver.getDriver().get("https://www.expedia.com/");
        Thread.sleep(5000);
        return this;
    }

    public ExpediaHomePage searchByDestination(String destination) throws InterruptedException {
        elementActions.press(goingToBtn)
                .input(locationDestinationInputField, destination);
        Thread.sleep(5000);
        locationDestinationInputField.sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        locationDestinationInputField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        elementActions.press(searchBtn);
        return this;
    }
}
