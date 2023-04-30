package ui;

import com.digital.ui.driver.Driver;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.account_settings.UsersPage;
import org.openqa.selenium.By;
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

    @Test(priority = 1)
    public void setUp(){
        loginPage.openPage()
                .authorization();
        homePage.goToHomePage()
                .clickToAccountSettings();
        usersPage.usersPage.click();
    }
    @Test(priority = 2, description = "Verify user can open Users Page")
    public void testUsersPageLoad(){
        String expUrl = "https://bravos.talentlms.com/account/users_index";
        String actUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(actUrl,expUrl);
    }
    @Test(priority = 3, description = "Verify all signUp options are available")
    public void testSingUpOption(){
        Select signUpDropdown = new Select(usersPage.signUp);
        List<WebElement> options = signUpDropdown.getOptions();
        assertEquals(options.get(0).getText(), "Direct");
        assertEquals(options.get(1).getText(), "Manually (from Admin)");
    }
    @Test(priority = 4, description = "Verify all Default User Type options are available")
    public void testUserVerification(){
        Select userVerDropDown = new Select(usersPage.userVerification);
        List<String> expUserVerList = List.of("Select user verification", "CAPTCHA verification", "CAPTCHA + Email verification",
                "Email verification", "CAPTCHA + Admin activation", "Admin activation");
        List<String> actUserVerList = userVerDropDown.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(actUserVerList,expUserVerList);
    }
    @Test(priority = 5, description = "Verify all Default User Type options are available")
    public void testDefUserType(){
        Select deftUserTypeDropDown = new Select(usersPage.defaultUserType);
        List<String> expDefUserTypeList = List.of("SuperAdmin", "Admin-Type", "Trainer-Type", "Learner-Type");
        List<String> actDefUserTypeList = deftUserTypeDropDown.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(actDefUserTypeList,expDefUserTypeList);
    }

    @Test(priority = 6, description = "Verify all checkboxes are selectable")
    public void testCheckboxes(){
        usersPage.checkBoxes(usersPage.passwordSettings, usersPage.passwordChangeBox);
        assertFalse(usersPage.passwordChangeBox.isSelected());
    }
    @Test(priority = 7, description = "Verify all icon messages are Displayed")
    public void testIcons(){
        usersPage.MoveToIcons(usersPage.socialOptions,usersPage.icon10);
        assertTrue(usersPage.icon10.isDisplayed());
    }
   @Test(priority = 8, description = "Verify User is able enter data in input fields")
   public void  testInputFields(){
       usersPage.inputFields(usersPage.passwordSettings, usersPage.passwordChangeXDaysBox,usersPage.passwordDays ,"20");
       String day = usersPage.passwordDays.getAttribute("value");
       assertEquals(day, "20");
   }
    @Test(priority = 9, description = "Verify all Visible User Format options are available")
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
    @Test(priority = 10, description = "Verify user can enter text and check the countdown")
    public void checkTextArea(){
        usersPage.termsOfService.click();
        elementActions.input(usersPage.licenceNote, "Hello World");
        WebElementActions.pause(1000);
        String initialCount = "35000";
        String updatedCount = usersPage.countdown.getText();
        assertNotEquals(initialCount,updatedCount);
    }
    @Test(priority = 11, description = "Verify success message is Displayed")
    public void testSuccessMessage(){
        WebElementActions.pause(1000);
        usersPage.saveBtn.click();
        WebElementActions.pause(1000);
        assertTrue(usersPage.successMessage.isDisplayed());
    }
    @Test(priority = 12)
    public void tearDown(){
        Driver.getDriver().close();
        Driver.getDriver().quit();
    }
}
