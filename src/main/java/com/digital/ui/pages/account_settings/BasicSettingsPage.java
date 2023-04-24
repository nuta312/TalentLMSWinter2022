package com.digital.ui.pages.account_settings;


import com.digital.config.ConfigReader;
import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.BasePage;;
import com.digital.utils.FakeDataProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.digital.enums.Cars.AUDI;

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
    @FindBy(xpath = "(//span[@class='preview'])[1]")
    public WebElement selectLogo1;
    @FindBy(xpath = "//a[text()='Select logo']")
    public WebElement selectLogo2;
    @FindBy(xpath = "(//i[@class='icon-trash invisible'])[1]")
    public WebElement trashLogo;
    @FindBy(xpath = "(//div[@class='jcrop-tracker'])[1]")
    public WebElement logoCursorMove1;
    @FindBy(xpath = "(//div[@class='ord-se jcrop-handle'])[1]")
    public WebElement logoCursorMove2;
    @FindBy(xpath = "(//button[text()='Change image'])[1]")
    public WebElement btnChangeImageLogo;
    @FindBy(xpath = "(//button[text()='Apply'])[1]")
    public WebElement btnApplyLogo;
    @FindBy(xpath = "(//span[@class='preview'])[2]")
    public WebElement selectFavicon1;
    @FindBy(xpath = "(//a[text()='Select favicon']")
    public WebElement selectFavicon2;
    @FindBy(xpath = "(//i[@class='icon-trash invisible'])[2]")
    public WebElement trashFavicon;
    @FindBy(xpath = "(//div[@class='jcrop-tracker'])[3]")
    public WebElement FaviconCursorMove1;
    @FindBy(xpath = "(//div[@class='ord-s jcrop-handle'])[2]")
    public WebElement faviconCursorMove2;
    @FindBy(xpath = "(//button[text()='Change image'])[2]")
    public WebElement btnChangeImageFavicon;
    @FindBy(xpath = "(//button[text()='Apply'])[2]")
    public WebElement btnApplyFavicon;
    @FindBy(id = "s2id_default_language")
    public WebElement defaultLanguage;
    @FindBy(xpath = "//select[@id='default_language']")
    public WebElement dropDownLanguage;
    @FindBy(xpath = "(//input[@class='select2-input select2-focused'])[1]")
    public WebElement searchLanguage;
    @FindBy(xpath = "//i[@id='tl-show-language-overrides']")
    public WebElement overrides;
    @FindBy(xpath = "//a[@id='add-language-override-button']")
    public WebElement btnAddOverride1;
    @FindBy(xpath = "(//input[@name='submit_override'])[1]")
    public WebElement btnAddOverride2;
    @FindBy(xpath = "(//a[text()='cancel'])[2]")
    public WebElement cancelOverrides;
    @FindBy(xpath = "(//textarea[@name='original'])[1]")
    public WebElement inputOriginal;
    @FindBy(xpath = "(//textarea[@name='overridden'])[1]")
    public WebElement inputOverridden;
    @FindBy(xpath = "(//a[@class='close'])[1]")
    public WebElement closeOverridesWindow;
    @FindBy(xpath = "//th[@class='tl-align-left sorting_asc']")
    public WebElement sortByOriginal;
    @FindBy(xpath = "//th[@class='tl-align-left hidden-phone sorting']")
    public WebElement sortByOverride;
    @FindBy(xpath = "(//i[@alt='Edit'])[1]")
    public WebElement editOverride;
    @FindBy(xpath = "(//i[@alt='Delete'])[1]")
    public WebElement deleteOverride;
    @FindBy(xpath = "//a[@class='dt-button']")
    public WebElement btnDownloadOverrides;
    @FindBy(xpath = "(//textarea[@name='original'])[2]")
    public WebElement inputOriginalToUpdate;
    @FindBy(xpath = "(//textarea[@name='overridden'])[2]")
    public WebElement inputOverriddenToUpdate;
    @FindBy(xpath = "(//input[@name='submit_override'])[2]")
    public WebElement btnUpdateOverride;
    @FindBy(xpath = "(//a[text()='cancel'])[3]")
    public WebElement cancelEditOverrides;
    @FindBy(id = "s2id_default_timezone")
    public WebElement defaultTimeZone;
    @FindBy(xpath = "//select[@id='default_timezone']")
    public WebElement dropDownTimeZone;
    @FindBy(xpath = "(//input[@class='select2-input select2-focused'])[1]")
    public WebElement searchTimeZone;
    @FindBy(xpath = "//select[@name='date_format']")
    public WebElement dropDownDateFormat;
    @FindBy(xpath = "//select[@name='time_format']")
    public WebElement dropDownTimeFormat;
    @FindBy(xpath = "//select[@name='currency']")
    public WebElement dropDownCurrency;
    @FindBy(xpath = "//a[text()='Internal']")
    public WebElement linkToInternalAnnouncement;
    @FindBy(xpath = "//textarea[@name='announcement']")
    public WebElement internalAnnouncement;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[3]")
    public WebElement internalAnnouncementIconInfo;
    @FindBy(xpath = "(//span[@class='add-on textarea-countdown'])[1]")
    public WebElement internalAnnouncementCounter;
    @FindBy(xpath = "//a[text()='External']")
    public WebElement linkToExternalAnnouncement;
    @FindBy(xpath = "//textarea[@name='external_announcement']")
    public WebElement externalAnnouncement;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[4]")
    public WebElement externalAnnouncementIconInfo;
    @FindBy(xpath = "(//span[@class='add-on textarea-countdown'])[2]")
    public WebElement externalAnnouncementCounter;
    @FindBy(xpath = "//a[@class='dt-button']")
    public WebElement overridesDownloadBtn;
    @FindBy(xpath = "//input[@class='tl-grid-search-input']")
    public WebElement searchOverrides;
    @FindBy(xpath = " tl-align-center tl-table-operations-cell")
    public WebElement overridesTable;
    @FindBy(xpath = "//input[@id='api']")
    public WebElement checkboxEnableApi;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[5]")
    public WebElement checkboxApiIconInfo;
    @FindBy(xpath = "//i[@title='Refresh API key']")
    public WebElement btnRefreshApiKey;
    @FindBy(id = "tl-confirm-submit")
    public WebElement btnRefresh;
    @FindBy(xpath = "(//a[@class='btn'])[2]")
    public WebElement btnRefreshCancel;
    @FindBy(xpath = "//a[text()='Download API documentation and PHP library']")
    public WebElement linkToDownloadApi;




    @FindBy(xpath = "//input[@value='Save']")
    public WebElement btnSave;









    public BasicSettingsPage inputSiteName(){
        siteName.clear();
        elementActions.input(this.siteName, FakeDataProvider.generateSiteName());
        return this;
    }
    public String remainderCounter(WebElement element){
        int count = Integer.parseInt(element.getAttribute("data-maxchars")) - element.getAttribute("value").length();
        String result = "" + count;
        return result;
    }
    public BasicSettingsPage displayIconInfoText(WebElement element){
        actions.moveToElement(element).perform();
        return this;
    }
    public BasicSettingsPage inputSiteDescription(){
        siteDescription.clear();
        elementActions.input(this.siteDescription, ConfigReader.getProperty("siteDescription"));
        return this;
    }
    public BasicSettingsPage uploadLogo(String filePath) throws InterruptedException {
        selectLogo1.sendKeys(filePath);
        elementActions.waitElementToBeDisplayed(selectLogo1);

//        actions.click(trashLogo);
//        selectLogo2.sendKeys(filePath);
//        actions.clickAndHold(logoCursorMove2)
//                .moveByOffset(-12, -25)
//                .release()
//                .perform();
//        btnChangeImageLogo.sendKeys(filePath);
//        btnApplyLogo.click();
        return this;
    }
    public BasicSettingsPage selectFromDropDownMenu(WebElement element){
        List<WebElement> list = element.findElements(By.tagName("option"));
        int randomIndex = new Random().nextInt(list.size());
        Select select = new Select(element);
        select.selectByIndex(randomIndex);
        return this;
    }
    public BasicSettingsPage searchAndSelectLanguage(){
        List<String> listOfLanguage = List.of("English", "Russian", "Deutsch");
        int randomIndex = new Random().nextInt(listOfLanguage.size());
        defaultLanguage.click();
        elementActions.input(searchLanguage, listOfLanguage.get(randomIndex));
        searchLanguage.sendKeys(Keys.ENTER);
        return this;
    }
    public BasicSettingsPage addOverride(){
        elementActions.press(overrides)
                .press(btnAddOverride1)
                .input(inputOriginal, FakeDataProvider.generateOverriddenLanguage())
                .input(inputOverridden, FakeDataProvider.generateOverriddenLanguage());
        resizeInputField(inputOriginal,150,70);
        resizeInputField(inputOverridden,150,70);
        elementActions.press(btnAddOverride2)
                .press(btnAddOverride1);
        JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
        executor.executeScript("arguments[0].click();", cancelOverrides);
        elementActions.press(closeOverridesWindow);
        return this;
    }
//    public BasicSettingsPage openEditForm(String fileName) {
//        try {
//            WebElement pickFile = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + fileName + "')]"));
//            elementActions.waitElementToBeDisplayed(pickFile);
//            actions.moveToElement(pickFile).perform();
//
//            WebElement editBtn = Driver.getDriver().findElement(By.xpath("//tr[contains(., '" + fileName + "')]//i[contains(@alt,'Edit')]"));
//            elementActions.waitElementToBeDisplayed(editBtn);
//
//            actions.moveToElement(editBtn).click().perform();
//
//            return this;
//        } catch (NoSuchElementException e) {
//            System.out.println("Такого файла не найдено");
//            return null;
//        }
//    }
    public BasicSettingsPage searchAndSelectTimeZone(){
        List<String> listOfTimeZone = List.of("Astana", "Moscow", "London", "Paris", "Berlin");
        int randomIndex = new Random().nextInt(listOfTimeZone.size());
        defaultTimeZone.click();
        elementActions.input(searchTimeZone, listOfTimeZone.get(randomIndex));
        searchTimeZone.sendKeys(Keys.ENTER);
        return this;
    }
    public BasicSettingsPage scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,500)");
        return this;
    }
    public BasicSettingsPage inputInternalAnnouncement(){
        linkToInternalAnnouncement.click();
        internalAnnouncement.clear();
        elementActions.input(this.internalAnnouncement, FakeDataProvider.generateAnyText());
        return this;
    }
    public BasicSettingsPage resizeInputField(WebElement element, int width, int height) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'width:" + width + "px;height:" + height + "px;')", element);
        return this;
    }

    public BasicSettingsPage inputExternalAnnouncement(){
        linkToExternalAnnouncement.click();
        externalAnnouncement.clear();
        elementActions.input(this.externalAnnouncement, FakeDataProvider.generateAnyText());
        return this;
    }
    public BasicSettingsPage checkCheckbox(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
        return this;
    }
    public BasicSettingsPage refreshApiKey(){
        elementActions.press(btnRefreshApiKey)
                .press(btnRefresh)
                .press(linkToDownloadApi);
        return this;
    }
    public BasicSettingsPage clickBtnSave(){
        btnSave.click();
        return this;
    }



    public Map<String, String> resultSettings() {
        List<String> keys = List.of("Account settings URL", "Site name", "Site name counter");
        List<String> value = List.of(Driver.getDriver().getCurrentUrl(),
                Driver.getDriver().getTitle().substring(0,siteName.getAttribute("value").length()),
                siteNameCounter.getText()
                );
        LinkedHashMap<String, String> resultSettings = new LinkedHashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            resultSettings.put(keys.get(i), value.get(i));
        }
        return resultSettings;
    }

    public BasicSettingsPage closePage(){
        Driver.closeDriver();
        return this;
    }

}
