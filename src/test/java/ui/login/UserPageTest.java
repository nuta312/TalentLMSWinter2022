package ui.login;

import com.digital.ui.data;
import com.digital.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserPageTest extends BaseUiTest{
    @Test
    public void username() {
        userPage.users();
        WebElement username = Driver.getDriver().findElement(By.xpath("//input [@name='name']"));
        Assert.assertEquals(data.NAME.getUserInfo(),username.getAttribute("value"));
        Assert.assertTrue(username.isDisplayed());
    }
    @Test
    public void userSurname() {
        userPage.users();
        WebElement usersurname = Driver.getDriver().findElement(By.xpath("//input [@name='surname']"));
        Assert.assertEquals(data.SURNAME.getUserInfo(),usersurname.getAttribute("value"));
        Assert.assertTrue(usersurname.isDisplayed());
    }
    @Test
    public void useremail() {
        userPage.users();
        WebElement useremail = Driver.getDriver().findElement(By.xpath("//input [@name='email']"));
        Assert.assertTrue(useremail.isDisplayed());
        Assert.assertEquals(data.EMAIL.getUserInfo(), useremail.getAttribute("value"));
    }
    @Test
    public void Usertype(){
        userPage.users();
        WebElement usertype=Driver.getDriver().findElement(By.xpath("//select[@name='acl_user_type_id']"));
        Select select=new Select(usertype);
        Assert.assertTrue(select.isMultiple());
        Assert.assertTrue(usertype.isDisplayed());
    }
    @Test public void userCheckboxActive(){
        userPage.users();
        WebElement checkbox=Driver.getDriver().findElement(By.xpath("//input[@ name='status']"));
        Assert.assertTrue(checkbox.isSelected());
        Assert.assertTrue(checkbox.isDisplayed());
    }
}
