package ui.smoke;

import com.digital.annotations.TestCase;
import com.digital.ui.driver.Driver;
import com.digital.ui.pages.Category;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CategoryTest {


    WebDriver driver;
    String baseUrl;


    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = Driver.getDriver();

        baseUrl = "https://suleimansultan312.talentlms.com/category/index";

        driver.get(baseUrl);
        Thread.sleep(2000);
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
      //  driver.quit();
    }

    @Test(description = "Verify user can add category")
    @TestCase(id = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Dastan")
    @Story("As a user i should be able to add category")
    @Link(name = "requirements",url = "https://www.google.com/")
    public void TestCategoryPage(){

        Category cat = new Category();

        cat.openPage();

        cat.addCategory("das","123","das");



    }
}
