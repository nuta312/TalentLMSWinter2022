package com.digital.ui.pages;

import com.digital.config.ConfigReader;
import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
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
        Driver.getDriver().get(ConfigReader.getProperty("applicationUrl2"));
        return this;
    }

    public LoginPage authorization(){
        elementActions.input(login,ConfigReader.getProperty("login"))
                .input(password,ConfigReader.getProperty("password"));
        btnLogin.click();
        return this;
    }

    public LoginPage closePage(){
        Driver.closeDriver();
        return this;
    }
}