package com.digital.ui.pages;

import static com.digital.config.ConfigReader.getProperty;
import com.digital.ui.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(name = "login")
    public WebElement login;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(name = "submit")
    public WebElement btnLogin;


    public LoginPage openPage(){
        Driver.getDriver().get(getProperty("applicationUrl2"));
        return this;
    }

    public LoginPage authorization(){
        elementActions.input(login, getProperty("login"))
                .input(password, getProperty("password"));
        btnLogin.click();
        return this;
    }

//    public LoginPage closePage(){
//        Driver.closeDriver();
//        return this;
//    }
}