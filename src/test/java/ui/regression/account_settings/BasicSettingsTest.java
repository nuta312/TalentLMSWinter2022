package ui.regression.account_settings;

import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.account_settings.BasicSettingsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicSettingsTest {
    BasicSettingsPage basicSettingsPage = new BasicSettingsPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    public void inputSiteNameTest(){
        basicSettingsPage.openPage();
        loginPage.authorization();
        homePage.goToHomePage()
                .clickToAccountSettings();
        basicSettingsPage.inputSiteName()
                .displayIconInfoText(basicSettingsPage.siteNameIconInfo);







    }


}
