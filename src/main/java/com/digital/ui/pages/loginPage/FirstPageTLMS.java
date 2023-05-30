package com.digital.ui.pages.loginPage;

import com.digital.ui.driver.Driver;
import com.digital.ui.pages.basePage.BasePage;
import com.digital.ui.pages.usersHP.userPage.UsersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPageTLMS extends BasePage {

    @FindBy(xpath = "//input[@name='login']")
    public WebElement inputLoginOnFirstPage;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPasswordOnFirstPage;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement btnLogin;

    public FirstPageTLMS login(String login, String password){
        webElementActions.input(inputLoginOnFirstPage,login);
        webElementActions.input(inputPasswordOnFirstPage,password);
        webElementActions.press(btnLogin);
        return this;
    }
    public UsersPage goToUserPage(){
        Driver.getDriver().navigate().to("https://nuta1bema.talentlms.com/user/index");
        final UsersPage usersPage = new UsersPage();
        return usersPage;
    }
}
