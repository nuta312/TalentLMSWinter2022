package ui.regression.account_settings;

import com.digital.annotations.TestCase;
import com.digital.ui.driver.Driver;;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseUiTest;

import static com.digital.enums.ValueForBasicSettingsPage.*;

/**
 * @author Adilet Kushubekov
 */
public class BasicSettingsTest extends BaseUiTest {

    @Test(priority = 1, description = "Automation of basic settings page")
    public void inputSiteNameTest() {

        basicSettingsPage
                .inputSiteName()
                .displayIconInfoText(basicSettingsPage.siteNameIconInfo)
                .inputSiteDescription()
                .displayIconInfoText(basicSettingsPage.siteDescriptionIconInfo)
                .uploadLogo("TalentLMSWinter2022\\src\\main\\resources\\logo.png")
                .uploadFavicon("C:\\Users\\Admin\\Desktop\\favicon.png")
                .selectFromDropDownMenu(basicSettingsPage.dropDownLanguage)
                .searchAndSelectLanguage()
                .addOverride()
                .selectFromDropDownMenu(basicSettingsPage.dropDownTimeZone)
                .searchAndSelectTimeZone()
                .selectFromDropDownMenu(basicSettingsPage.dropDownDateFormat)
                .selectFromDropDownMenu(basicSettingsPage.dropDownDateFormat)
                .selectFromDropDownMenu(basicSettingsPage.dropDownTimeFormat)
                .selectFromDropDownMenu(basicSettingsPage.dropDownCurrency)
                .inputInternalAnnouncement()
                .displayIconInfoText(basicSettingsPage.internalAnnouncementIconInfo)
                .inputExternalAnnouncement()
                .resizeInputField(basicSettingsPage.internalAnnouncement, 200, 70)
                .displayIconInfoText(basicSettingsPage.externalAnnouncementIconInfo)
                .resizeInputField(basicSettingsPage.externalAnnouncement, 200, 70)
                .checkCheckbox(basicSettingsPage.checkboxEnableApi)
                .refreshApiKey()
                .checkCheckbox(basicSettingsPage.checkboxEnableXApi)
                .checkCheckbox(basicSettingsPage.checkboxExternalLrs);
        elementActions
                .input(basicSettingsPage.inputXApiEndpoint, "https://demoqa.com")
                .input(basicSettingsPage.inputXApiKey, "abcdef12345")
                .input(basicSettingsPage.inputXApiSecret, "kolbasa");
        basicSettingsPage
                .checkCheckbox(basicSettingsPage.checkboxRestrictRegistration)
                .inputDomainToRestrictRegistration()
                .checkCheckbox(basicSettingsPage.checkboxDisallowMultipleLogins)
                .checkCheckbox(basicSettingsPage.checkboxDisallowMobileApp)
                .checkCheckbox(basicSettingsPage.checkboxIntercomIdentityVerification);
        elementActions
                .input(basicSettingsPage.inputIntercomSecretKey, "SuperSecretKey");
        basicSettingsPage
                .checkCheckbox(basicSettingsPage.checkboxDisableVideoTranscoding)
                .checkCheckbox(basicSettingsPage.checkboxVideoWatermark)
                .checkCheckbox(basicSettingsPage.checkboxUseDocumentsViewer)
                .checkCheckbox(basicSettingsPage.checkboxLoadInFrame)
                .checkCheckbox(basicSettingsPage.checkboxLockSystem)
                .inputLockSystemMessage()
                .checkCheckbox(basicSettingsPage.checkboxHideFromSearchEngines)
                .checkCheckbox(basicSettingsPage.checkboxExternalCatalog)
                .checkCheckbox(basicSettingsPage.checkboxShowBranchCourses)
                .checkCheckbox(basicSettingsPage.checkboxShowCourseInfoPage)
                .selectConferenceType()
                .checkCheckbox(basicSettingsPage.checkboxBambooHR)
                .checkCheckbox(basicSettingsPage.checkboxInactiveUsers);
        elementActions
                .input(basicSettingsPage.inputSubdomain, "winter2022");
        basicSettingsPage
                .addCustomCourseFields()

                .clickBtnSave();

    }

    @Test(priority = 2, description = "Go to the Basic settings page")
    @TestCase(id = 10001)
    @Severity(SeverityLevel.BLOCKER)
    public void openBasicSettingsPageTest() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), URL.getValue());
    }

    @Test(priority = 3, description = "Changing the site name. And the field counter will decrease according to the number of characters entered")
    @TestCase(id = 10002)
    @Severity(SeverityLevel.MINOR)
    public void inputSiteNameTest1() {
        Assert.assertEquals(Driver.getDriver().getTitle().substring(0, basicSettingsPage.siteName.getAttribute("value").length()),
                basicSettingsPage.siteName.getAttribute("value"));
        Assert.assertEquals(basicSettingsPage.siteNameCounter.getText(),
                basicSettingsPage.remainderCounter(basicSettingsPage.siteName));
    }

    @Test(priority = 4, description = "Displaying a hint when hovering over the information icon.")
    @TestCase(id = 10003)
    @Severity(SeverityLevel.TRIVIAL)
    public void iconInfoTest() {
        Assert.assertNotNull(basicSettingsPage.siteNameIconInfo
                .findElement(By.xpath("//div[@class='tl-tooltip-content']")).getText());
    }

    @Test(priority = 5, description = "Changing the site description.")
    @TestCase(id = 10004)
    @Severity(SeverityLevel.MINOR)
    public void inputSiteDescriptionTest() {
        Assert.assertEquals(basicSettingsPage.siteDescription.getAttribute("value"), DESCRIPTION.getValue());
    }

    @Test(priority = 6, description = "Checking uploading a logo")
    @TestCase(id = 10005)
    @Severity(SeverityLevel.MINOR)
    public void logoUploadTest() {
        Assert.assertTrue(basicSettingsPage.logoRedactor.getAttribute("src").endsWith(LOGO.getValue()));
    }

    @Test(priority = 7, description = "Checking uploading a favicon")
    @TestCase(id = 10006)
    @Severity(SeverityLevel.MINOR)
    public void faviconUploadTest() {
        Assert.assertTrue(basicSettingsPage.faviconRedactor.getAttribute("src").endsWith(FAVICON.getValue()));
    }

    @Test(priority = 8, description = "Verify the language displayed on the page matches the default language.")
    @TestCase(id = 10007)
    @Severity(SeverityLevel.CRITICAL)
    public void selectDefaultLangugeTest() {
        Assert.assertTrue(basicSettingsPage.defaultLanguageChosen.getText().contains("Russian"));
    }

    @Test(priority = 9, description = "Verify the time displayed on the page matches the default time zone.")
    @TestCase(id = 10008)
    @Severity(SeverityLevel.CRITICAL)
    public void selectDefaultTimeZoneTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='s2id_default_timezone']/a/span[1]"))
                .getText().contains("London"));
    }

    @Test(priority = 10, description = "Verify the date format selected by the user is set.")
    @TestCase(id = 10009)
    @Severity(SeverityLevel.MINOR)
    public void selectDateFormatTest() {
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='select2-container tl-select2']/a/span)[5]"))
                .getText(), DateFormat.getValue());
    }

    @Test(priority = 11, description = "Verify the time format selected by the user is set.")
    @TestCase(id = 10010)
    @Severity(SeverityLevel.MINOR)
    public void selectTimeFormatTest() {
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='select2-container tl-select2']/a/span)[7]"))
                .getText(), TimeFormat.getValue());
    }

    @Test(priority = 12, description = "Verify the currency selected by the user is set.")
    @TestCase(id = 10011)
    @Severity(SeverityLevel.BLOCKER)
    public void selectCurrencyTest() {
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='select2-container tl-select2']/a/span)[9]"))
                .getText().contains(CURRENCY.getValue()));
    }

    @Test(priority = 13, description = "Verify the internal announcement is displayed")
    @TestCase(id = 10012)
    @Severity(SeverityLevel.MINOR)
    public void inputInternalAnnouncementTest() {
        basicSettingsPage.removeCheckbox(basicSettingsPage.checkboxLockSystem).clickBtnSave();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-info fade in out']/p")).getText(),
                basicSettingsPage.internalAnnouncement.getText());
        basicSettingsPage.checkCheckbox(basicSettingsPage.checkboxLockSystem).clickBtnSave();

    }

    @Test(priority = 14, description = "Verify the external announcement is displayed")
    @TestCase(id = 10013)
    @Severity(SeverityLevel.BLOCKER)
    public void inputExternalAnnouncementTest() {
        basicSettingsPage.linkToLogout.click();
        Assert.assertEquals(basicSettingsPage.externalAnnouncementResult.getText(), ExternalAnnouncement.getValue());
        loginPage.authorization();
        homePage.goToHomePage().clickToAccountSettings();
    }

    @Test(priority = 15, description = "Verify the api is enabled and the api key is displayed")
    @TestCase(id = 10014)
    @Severity(SeverityLevel.CRITICAL)
    public void enableApiTest() {
        Assert.assertNotNull(basicSettingsPage.apiKey.getAttribute("value"));
    }

    @Test(priority = 16, description = "Verify the xAPI is enabled and the xAPI key is displayed")
    @TestCase(id = 10015)
    @Severity(SeverityLevel.CRITICAL)
    public void enableXApiTest() {
        Assert.assertNotNull(basicSettingsPage.xApiKey.getAttribute("value"));
    }

    @Test(priority = 17, description = "Make sure that after checking a checkbox on Push api statements, " +
            "the fields for entering api endpoint, api key, api secret appear and work correctly.")
    @TestCase(id = 10016)
    @Severity(SeverityLevel.CRITICAL)
    public void inputDataToExternalLRSTest() {
        Assert.assertEquals(basicSettingsPage.inputXApiEndpoint.getAttribute("value"), "https://demoqa.com/");
        Assert.assertEquals(basicSettingsPage.inputXApiKey.getAttribute("value"), "abcdef12345");
        Assert.assertEquals(basicSettingsPage.inputXApiSecret.getAttribute("value"), "kolbasa");
    }

    @Test(priority = 18, description = "Make sure that after checking a checkbox on Restrict registration, " +
            "a field for entering domains appears.")
    @TestCase(id = 10017)
    @Severity(SeverityLevel.MINOR)
    public void inputDomainsToRestrictRegistrationTest() {
        Assert.assertEquals(basicSettingsPage.inputDomainToRestrictRegistration.getAttribute("value"),
                "~mail.ru,~hotmail.com,~bk.ru,~yahoo.com");
    }

    @Test(priority = 19, description = "Make sure that after checking a checkbox on Intercom identity verification, " +
            "a field for entering secret key appears.")
    @TestCase(id = 10018)
    @Severity(SeverityLevel.MINOR)
    public void inputIntercomSecretKeyTest() {
        Assert.assertEquals(basicSettingsPage.inputIntercomSecretKey.getAttribute("value"),
                "SuperSecretKey");
    }

    @Test(priority = 20, description = "Verify the lock system message is displayed")
    @TestCase(id = 10019)
    @Severity(SeverityLevel.CRITICAL)
    public void lockSystemTest() {
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-info fade in out']/h4/i")).getAttribute("title"),
                basicSettingsPage.inputLockSystemMessage.getText());
    }

    @Test(priority = 21, description = "Verify you can select the type of conference in the dropdown menu " +
            "and specify the maximum capacity of participants in the lower field.")
    @TestCase(id = 10020)
    @Severity(SeverityLevel.CRITICAL)
    public void selectConferenceTypeTest() {
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='s2id_conference_mode']/a/span[1]")).getText(), "Zoom Webinar");
        Assert.assertNotNull(basicSettingsPage.inputMaxCapacity.getAttribute("value"));
    }

    @Test(priority = 22, description = "Verify after enabling BambooHR integration, the subdomain input field appears.")
    @TestCase(id = 10021)
    @Severity(SeverityLevel.MINOR)
    public void inputSubdomainBambooHRTest() {
        Assert.assertEquals(basicSettingsPage.inputSubdomain.getAttribute("value"), "winter2022");
    }

    @Test(priority = 23, description = "Verify a field with the dropdown type has been added in the custom source fields section.")
    @TestCase(id = 10022)
    @Severity(SeverityLevel.MINOR)
    public void addCustomCourseFieldsTest() {
        basicSettingsPage.linkToCustomCourseFields.click();
        Assert.assertNotNull(basicSettingsPage.customCourseFieldName.getText());
        Assert.assertEquals(basicSettingsPage.customCourseFieldType.getText(), "DROPDOWN");
    }


}