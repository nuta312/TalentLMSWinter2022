package com.digital.ui.pages.account_settings;


import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.BasePage;;
import com.digital.utils.FakeDataProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * @author Adilet Kushubekov
 */
public class BasicSettingsPage extends BasePage{
    WebElementActions elementActions = new WebElementActions();
    Actions actions = new Actions(Driver.getDriver());

    @FindBy(xpath = "//input[@name='site_name']")
    public WebElement siteName;
    @FindBy(xpath = "(//span[@class='add-on'])[1]")
    public WebElement siteNameCounter;
    @FindBy(xpath = "//div[@id='site_name_tour_position']")
    public WebElement siteNameIconInfo;
    @FindBy(xpath = "//div[contains(text(),'title of your site')]")
    public WebElement siteNameInfoText;
    @FindBy(xpath = "//input[@name='site_description']")
    public WebElement siteDescription;
    @FindBy(xpath = "(//span[@class='add-on'])[2]")
    public WebElement siteDescriptionCounter;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[2]")
    public WebElement siteDescriptionIconInfo;
    @FindBy(xpath = "//div[contains(text(),'Briefly')]")
    public WebElement siteDescriptionInfoText;

    public BasicSettingsPage inputSiteName(){
        siteName.clear();
        elementActions.input(this.siteName, FakeDataProvider.generateSiteName());
        return this;
    }
//    //TODO
//    public String remainderCounter(WebElement element){
//        int count = Integer.parseInt(element.getText()) - element.getText().length();
//        String result = "" + count.;
//        return result;
//    }
    public BasicSettingsPage displayIconInfoText(WebElement element){
        actions.moveToElement(element).perform();
        return this;
    }



    public BasicSettingsPage openPage(){
        Driver.getDriver().get("https://winter2022.talentlms.com/dashboard");
        return this;
    }
    public BasicSettingsPage closePage(){
        Driver.closeDriver();
        return this;
    }



}
