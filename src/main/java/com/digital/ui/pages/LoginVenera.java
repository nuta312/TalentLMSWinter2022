package com.digital.ui.pages;
import com.digital.config.ConfigReader;
import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginVenera  extends BasePage{
    WebElementActions elementActions = new WebElementActions();

    @FindBy(name = "login")
    public WebElement login;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(name = "submit")
    public WebElement BtnLogin;

    public LoginVenera  openPage() {
        Driver.getDriver().get("https://venera.talentlms.com/index");
        return this;
    }

    public LoginVenera authorization() throws InterruptedException {
        elementActions.input(login, ConfigReader.getProperty("login"))
                .input(password,ConfigReader.getProperty("password"));
        Thread.sleep(1000);
        BtnLogin.click();
        return this;
    }
}
