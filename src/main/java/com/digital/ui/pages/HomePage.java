package com.digital.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='brand']")
    public WebElement talentLmsHomePageLink;
    @FindBy(xpath = "//div[contains(@class,'tl-bold-link')]//a[contains(text(),'Users')]")
    public WebElement Users;
     @FindBy(xpath = "//a[contains(text(),'Account & Settings')]")
    public WebElement accountSettings;

    public HomePage goToHomePage() {
        talentLmsHomePageLink.click();
        return this;
    }

    public HomePage openUsers() {
        elementActions.press(Users);
        return this;
    }
    public HomePage clickToAccountSettings(){
        accountSettings.click();
}
