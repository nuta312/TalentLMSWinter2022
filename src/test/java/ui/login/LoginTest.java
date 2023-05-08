package ui.login;
import com.digital.ui.data;
import com.digital.ui.driver.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseUiTest{
    @Test
    public void Loginfirstpage() {
        Driver.getDriver().navigate().to(data.URL.getUserInfo());
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals(title, "TalentLMS: Cloud LMS Software - #1 Online Learning Platform");
    }
    @Test
    public void Link(){
        loginPage.login();
        loginPage.Loginpress();
        String title=Driver.getDriver().getTitle();
        Assert.assertEquals(title,"Log in to Your TalentLMS Account - Online LMS Platform - TalentLMS");
    }
    @Test
    public void Homepage(){
        loginPage.login();
        loginPage.Loginpress();
        loginPage.Loginentering();
        loginPage.Loginchoice();
        Assert.assertEquals(Driver.getDriver().getTitle(),"nna | Home");
    }


}
