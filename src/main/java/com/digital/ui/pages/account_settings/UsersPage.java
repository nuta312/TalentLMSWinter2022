package com.digital.ui.pages.account_settings;


import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author Bakai Saitkulov
 */

public class UsersPage {

   private WebElementActions elementActions = new WebElementActions();
   Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());

   public UsersPage(){
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
   @FindBy(xpath = "//span[@class='add-on textarea-countdown']")
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
    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement cancelClick;

    @FindBy(xpath = "//i[@title='Log out']")
    public WebElement logOutBtn;

   public UsersPage openUsersPage(){
       usersPage.click();
       return this;
   }
   public UsersPage generateSignUpOption(){
        String  userSignUp = faker.options().option("Direct", "Manually (from Admin)");
        elementActions.input(signUp,userSignUp);
        return this;
    }
    //TODO Modify Method to generate other options than "Select user verification"
    public UsersPage generateUserVerificationOption(){
        String signUpOption = generateSignUpOption().toString();
        if (signUpOption.equals("Direct")){
            String usersVerification = faker.options().option("Select user verification", "CAPTCHA verification", "CAPTCHA + Email verification",
                    "CAPTCHA + Admin activation", "Admin Activation");
            elementActions.input(userVerification, usersVerification);
            actions.moveToElement(icon1).perform();
        }
        return this;
    }
    public UsersPage generateDefaultUserTypeOption(){
       String defaultUsersType = faker.options().option("Learner-Type", "SuperAdmin", "Admin-Type", "Trainer-Type");
       elementActions.input(defaultUserType,defaultUsersType);
       actions.moveToElement(icon2).perform();
       return this;
    }
    public UsersPage navigateToDefaultGroup(){
       defaultGroup.sendKeys("");
       actions.moveToElement(icon3).perform();
       return this;
    }
    //TODO Make sure below method run correctly
    public UsersPage checkStrongPassword() {
       passwordSettings.click();
       strongPasswordBox.sendKeys("");
       actions.moveToElement(icon4).perform();
       return this;
    }
    public UsersPage checkPasswordChangeDays() {
       passwordChangeXDaysBox.click();
       passwordDays.clear();
       String afterDays = String.valueOf(faker.number().numberBetween(1,360));
       elementActions.input(passwordDays, afterDays);
       return this;
    }
    public UsersPage checkPasswordChange(){
       passwordChangeBox.click();
       actions.moveToElement(icon5).perform();
       return this;
    }
    public UsersPage checkLockLogin(){
       lockLoginBox.click();
       retryAttempts.clear();
       String attempts = String.valueOf(faker.number().numberBetween(1,10));
       elementActions.input(retryAttempts,attempts);
       retryMinutes.clear();
       String minutes = String.valueOf(faker.number().numberBetween(1,10));
       elementActions.input(retryMinutes,minutes);
       actions.moveToElement(icon6).perform();
       return this;
    }
    //TODO crosscheck is there a need to modify below method
    public UsersPage generateLicenceNote(){
       termsOfService.click();
       String note = faker.lorem().fixedString(3500);
       elementActions.input(licenceNote,note);
       if (resetLicenceBox.isSelected()){
           resetLicenceBox.click();
       }
    return this;
    }
    public UsersPage generateUserFormat(){
       visibleUserFormat.click();
       String usersFormat = faker.options().option("F. Last name", "First name L.", "First name Last name",
               "Last name F.","Last name First name", "Username");
       elementActions.input(userFormat,usersFormat);
       return this;
    }
    public UsersPage scrollDownPage(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }
    public UsersPage checkSocialOptions(){
       socialOptions.click();
       socialSignUpBox.click();
       actions.moveToElement(icon6).perform();
       socialCatalogBox.click();
       actions.moveToElement(icon7).perform();
       socialShareBox.click();
       actions.moveToElement(icon8).perform();
       courseRatingBox.click();
       actions.moveToElement(icon9).perform();
       return this;
    }
    public UsersPage checkSingleSignOn(){
       actions.moveToElement(singleSignOn);
       return this;
    }
    //TODO Mention about saveBtn Feature
    public UsersPage checkSaveBtn(){
       if (saveBtn.isEnabled()){
           saveBtn.click();
       }
       return this;
    }
    public UsersPage checkCancelClick(){
       if (cancelClick.isEnabled()){
           cancelClick.click();
       }
       return this ;
    }
    public UsersPage logOut(){
       logOutBtn.click();
       return this;
    }
}
