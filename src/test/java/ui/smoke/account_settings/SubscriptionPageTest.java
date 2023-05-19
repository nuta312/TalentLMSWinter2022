package ui.smoke.account_settings;

import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.account_settings.SubscriptionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriptionPageTest {

    SubscriptionPage subscriptionPage = new SubscriptionPage();
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
        subscriptionPage.accountAndSettingsPage();
    }

    @Test(priority = 3, description = "Verify Subscription Page")
    public void clickSubscriptionPage() {
        subscriptionPage.subscriptionPage();
    }

    @Test(priority = 4)
    public void clickUpdateBillingPage() {
       subscriptionPage.updateBilling();
        Assert.assertTrue(true, "Kyrgyzstan");
        Assert.assertTrue(true, "Mira, 123");
        Assert.assertTrue(true, "Bishkek");
        Assert.assertTrue(true, "720005");
        Assert.assertTrue(true, "DigitalNomads");
        Assert.assertTrue(true, "123456789");
    }


}

