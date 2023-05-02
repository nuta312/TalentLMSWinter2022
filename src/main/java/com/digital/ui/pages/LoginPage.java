package com.digital.ui.pages;

import com.digital.config.ConfigReader;
<<<<<<< HEAD
=======
import com.digital.ui.driver.Driver;
>>>>>>> origin/AigerimDzh
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

<<<<<<< HEAD

=======
>>>>>>> origin/AigerimDzh
    WebElementActions elementActions = new WebElementActions();

    @FindBy(name = "login")
    public WebElement login;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(name = "submit")
    public WebElement BtnLogin;

<<<<<<< HEAD

    public LoginPage authorization() {
        elementActions.input(login, ConfigReader.getProperty("login"))
                .input(password, ConfigReader.getProperty("password"));
        BtnLogin.click();
        return this;

    }
}
=======
    public LoginPage openPage(){
        Driver.getDriver().get(ConfigReader.getProperty("applicationUrl"));
        return this;
    }
    public LoginPage authorization(){
        elementActions.input(login, ConfigReader.getProperty("login"))
                .input(password,ConfigReader.getProperty("password"));
        BtnLogin.click();
        return this;
    }
}
>>>>>>> origin/AigerimDzh
