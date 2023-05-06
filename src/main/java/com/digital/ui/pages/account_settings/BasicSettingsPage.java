package com.digital.ui.pages.account_settings;



import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.BasePage;
import com.digital.utils.FakeDataProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import java.io.File;
import java.util.List;
import java.util.Random;
import static com.digital.enums.ValueForBasicSettingsPage.DESCRIPTION;
import static com.digital.enums.ValueForBasicSettingsPage.ExternalAnnouncement;

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
    @FindBy(xpath = "//input[@name='logo_uploader']")
    public WebElement selectLogo1;
    @FindBy(xpath = "(//img[@alt='Avatar'])[1]")
    public WebElement logoRedactor;
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
    @FindBy(xpath = "(//img[@alt='Avatar'])[2]")
    public WebElement faviconRedactor;
    @FindBy(xpath = "//input[@name='favicon_uploader']")
    public WebElement selectFavicon;
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
    @FindBy(xpath = "//div[@id='s2id_default_language']//a//span[1]")
    public WebElement defaultLanguageChosen;
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
    @FindBy(xpath = "//div[@id='tl-language-overrides-modal']//a[@class='close']")
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
    @FindBy(xpath = "(//div[@class='input-append tl-countdown'])[3]/span")
    public WebElement internalAnnouncementCounter;
    @FindBy(xpath = "//a[text()='External']")
    public WebElement linkToExternalAnnouncement;
    @FindBy(xpath = "//textarea[@name='external_announcement']")
    public WebElement externalAnnouncement;
    @FindBy(xpath = "//div[@class='hero-unit tl-external-announcement tl-auth-form-box']/div")
    public WebElement externalAnnouncementResult;
    @FindBy(xpath = "(//div[@class='tl-js-tooltip-trigger'])[4]")
    public WebElement externalAnnouncementIconInfo;
    @FindBy(xpath = "(//span[@class='add-on textarea-countdown'])[2]")
    public WebElement externalAnnouncementCounter;
    @FindBy(xpath = "(//a[@id='navbar-logout'])[2]")
    public WebElement linkToLogout;
    @FindBy(xpath = "//a[@class='dt-button']")
    public WebElement overridesDownloadBtn;
    @FindBy(xpath = "//input[@class='tl-grid-search-input']")
    public WebElement searchOverrides;
    @FindBy(xpath = " tl-align-center tl-table-operations-cell")
    public WebElement overridesTable;
    @FindBy(xpath = "//input[@id='api']")
    public WebElement checkboxEnableApi;
    @FindBy(xpath = "//input[@id='api_key']")
    public WebElement apiKey;
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
    @FindBy(xpath = "//input[@id='tincan_api']")
    public WebElement checkboxEnableXApi;
    @FindBy(xpath = "//input[@id='tincan_api_key']")
    public WebElement xApiKey;
    @FindBy(xpath = "//i[@title='Refresh xAPI key']")
    public WebElement btnRefreshXApiKey;
    @FindBy(xpath = "//a[text()='Download API documentation']")
    public WebElement linkToDownloadApiX;
    @FindBy(xpath = "//input[@id='external_lrs']")
    public WebElement checkboxExternalLrs;
    @FindBy(xpath = "//input[@id='external_lrs_endpoint']")
    public WebElement inputXApiEndpoint;
    @FindBy(xpath = "//span[@id='counter-external_lrs_endpoint']")
    public WebElement xApiEndpointCounter;
    @FindBy(xpath = "//input[@id='external_lrs_key']")
    public WebElement inputXApiKey;
    @FindBy(xpath = "//span[@id='counter-external_lrs_key']")
    public WebElement xApiKeyCounter;
    @FindBy(xpath = "//input[@id='external_lrs_secret']")
    public WebElement inputXApiSecret;
    @FindBy(xpath = "//span[@id='counter-external_lrs_secret']")
    public WebElement xApiSecretCounter;
    @FindBy(xpath = "//input[@id='registration_restriction']")
    public WebElement checkboxRestrictRegistration;
    @FindBy(xpath = "//input[@id='registration_email_restriction']")
    public WebElement inputDomainToRestrictRegistration;
    @FindBy(xpath = "//span[@id='counter-registration_email_restriction']")
    public WebElement RestrictRegistrationCounter;
    @FindBy(xpath = "//input[@name='disallow_multiple_logins']")
    public WebElement checkboxDisallowMultipleLogins;
    @FindBy(xpath = "//input[@name='disallow_mobile_app']")
    public WebElement checkboxDisallowMobileApp;
    @FindBy(xpath = "//input[@name='intercom_identity_verification']")
    public WebElement checkboxIntercomIdentityVerification;
    @FindBy(xpath = "//input[@id='intercom_secret_key']")
    public WebElement inputIntercomSecretKey;
    @FindBy(xpath = "//span[@id='counter-intercom_secret_key']")
    public WebElement intercomSecretKeyCounter;
    @FindBy(xpath = "//input[@name='disable_video_transcoding']")
    public WebElement checkboxDisableVideoTranscoding;
    @FindBy(xpath = "//input[@name='video_watermark']")
    public WebElement checkboxVideoWatermark;
    @FindBy(xpath = "//input[@name='use_documents_viewer']")
    public WebElement checkboxUseDocumentsViewer;
    @FindBy(xpath = "//input[@name='load_in_frame']")
    public WebElement checkboxLoadInFrame;
    @FindBy(xpath = "//input[@name='lock_system']")
    public WebElement checkboxLockSystem;
    @FindBy(xpath = "//textarea[@name='lock_system_message']")
    public WebElement inputLockSystemMessage;
    @FindBy(xpath = "(//span[@class='add-on textarea-countdown'])[3]")
    public WebElement LockSystemMessageCounter;
    @FindBy(xpath = "//input[@name='hide_from_search_engines']")
    public WebElement checkboxHideFromSearchEngines;
    @FindBy(xpath = "//input[@name='external_catalog']")
    public WebElement checkboxExternalCatalog;
    @FindBy(xpath = "//input[@name='show_branch_courses_in_main_catalog']")
    public WebElement checkboxShowBranchCourses;
    @FindBy(xpath = "//input[@name='show_course_info_page']")
    public WebElement checkboxShowCourseInfoPage;
    @FindBy(id = "s2id_conference_mode")
    public WebElement conferenceType;
    @FindBy(xpath = "//select[@name='conference_mode']")
    public WebElement dropDownConferenceType;
    @FindBy(xpath = "//input[@name='conference_max_users']")
    public WebElement inputMaxCapacity;
    @FindBy(xpath = "//input[@name='bamboohr']")
    public WebElement checkboxBambooHR;
    @FindBy(xpath = "//input[@name='bamboohr_import_users_as_inactive']")
    public WebElement checkboxInactiveUsers;
    @FindBy(xpath = "//input[@name='bamboohr_domain']")
    public WebElement inputSubdomain;
    @FindBy(xpath = "//a[@id='show-course-fields']")
    public WebElement linkToCustomCourseFields;
    @FindBy(xpath = "//a[@id='add-course-field-button']")
    public WebElement btnAddField;
    @FindBy(xpath = "//input[@name='submit_field']")
    public WebElement btnAddField2;
    @FindBy(xpath = "//input[@id='tl-custom-field-name']")
    public WebElement inputAddFieldName;
    @FindBy(xpath = "//span[@id='counter-tl-custom-field-name']")
    public WebElement addFieldNameCounter;
    @FindBy(xpath = "//select[@id='tl-custom-field-type']")
    public WebElement dropDownAddFieldType;
    @FindBy(xpath = "//div[@id='s2id_tl-custom-field-type']//span[@class='select2-chosen']")
    public WebElement dropDownSelectChosen ;
    @FindBy(xpath = "//input[@name='dropdown_values']")
    public WebElement dropdownItems;
    @FindBy(xpath = "//div[@class='select2-result-label']")
    public WebElement dropdownItemsAddOption;
    @FindBy(xpath = "(//i[@style='margin-bottom:2px'])[3]")
    public WebElement btnEditDropdownX;
    @FindBy(xpath = "//input[@name='mandatory']")
    public WebElement checkboxMandatory;
    @FindBy(xpath = "//input[@name='visible_on_reports']")
    public WebElement checkboxVisibleOnReports;
    @FindBy(xpath = "//input[@name='visible_to_learners']")
    public WebElement checkboxVisibleToLearners;
    @FindBy(xpath = "//a[@data-dismiss='modal'][text()='cancel']")
    public WebElement linkToCancel;
    @FindBy(xpath = "//i[@alt='Edit']")
    public WebElement btnEditCustomCourseFields;
    @FindBy(xpath = "//i[@alt='Delete']")
    public WebElement btnDeleteCustomCourseFields;
    @FindBy(xpath = "//i[@class='icon-download tl-icon19']")
    public WebElement iconDownloadCustomCourseFields;
    @FindBy(xpath = "//input[@value='Update field']")
    public WebElement btnUpdateField;
    @FindBy(xpath = "//a[@id='tl-confirm-submit']")
    public WebElement btnDeleteField;
    @FindBy(xpath = "(//a[@data-dismiss='modal'][text()='Cancel'])[1]")
    public WebElement btnCancelField;
    @FindBy(xpath = "//a[@class='tl-operation-edit-course-field']/span")
    public WebElement customCourseFieldName;
    @FindBy(xpath = "//td[@class=' tl-align-center hidden-phone']/span")
    public WebElement customCourseFieldType;
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
        elementActions.input(this.siteDescription, DESCRIPTION.getValue());
        return this;
    }
    public BasicSettingsPage uploadLogo(String filePath) {
        selectLogo1.sendKeys(filePath);
        actions.click(trashLogo);
        selectLogo1.sendKeys(filePath);
        elementActions.waitElementToBeDisplayed(logoCursorMove1);
        actions.clickAndHold(logoCursorMove1)
                .moveByOffset(50, 50)
                .release()
                .perform();
        btnApplyLogo.click();
        return this;
    }
    public BasicSettingsPage uploadFavicon(String filePath) {
        selectFavicon.sendKeys(filePath);
        actions.click(trashFavicon);
        selectFavicon.sendKeys(filePath);
        elementActions.waitElementToBeDisplayed(FaviconCursorMove1);
        btnApplyFavicon.click();
        return this;
    }
    public BasicSettingsPage selectFromDropDownMenu(WebElement element){
        List<WebElement> list = element.findElements(By.tagName("option"));
        int randomIndex = new Random().nextInt(list.size());
        Select select = new Select(element);
        select.selectByIndex(1);
        return this;
    }
    public BasicSettingsPage searchAndSelectLanguage(){
        List<String> listOfLanguage = List.of("English", "Deutsch", "Russian");
        int randomIndex = new Random().nextInt(listOfLanguage.size());
        defaultLanguage.click();
        elementActions.input(searchLanguage, listOfLanguage.get(2));
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

    public BasicSettingsPage searchAndSelectTimeZone(){
        List<String> listOfTimeZone = List.of("Astana", "Moscow", "London", "Paris", "Berlin");
        int randomIndex = new Random().nextInt(listOfTimeZone.size());
        defaultTimeZone.click();
        elementActions.input(searchTimeZone, listOfTimeZone.get(2));
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
        elementActions.input(this.externalAnnouncement, ExternalAnnouncement.getValue());
        return this;
    }
    public BasicSettingsPage checkCheckbox(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
        return this;
    }
    public BasicSettingsPage removeCheckbox(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
        return this;
    }
    public BasicSettingsPage refreshApiKey(){
        elementActions.press(btnRefreshApiKey)
                .press(btnRefresh);
//                .press(linkToDownloadApi);
        return this;
    }
    public BasicSettingsPage refreshXApiKey(){
        elementActions.press(btnRefreshXApiKey)
                .press(btnRefresh);
//                .press(linkToDownloadApi);
        return this;
    }

    public BasicSettingsPage inputDomainToRestrictRegistration(){
        elementActions.input(inputDomainToRestrictRegistration,"~mail.ru,~hotmail.com,~bk.ru,~yahoo.com");
        return this;
    }
    public BasicSettingsPage inputLockSystemMessage() {
        inputLockSystemMessage.clear();
        elementActions.input(this.inputLockSystemMessage, "The system is currently locked");
        return this;
    }
    public BasicSettingsPage selectConferenceType(){
        List<WebElement> list = dropDownConferenceType.findElements(By.tagName("option"));
        int randomIndex = new Random().nextInt(list.size());
        Select select = new Select(dropDownConferenceType);
        select.selectByIndex(2);
        int randomCapacity = new Random().nextInt(500);
        elementActions.input(inputMaxCapacity,randomCapacity + "");
        return this;
    }
    public BasicSettingsPage addCustomCourseFields(){
        JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
        executor.executeScript("arguments[0].click();", btnAddField);
        elementActions.input(inputAddFieldName, FakeDataProvider.generateCountry());
        checkCheckbox(checkboxMandatory);
        checkCheckbox(checkboxVisibleOnReports);
        checkCheckbox(checkboxVisibleToLearners);
        selectFromDropDownMenu(dropDownAddFieldType);
        elementActions.waitElementToBeClickAble(checkboxMandatory);
        if (dropDownSelectChosen.getText().equals("Dropdown")){
            elementActions.input(dropdownItems, FakeDataProvider.generateCountry());
            dropdownItems.sendKeys(Keys.ENTER);
        }
        btnAddField2.click();
        return this;
    }

    public BasicSettingsPage clickBtnSave(){
        btnSave.click();
        return this;
    }
    public BasicSettingsPage closePage(){
        Driver.closeDriver();
        return this;
    }


}
