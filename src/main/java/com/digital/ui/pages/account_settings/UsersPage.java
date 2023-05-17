package com.digital.ui.pages.account_settings;


import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.BasePage;
import com.github.javafaker.Faker;
import org.bouncycastle.jcajce.provider.symmetric.Threefish;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


/**
 * @author Bakai Saitkulov
 */

public class UsersPage extends BasePage {

    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());

    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Users']")
    public WebElement usersPage;

    @FindBy(xpath = "//select[@name='signup']")
    public WebElement signUp;

    @FindBy(xpath = "//select[@name='verification']")
    public WebElement userVerification;

    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[1]")
    public WebElement icon1;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[2]")
    public WebElement icon2;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[3]")
    public WebElement icon3;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[4]")
    public WebElement icon4;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[5]")
    public WebElement icon5;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[6]")
    public WebElement icon6;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[7]")
    public WebElement icon7;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[8]")
    public WebElement icon8;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[9]")
    public WebElement icon9;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[10]")
    public WebElement icon10;

    @FindBy(xpath = "//select[@name='default_type']")
    public WebElement defaultUserType;

    @FindBy(xpath = "//select[@name='default_group']")
    public WebElement defaultGroup;

    @FindBy(xpath = "//a[text()='Password settings']")
    public WebElement passwordSettings;
    @FindBy(xpath = "//input[@id='strong_passwords']")
    public WebElement strongPasswordBox;
    @FindBy(xpath = "//input[@id='password_change_x_days']")
    public WebElement passwordChangeXDaysBox;
    @FindBy(xpath = "//input[@id='password_change_days']")
    public WebElement passwordDays;
    @FindBy(xpath = "//input[@id='password_change']")
    public WebElement passwordChangeBox;
    @FindBy(xpath = "//input[@id='lock_login_retries']")
    public WebElement lockLoginBox;
    @FindBy(xpath = "//input[@id='lock_login_retry_attempts']")
    public WebElement retryAttempts;
    @FindBy(xpath = "//input[@id='lock_login_retry_minutes']")
    public WebElement retryMinutes;

    @FindBy(xpath = "//a[text()='Terms of Service']")
    public WebElement termsOfService;
    @FindBy(xpath = "//textarea[@name='license_note']")
    public WebElement licenceNote;
    @FindBy(xpath = "//div[@class='input-append tl-countdown']")
    public WebElement countdown;
    @FindBy(xpath = "//input[@id='reset-viewed-license']")
    public WebElement resetLicenceBox;

    @FindBy(xpath = "//a[text()='Visible user format']")
    public WebElement visibleUserFormat;
    @FindBy(xpath = "//select[@name='user_format']")
    public WebElement userFormat;

    @FindBy(xpath = "//a[text()='Social options']")
    public WebElement socialOptions;
    @FindBy(xpath = "//input[@id='social_signup']")
    public WebElement socialSignUpBox;
    @FindBy(xpath = "//input[@name='social_catalog']")
    public WebElement socialCatalogBox;
    @FindBy(xpath = "//input[@name='social_share_certification']")
    public WebElement socialShareBox;
    @FindBy(xpath = "//input[@name='course_rating']")
    public WebElement courseRatingBox;

    @FindBy(xpath = "//a[text()='Single Sign-On (SSO)']")
    public WebElement singleSignOn;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveBtn;
    @FindBy(xpath = "//div[text()='Users settings updated successfully']")
    public WebElement successMessage;
    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement cancelClick;


    public UsersPage generateSignUpOption() {
        signUp.click();
        String signUpMenu = faker.options().option("Direct", "Manually (from Admin)");
        elementActions.input(signUp,signUpMenu);
        return this;
    }
    public UsersPage generateUserVerificationOption(){
            String usersVerification = faker.options().option("Select user verification", "CAPTCHA verification", "CAPTCHA + Email verification",
                    "CAPTCHA + Admin activation", "Admin Activation", "Email verification");
            elementActions.input(userVerification, usersVerification);
        return this;
    }
    public UsersPage generateDefaultUserTypeOption() {
        String defaultUsersType = faker.options().option("Learner-Type", "SuperAdmin", "Admin-Type", "Trainer-Type");
        elementActions.input(defaultUserType, defaultUsersType);
        return this;
    }
    public UsersPage inputFields(WebElement clickText, WebElement checkbox, WebElement field, String input){
        clickText.click();
        checkbox.click();
        field.clear();
        field.sendKeys(input);
        return this;
    }
    public UsersPage checkBoxes(WebElement clickElement, WebElement checkbox) {
        clickElement.click();
        checkbox.sendKeys("");
        return this;
    }
    public UsersPage generateUserFormat() {
        visibleUserFormat.click();
        String usersFormat = faker.options().option("F. Last name", "First name L.", "First name Last name",
                "Last name F.", "Last name First name", "Username");
        elementActions.input(userFormat, usersFormat);
        return this;
    }
    public UsersPage MoveToIcons(WebElement clickElement, WebElement icon) {
        clickElement.click();
        actions.moveToElement(icon).perform();
        return this;
    }

}

