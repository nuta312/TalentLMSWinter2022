package ui.account_settingsTest;

import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.account_settings.DomainPage;
import org.testng.annotations.Test;

public class DomainPageTest {

    DomainPage domainPage = new DomainPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    /**
     * author Asel Asankozhoeva
     */


    @Test(priority = 1)
    public void openFormPage(){
        loginPage.open("https://asel0205.talentlms.com/index");
        loginPage.authorization();
        homePage.goToHomePage();
    }
    @Test(priority = 2, description = "Verify Account and Settings Page")
    public void accountAndSettingsPage() {
        domainPage.accountAndSettingsPage();
    }
    @Test(priority = 3, description = "Verify Domain Page")
     public void clickDomainPage() throws InterruptedException {
        domainPage.inputDomainName();
    }
}
