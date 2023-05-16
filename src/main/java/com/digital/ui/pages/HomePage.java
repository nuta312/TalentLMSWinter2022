package com.digital.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * @author Adilet Kushubekov
 */

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='brand']")
    public WebElement talentLmsHomePageLink;
    @FindBy(xpath = "//div[contains(@class,'tl-bold-link')]//a[contains(text(),'Users')]")
    public WebElement Users;
    @FindBy(xpath = "//a[contains(text(),'Account & Settings')]")
    public WebElement accountSettings;
    @FindBy(xpath = "(//a[contains(text(),'Courses')])[1]")
    public WebElement courses;

    public HomePage goToHomePage() {
        talentLmsHomePageLink.click();
        return this;
    }
    public HomePage clickCourses() {
        courses.click();
        return this;
    }

    public HomePage openUsers() {
        elementActions.press(Users);
        return this;
    }

    public HomePage clickToAccountSettings() {
        accountSettings.click();
        return this;
    }

}
