package ui.smoke.account_settings;

import com.digital.annotations.TestCase;
import com.digital.ui.element_helper.WebElementActions;
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.account_settings.E_CommercePage;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ECommercePageTest {
    WebElementActions elementActions = new WebElementActions();
    E_CommercePage e_commercePage = new E_CommercePage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test(priority = 1)
    public void setUp() {
        loginPage.openPage()
                .authorization();
        homePage.clickToAccountSettings();
        e_commercePage.e_commerce.click();
    }

    @Test(priority = 2, description = "Verify user can choose processor from given options")
    public void chooseProcessorTest() {
        elementActions.pressDownAndEnter(e_commercePage.processor);
        Select select = new Select(e_commercePage.processor);
        List<WebElement> options = select.getOptions();
        elementActions.press(e_commercePage.paypal)
                .input(e_commercePage.paypalEmail, "aiperi@gmail.com");
        String actualEmailPayPal = e_commercePage.paypalEmail.getAttribute("value");
        assertEquals(options.get(1).getText(), "PayPal");
        assertEquals(actualEmailPayPal, "aiperi@gmail.com");
        assertEquals(options.get(2).getText(), "Stripe");
    }

    @Test(priority = 3, description = "Verify Subscription is clickable")
    public void subscriptionTitleTest() {
        assertEquals(e_commercePage.subscription.getText(), "Subscription");
    }

    @Test(priority = 4, description = "Verify user can click check-box  and input percentage of discount")
    @TestCase(id = 4)
    @Severity(SeverityLevel.NORMAL)
    @Owner("Aiperi")
    @Story("As a user i should be able to click a check-box and than input value of discount")
    @Link(name = "requirements", url = "https://nuta1bema.talentlms.com/")
    @Step("Проверка теста")
    public void addDiscountTest() {
        elementActions.press(e_commercePage.discount)
                .press(e_commercePage.discountCheckBox)
                .input(e_commercePage.percentageOfDiscount, "5");
        String valueDis = e_commercePage.percentageOfDiscount.getAttribute("value");
        assertEquals(valueDis, "5");
    }

    @Test(priority = 5, description = "Check invoice message in main page with message in preview page and check the percentage" +
            "from the Discount ")
    @TestCase(id = 5)
    @Severity(SeverityLevel.NORMAL)
    @Owner("Aiperi")
    @Story("As a user i should click Invoice than click the check-box input some description, than click" +
            "the loop icon to check the invoice preview ")
    @Link(name = "requirements", url = "https://nuta1bema.talentlms.com/")
    @Step("Проверка теста")
    public void checkInvoiceTest() throws InterruptedException {
        elementActions.press(e_commercePage.invoices)
                .press(e_commercePage.invoiceCheckBox)
                .input(e_commercePage.invoiceMessage, "This invoice is for students from Digital Nomads Winter 2022")
                .press(e_commercePage.invoicePreview)
                .waitElementToBeClickAble(e_commercePage.invoicePreview)
                .press(e_commercePage.invoiceCloseBtn);

        String numberOfSymbols = "500";
        String actualMessagePreview = e_commercePage.invoiceMessage.getAttribute("value");
        String expectedMessageinPreview = e_commercePage.messageInPreview.getText();
        assertEquals(actualMessagePreview, expectedMessageinPreview);
        assertEquals(e_commercePage.percentageOfDiscount.getAttribute("value"), "5");
        assertNotEquals(numberOfSymbols, actualMessagePreview);
    }

    @Test(priority = 6, description = "Verify user can fill up the form successfully")
    @TestCase(id = 5)
    @Severity(SeverityLevel.NORMAL)
    @Owner("Aiperi")
    @Story("As a user i should click Coupon than click the button Add coupon fill up all fields in pop-up window, than click" +
            "the button Add coupon in this pop-up window, than coupon should appear in the main page")
    @Link(name = "requirements", url = "https://nuta1bema.talentlms.com/")
    @Step("Проверка теста")
    public void addCouponTest() throws InterruptedException {
        String actualCoupon = e_commercePage.addCoupons("123","09/05/2023","","5",
                "20","Advanced Features of TalentLMS (002)","Economics", "Accounting").toString();
        assertNotNull(e_commercePage.addCoupons(), "This pop-up window not empty");

    }
}
