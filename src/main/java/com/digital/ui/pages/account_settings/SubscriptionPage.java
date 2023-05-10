package com.digital.ui.pages.account_settings;

import com.digital.config.ConfigReader;
import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SubscriptionPage {
    private WebElementActions elementActions = new WebElementActions();

    public SubscriptionPage() {

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
    @FindBy(xpath = "//a[contains(text(), 'Subscription')]")
    public WebElement clickSubscription;
    @FindBy(xpath = "//div[@class= 'select2-container tl-select2 plan-filter'][1]")
    public WebElement dropAndDownPlanType;
    @FindBy(xpath = "//div[@class= 'select2-container tl-select2 plan-filter']")
    public WebElement includeTalentLibrary;
    @FindBy(xpath = "//div[@class= 'select2-container tl-select2 plan-filter']")
    public WebElement billed;
    @FindBy(xpath = "//a[@class= 'btn'][1]")
    public WebElement clickBillingHistory;
    @FindBy(xpath = "//a[@id= 'tl-toggle-update-billing-address']")
    public WebElement clickUpdate;
    @FindBy(xpath = "//select[@id= 'customer_country']")
    public WebElement billingAddress;
    @FindBy(xpath = "//input[@name='customer_address']")
    public WebElement inputCustomerAddress;
    @FindBy(xpath = "//input[@name='customer_city']")
    public WebElement inputCustomerCity;
    @FindBy(xpath = "//input[@name='customer_zip']")
    public WebElement inputCustomerZip;
    @FindBy(xpath = "//a[@id='tl-toggle-customer-company']")
    public WebElement clickText;
    @FindBy(xpath = "//input[@name='customer_name']")
    public WebElement inputCompanyName;
    @FindBy(xpath = "//input[@name='customer_taxid']")
    public WebElement inputTaxId;
    @FindBy(xpath = "//input[@name='tl-submit-new-billing-address']")
    public WebElement clickUpdateBtn;


    public SubscriptionPage authorization(){
        elementActions.input(login, ConfigReader.getProperty("login"))
                .input(password,ConfigReader.getProperty("password"));
        BtnLogin.click();
        talentLmsHomePageLink.click();
        return this;
    }


    public SubscriptionPage accountAndSettingsPage() {
        accountAndSettings.click();
        clickSubscription.click();
        return this;
    }

    public SubscriptionPage subscriptionPage() {
        elementActions.waitElementToBeClickAble(dropAndDownPlanType);
        elementActions.waitElementToBeClickAble(includeTalentLibrary);
        elementActions.waitElementToBeClickAble(billed);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,500)");
        clickBillingHistory.click();
        return this;
    }

    public SubscriptionPage updateBilling(String address, String city, int ZIP, String companyName, int Id) {
        clickUpdate.click();
        WebElement country = Driver.getDriver().findElement(By.id("customer_country"));
        Select select = new Select(country);
        select.selectByValue("KG");
        inputCustomerAddress.sendKeys(address);
        inputCustomerCity.sendKeys(city);
        inputCustomerZip.sendKeys("720005");
        clickText.click();
        inputCompanyName.sendKeys(companyName);
        inputTaxId.sendKeys("123456789");
        clickUpdateBtn.click();
        return this;
    }

    public void updateBilling() {
    }
}
