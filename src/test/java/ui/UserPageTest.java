package ui;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.account_settings.UsersPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.digital.utils.FakeDataProvider.faker;
import static org.testng.Assert.*;

public class UserPageTest {
    WebElementActions elementActions = new WebElementActions();
    UsersPage usersPage = new UsersPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void setUp(){
        loginPage.openPage()
                .authorization();
        homePage.goToHomePage()
                .clickToAccountSettings();
        usersPage.openUsersPage();
    }
    @Test(description = "Verify user can open Users Page")
    public void testUsersPageLoad(){
        String expUrl = "https://bravos.talentlms.com/account/users_index";
        String actUrl = "https://bravos.talentlms.com/account/users_index";
        assertEquals(expUrl,actUrl);
    }
    @Test(description = "Verify all signUp options are available")
    public void testSingUpOption(){
        Select signUpDropdown = new Select(usersPage.signUp);
        List<WebElement> options = signUpDropdown.getOptions();
        assertEquals(options.get(0).getText(), "Direct");
        assertEquals(options.get(1).getText(), "Manually (from Admin)");
    }
    @Test(description = "Verify all User Verification options are available")
    public void testUserVerification(){
        Select userVerifDropDown = new Select(usersPage.userVerification);
        List<String> expUserVerifList = List.of("Select user verification", "CAPTCHA verification", "CAPTCHA + Email verification",
                 "Email verification", "CAPTCHA + Admin activation", "Admin activation");
        List<String> actUserVerifList = userVerifDropDown.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(actUserVerifList, expUserVerifList);
    }
    @Test(description = "Verify alert icon is visible next to User Verification menu")
    public void userVerifIconIsDisplayed(){
        assertTrue(usersPage.icon1.isDisplayed());
    }

    @Test(description = "Verify all Default User Type options are available")
    public void testDefUserType(){
        Select deftUserTypeDropDown = new Select(usersPage.defaultUserType);
        List<String> expDefUserTypeList = List.of("SuperAdmin", "Admin-Type", "Trainer-Type", "Learner-Type");
        List<String> actDefUserTypeList = deftUserTypeDropDown.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(actDefUserTypeList,expDefUserTypeList);
    }
    @Test(description = "Verify alert icon  is displayed next to Default User Type menu")
    public void defUserTypeIconIsDisplayed() {
        assertTrue(usersPage.icon2.isDisplayed());
    }
    @Test(description = "Verify Default Group menu is Displayed")
    public void TestDefaultGroup(){
        assertTrue(usersPage.defaultGroup.isDisplayed());
    }
    @Test(description = "Verify Password Settings is Enabled")
    public void testPasswordSettings(){
        assertTrue(usersPage.passwordSettings.isEnabled());
    }
    @Test(description = "Verify Enforce strong passwords is Selected")
    public void testStrongPasswordBox(){
        usersPage.passwordSettings.click();
        usersPage.strongPasswordBox.click();
        assertTrue(usersPage.strongPasswordBox.isSelected());
    }
   @Test(description = "Verify Enforce passwords change is Selected")
   public void testPasswordChangeDays() {
       usersPage.passwordSettings.click();
       usersPage.passwordChangeXDaysBox.click();
       assertTrue(usersPage.passwordChangeXDaysBox.isSelected());
   }
   @Test(description = "Verify User is able input number days")
   public void  testInputDays(){
       usersPage.passwordSettings.click();
       usersPage.passwordChangeXDaysBox.click();
       usersPage.passwordDays.clear();
       usersPage.passwordDays.sendKeys("20");
       String day = usersPage.passwordDays.getAttribute("value");
       assertEquals(day, "20");
   }
    @Test(description = "Verify Enforce passwords change on first login is Selected")
    public void testSPasswordChangeLoginBox(){
        usersPage.passwordSettings.click();
        usersPage.passwordChangeBox.click();
        assertTrue(usersPage.passwordChangeBox.isSelected());
    }
    @Test(description = "Verify Lock account after is Selected")
    public void testLockAccountAfter() {
        usersPage.passwordSettings.click();
        usersPage.lockLoginBox.click();
        assertTrue(usersPage.lockLoginBox.isSelected());
    }
    @Test(description = "Verify User is able input number of failed attempts")
    public void testInputFailedAttempts(){
        usersPage.passwordSettings.click();
        usersPage.lockLoginBox.click();
        usersPage.retryAttempts.clear();
        usersPage.retryAttempts.sendKeys("5");
        String attempts = usersPage.retryAttempts.getAttribute("value");
        assertEquals(attempts, "5");
    }
    @Test(description = "Verify User is able input number of minutes")
    public void testInputMinutes(){
        usersPage.passwordSettings.click();
        usersPage.lockLoginBox.click();
        usersPage.retryMinutes.clear();
        usersPage.retryMinutes.sendKeys("10");
        String minutes = usersPage.retryMinutes.getAttribute("value");
        assertEquals(minutes, "10");
    }
    @Test(description = "Verify Terms of Service is Enabled")
    public void testTermsOfService(){
        assertTrue(usersPage.termsOfService.isEnabled());
    }
    @Test(description = "Verify User is able input some text inside Terms of service textarea and checkbox is deselected")
    public void testInputTextArea(){
        usersPage.generateLicenceNote();
        assertNotNull(usersPage.licenceNote);
        assertFalse(usersPage.resetLicenceBox.isSelected());
    }
    @Test(description = "Verify all Visible User Format options are available")
    public void testVisibleUserFormat(){
        usersPage.visibleUserFormat.click();
        Select visibleUserFormatDropDown = new Select(usersPage.userFormat);
        List<String> expvisibleUserFormatList = List.of("F. Last name", "First name L.", "First name Last name",
                "Last name F.","Last name First name", "Username");
        List<String> actvisibleUserFormatList = visibleUserFormatDropDown.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(actvisibleUserFormatList,expvisibleUserFormatList);
    }
    @Test(description = "Verify Social options checkboxes are Selected")
    public void testSocialOptions(){
        usersPage.socialOptions.click();
        List<WebElement> checkboxList = List.of(usersPage.socialSignUpBox, usersPage.socialCatalogBox, usersPage.socialShareBox, usersPage.courseRatingBox);
        for (WebElement checkbox : checkboxList){
            checkbox.click();
            assertTrue(checkbox.isSelected());
        }
    }
    @Test(description = "Verify Single Sign-On text is Displayed")
    public void testSSO(){
        assertTrue(usersPage.singleSignOn.isDisplayed());
    }
    @Test(description = "Verify save button is Enabled")
        public void testSaveBtn(){
            assertTrue(usersPage.saveBtn.isEnabled());
    }
    @Test(description = "Verify cancel click is Enabled")
    public void testCancelClick(){
        assertTrue(usersPage.cancelClick.isEnabled());
    }
    @AfterMethod
    public void tearDown(){
        Driver.getDriver().close();
        Driver.getDriver().quit();
    }
}
