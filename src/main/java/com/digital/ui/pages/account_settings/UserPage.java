package com.digital.ui.pages.account_settings;


import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Bakai Saitkulov
 */

public class UserPage {

   private WebElementActions elementActions = new WebElementActions();

   public UserPage(){
       PageFactory.initElements(Driver.getDriver(), this);
   }

   @FindBy(xpath = "//select[@name='signup']")
    public WebElement signUp;

   @FindBy(xpath = "//select[@name='verification']")
   public WebElement userVerification;

   @FindBy(xpath = "//select[@name='default_type']")
    public WebElement defaultUserType;

   @FindBy(xpath = "//select[@name='default_group']")
    public WebElement defaultGroup;

   @FindBy(xpath = "//a[text()='Password settings']")
    public WebElement passwordSettings;



}
