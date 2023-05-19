package ui.login;

import com.digital.ui.data;
import com.digital.ui.driver.Driver;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class AddUserTest extends BaseUiTest{
    @BeforeClass
    public void beforeclass(){
        loginPage.openPage();
        loginPage.authorization();
    }
    @BeforeMethod
    public void setUp(){
        userPage.clickAddUserBtn();
            }
    @Test(priority = 1)
    @Description("first name input field")
    public void FirstNameInputField(){
        //addUserPage.FindAddUser();
        String name="Someone";
        webElementActions.input(addUserPage.firstname,name);
        Assert.assertEquals(addUserPage.firstname.getAttribute("value"),name);
        Assert.assertEquals(addUserPage.FirstNameInputFieldCounter.getText(),Integer.toString(50-name.length()));
        addUserPage.homeBtn.click();
    }
    @Test(priority = 2)
    @Description ("surname input field")
    public void SurNameInputField(){
        //addUserPage.ForSkippingProblem();
        String surname="Someone surname";
        webElementActions.input(addUserPage.surname,surname);
        Assert.assertEquals(addUserPage.surname.getAttribute("value"),surname);
        Assert.assertEquals(addUserPage.lastNameInputFieldCounter.getText(),Integer.toString(50-surname.length()));
        addUserPage.homeBtn.click();
    }
    @Test (priority = 3)
    @Description("email input field")
    public void ValidEmail(){
        //addUserPage.ForSkippingProblem();
        String email="email@gmailcom";
        String expectedInvalidEmail = "This is not a valid 'Email address'";
        webElementActions.input(addUserPage.email,email);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        addUserPage.submitAddUserBtn.click();
        String actualErrorEmailMessage=addUserPage.emailErrorMess.getText();
        Assert.assertEquals(addUserPage.emailAddressInputFieldCounter.getText(),Integer.toString(150-email.length()));
        Assert.assertEquals(actualErrorEmailMessage,expectedInvalidEmail);
        addUserPage.homeBtn.click();
    }
    @Test(priority = 5)
    @Description("password Field")
    public void PasswordField(){
        //addUserPage.ForSkippingProblem();
        String password="123456Ab";
        webElementActions.input(addUserPage.password,password);
        Assert.assertEquals(addUserPage.passwordInputFieldCounter.getText(),Integer.toString(30-password.length()));
        addUserPage.homeBtn.click();
    }
    @Test(priority = 4)
    @Description("usernameField")
    public void UsernameField(){
        //addUserPage.ForSkippingProblem();
        String username="SomeUserName";
        webElementActions.input(addUserPage.usernameInput,username);
        Assert.assertEquals(addUserPage.userNameInputFieldCounter.getText(),Integer.toString(150-username.length()));
        addUserPage.homeBtn.click();
    }
    @Test(priority = 6)
    @Description("upload")
    public void UploadPicture(){
        //addUserPage.ForSkippingProblem();
        Assert.assertTrue(addUserPage.uploadPicture.isDisplayed());
        addUserPage.homeBtn.click();
    }
    @Test(priority = 7)
    @Description("check whether user is added or not")
    public void addedUser(){
        String name = data.NAME.getUserInfo(), surname = data.SURNAME.getUserInfo(), email=data.EMAIL.getUserInfo(),password=data.PASSWORD.getUserInfo();
        addUserPage.inputName(name)
                .inputSurname(surname)
                .inputEmail(email)
                .inputPassword(password)
                .inputBio(data.BIO.getUserInfo())
                .inputLearnerType(data.LEARNERTYPE.getUserInfo())
                .inputTimezone(data.TIMEZONE.getUserInfo())
                .inputLanguage(data.LANGUAGE.getUserInfo())
                .inputCheckBox(data.CHECKBOXSTATUS.getUserInfo())
                //.uploadPic("C:\\Users\\user\\IdeaProjects\\TalentLMSWinter2022\\src\\test\\java\\ui\\users\\11.png")
                .inputSubmitUser();

        userPage.userslink.click();
        String usernameForLink = data.NAME.getUserInfo() + "." + data.SURNAME.getUserInfo();
        WebElement userlink = Driver.getDriver().findElement(By.xpath("//a [@data-original-title='Username: " + usernameForLink + "']"));
        Assert.assertTrue(userlink.isDisplayed());


    }
}
