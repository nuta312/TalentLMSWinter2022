package ui.pages;
import com.digital.ui.data;
import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class UserPageTest extends BaseUiTest{
    @BeforeClass
    public void beforeclass(){
        loginPage.openPage();
        loginPage.authorization();
    }
    @BeforeMethod
    public void setUp(){
        userPage.userslink.click();
        String usernameForLink = data.NAME.getUserInfo() + "." + data.SURNAME.getUserInfo();
        WebElement userlink = Driver.getDriver().findElement(By.xpath("//a [@data-original-title='Username: " + usernameForLink + "']"));
        userlink.click();
    }
    @Test(description = "opens users page and check user's name which was registered earlier")
    public void username() {

        WebElement username = Driver.getDriver().findElement(By.xpath("//input [@name='name']"));
        Assert.assertEquals(data.NAME.getUserInfo(),username.getAttribute("value"));
        Assert.assertTrue(username.isDisplayed());
        addUserPage.homeBtn.click();
    }
    @Test(description = "opens users page and check user's surname which was registered earlier")
    public void userSurname() {
        WebElement usersurname = Driver.getDriver().findElement(By.xpath("//input [@name='surname']"));
        Assert.assertEquals(data.SURNAME.getUserInfo(),usersurname.getAttribute("value"));
        Assert.assertTrue(usersurname.isDisplayed());
        addUserPage.homeBtn.click();
    }
    @Test(description = "opens users page and check user's email which was registered earlier")
    public void useremail() {
        WebElement useremail = Driver.getDriver().findElement(By.xpath("//input [@name='email']"));
        Assert.assertTrue(useremail.isDisplayed());
        Assert.assertEquals(data.EMAIL.getUserInfo(), useremail.getAttribute("value"));
        addUserPage.homeBtn.click();
    }
    @Test
    public void Usertype(){

        WebElement usertype=Driver.getDriver().findElement(By.xpath("//select[@name='acl_user_type_id']"));
        Select select=new Select(usertype);
        //Assert.assertTrue(select.isMultiple());
        Assert.assertTrue(usertype.isDisplayed());
        addUserPage.homeBtn.click();
    }
    @Test (description = "check for checkbox")
    public void userCheckboxActive(){

        WebElement checkbox=Driver.getDriver().findElement(By.xpath("//input[@ name='status']"));
        Assert.assertTrue(checkbox.isSelected());
        Assert.assertTrue(checkbox.isDisplayed());
        addUserPage.homeBtn.click();
    }

}
