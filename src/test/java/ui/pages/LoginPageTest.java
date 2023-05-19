package ui.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseUiTest{
    @Test
    public void loginTest(){
        loginPage.openPage();
        loginPage.authorization();
        Assert.assertEquals(driver.getTitle(),"nna | Home");
    }
}
