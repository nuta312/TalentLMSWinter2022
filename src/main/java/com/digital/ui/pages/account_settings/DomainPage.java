package com.digital.ui.pages.account_settings;

import com.digital.config.ConfigReader;
import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DomainPage {
    private WebElementActions elementActions = new WebElementActions();
    public DomainPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * author Asel Asankozhoeva
     */

    @FindBy(name = "login")
    public WebElement login;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(name = "submit")
    public WebElement BtnLogin;
    @FindBy(xpath = "//a[@class='brand']")
    public WebElement talentLmsHomePageLink;
    @FindBy(xpath = "(//div[@class='tl-bold-link'])[10]")
    public WebElement accountAndSettings;
    @FindBy(xpath = "//a[contains(text(), 'Domain')]")
    public WebElement clickDomainPage;
    @FindBy(name = "domain_name")
    public WebElement domainName;
    @FindBy(xpath = "//input[@value= 'Change domain name']")
    public WebElement changeDomainName;


    public DomainPage authorization(){
        elementActions.input(login, ConfigReader.getProperty("login"))
                .input(password,ConfigReader.getProperty("password"));
        BtnLogin.click();
        talentLmsHomePageLink.click();
        return this;
    }

    public DomainPage accountAndSettingsPage() {
        accountAndSettings.click();
        clickDomainPage.click();
        return this;
    }

    public DomainPage inputDomainName() throws InterruptedException {
        clickDomainPage.click();
        domainName.clear();
        domainName.sendKeys("asel0205");
        changeDomainName.click();
        Thread.sleep(3000);
        Driver.closeDriver();
        return this;
    }
}


