package com.digital.ui.pages.account_settings;


import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.BasePage;
import com.digital.utils.FakeDataProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Adilet Kushubekov
 */
public class BasicSettingsPage extends BasePage {
    WebElementActions elementActions = new WebElementActions();

    @FindBy(xpath = "//input[@name='site_name']")
    public WebElement siteName;
    @FindBy(xpath = "(//span[@class='add-on'])[1]")
    public WebElement siteNameCounter;
    @FindBy(xpath = "//div[@id='site_name_tour_position']")
    public WebElement siteNameIconInfo;
    @FindBy(xpath = "//div[contains(text(),'title of your site')]")
    public WebElement siteNameInfoText;

    public BasicSettingsPage inputSiteName(){
        elementActions.input(this.siteName, FakeDataProvider.generateSiteName());
        return this;
    }


}
