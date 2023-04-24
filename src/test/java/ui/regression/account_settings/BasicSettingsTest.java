package ui.regression.account_settings;

import com.digital.annotations.TestCase;
import com.digital.ui.driver.Driver;
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.account_settings.BasicSettingsPage;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * @author Adilet Kushubekov
 */
public class BasicSettingsTest {
    BasicSettingsPage basicSettingsPage = new BasicSettingsPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    @BeforeMethod
    public void goToBasicSettingsPage(){
        loginPage.openPage()
                .authorization();
        homePage.goToHomePage()
                .clickToAccountSettings();

    }

    @Test
    public void inputSiteNameTest() throws InterruptedException {

        basicSettingsPage.inputSiteName()
                .displayIconInfoText(basicSettingsPage.siteNameIconInfo)
                .inputSiteDescription()
                .displayIconInfoText(basicSettingsPage.siteDescriptionIconInfo)
                .uploadLogo("C:\\Users\\Admin\\Desktop\\images.png")
                .selectFromDropDownMenu(basicSettingsPage.dropDownLanguage)
                .searchAndSelectLanguage()
                .addOverride()
                .selectFromDropDownMenu(basicSettingsPage.dropDownTimeZone)
                .searchAndSelectTimeZone()
                .scrollDown()
                .selectFromDropDownMenu(basicSettingsPage.dropDownDateFormat)
                .selectFromDropDownMenu(basicSettingsPage.dropDownDateFormat)
                .selectFromDropDownMenu(basicSettingsPage.dropDownTimeFormat)
                .selectFromDropDownMenu(basicSettingsPage.dropDownCurrency)
                .inputInternalAnnouncement()
                .displayIconInfoText(basicSettingsPage.internalAnnouncementIconInfo)
                .inputExternalAnnouncement()
                .resizeInputField(basicSettingsPage.internalAnnouncement,200, 70)
                .displayIconInfoText(basicSettingsPage.externalAnnouncementIconInfo)
                .resizeInputField(basicSettingsPage.externalAnnouncement,200, 70)
                .checkCheckbox(basicSettingsPage.checkboxEnableApi)
                .refreshApiKey()
                .clickBtnSave();

        Assert.assertNotNull(basicSettingsPage.siteNameIconInfo.findElement(By.xpath("//div[@class='tl-tooltip-content']")).getText());


        String[] expectedResult = {"https://winter2022.talentlms.com/account/basic_index",
                basicSettingsPage.siteName.getAttribute("value"),
                basicSettingsPage.remainderCounter(basicSettingsPage.siteName),
        };
        int count = 0;
        for (Map.Entry<String, String> actualResult : basicSettingsPage.resultSettings().entrySet()) {
            Assert.assertEquals(actualResult.getValue(), expectedResult[count]);
            count++;
        }

        @Test(description = "Verify user can login with valid credentials")
        @TestCase(id = 123)
//        @Severity(SeverityLevel.BLOCKER)
//        @Owner("Nursultan")
//        @Story("As a user i should be able to login")
//        @Link(name = "requirements",url = "https://www.google.com/")
    }

}