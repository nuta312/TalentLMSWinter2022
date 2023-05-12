package com.digital.ui.pages;

import com.digital.config.ConfigReader;
import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * @author Adilet Kushubekov
 */
public class LoginPage extends BasePage{
    WebElementActions elementActions = new WebElementActions();

    @FindBy(name = "login")
    public WebElement login;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(name = "submit")
    public WebElement BtnLogin;

    public LoginPage openPage(){
        Driver.getDriver().get(ConfigReader.getProperty("applicationUrl"));
        return this;
    }
    public LoginPage authorization(){
        elementActions.input(login,ConfigReader.getProperty("login"))
                .input(password,ConfigReader.getProperty("password"));
        BtnLogin.click();
        return this;
    }
}


