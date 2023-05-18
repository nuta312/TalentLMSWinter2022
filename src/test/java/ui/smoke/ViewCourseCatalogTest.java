package ui.smoke;


import com.digital.annotations.TestCase;
import com.digital.ui.driver.Driver;
import com.digital.ui.pages.CourseHomePage;
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.ViewCourseCatalogPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Chyngyz & Ulan
 */

public class ViewCourseCatalogTest {
    CourseHomePage courseHomePage = new CourseHomePage();
    ViewCourseCatalogPage viewCourseCatalogPage = new ViewCourseCatalogPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test(priority = 1, description = "Opens catalog page and goes to view courses catalog")
    @TestCase(id = 18)
    @Severity(SeverityLevel.MINOR)
    public void catalogMethodTest() {
        loginPage.openPage()
                .authorization();
        homePage.clickCourses();
        viewCourseCatalogPage.catalogBtn();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://testtalant.talentlms.com/catalog");
    }

    @Test(priority = 2, description = "Entering and searching courses")
    @TestCase(id = 19)
    @Severity(SeverityLevel.MINOR)
    public void inputSearchCoursesTest() {
        viewCourseCatalogPage.inputCourses();
        Assert.assertNotNull(viewCourseCatalogPage.searchCourses.getText());
        viewCourseCatalogPage.searchClearCourses.click();
    }

    @Test(priority = 3, description = "Opening course description")
    @TestCase(id = 20)
    @Severity(SeverityLevel.MINOR)
    public void openIntroductionTalentLmsTest() {
        viewCourseCatalogPage.openIntroductionTalentLms();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://testtalant.talentlms.com/catalog/info/id:123");
    }

    @Test(priority = 4, description = "Entering back button to return to previous page")
    @TestCase(id = 21)
    @Severity(SeverityLevel.MINOR)
    public void backBtnTest() {
        viewCourseCatalogPage.backBtn();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://testtalant.talentlms.com/catalog/index");
    }

    @Test(priority = 5, description = "Selecting course order")
    @TestCase(id = 22)
    @Severity(SeverityLevel.MINOR)
    public void selectCourseOrderTest() {
        viewCourseCatalogPage.courseOrder();
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//a[@title='Order']/span")).getText(), "Date");
    }


}
