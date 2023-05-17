package com.digital.ui.pages.UserPage;

import com.digital.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewUser extends BasePage {

    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement inputFieldFirstName;

    @FindBy(xpath = "(//span[@class='add-on'])[1]")
    public WebElement counterFieldName;

    @FindBy(xpath = "//input[@name='surname']")
    public WebElement inputLastName;

    @FindBy(xpath = "(//span[@class='add-on'])[2]")
    public WebElement counterFieldLastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement inputFieldEmail;

    @FindBy(xpath = "(//span[@class='add-on'])[3]")
    public WebElement counterFieldEmail;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement inputFieldLogin;

    @FindBy(xpath = "(//span[@class='add-on'])[4]")
    public WebElement counterFieldLogin;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputFieldPassword;

    @FindBy(xpath = "//span[@class='add-on'])[5]")
    public WebElement counterFieldPassword;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement inputFieldBio;

    @FindBy(xpath = "(//span[@class='add-on textarea-countdown'])")
    public WebElement counterFieldBio;

    @FindBy(xpath = "//select[@name='acl_user_type_id']")
    public WebElement selectUserType;

    @FindBy(xpath = "//select[@name='timezone']")
    public WebElement selectTimeZone;

    @FindBy(xpath = "//select[@name='Language']")
    public WebElement selectLanguage;

    @FindBy(xpath = "//input[@name='Language']")
    public WebElement checkBoxStatusActive;

    @FindBy(xpath = "//input[@name='deactivate_user']")
    public WebElement checkBoxStatusDeactive;

    @FindBy(xpath = "//input[@name='restrict_email']")
    public WebElement checkBoxExcludeFromEmail;

    @FindBy(xpath = "//input[@name='submit_personal_details']")
    public WebElement addUserBtn;

    @FindBy(xpath = "//a[contains(@class,'btn btn-primary dropdown-toggle')]")
    public WebElement addAnotherArrow;

    @FindBy(xpath = "//a[contains(text(),'Add user and add another')]")
    public WebElement addAnotherBtn;

    @FindBy(xpath = "//a[text()='Upload profile pic']")
    public WebElement uploadtTextBtn;

    @FindBy(xpath = "//img[@class = 'image80x80']")
    public WebElement uploadPicBtn;

    @FindBy(xpath = "//a[contains(text(),'cancel')]")
    public WebElement cancel;












}
