package ui.smoke.coursesTest;


import com.digital.annotations.TestCase;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.courses_page.AddCoursePage;
import com.digital.ui.pages.courses_page.CoursesHomePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.BaseUiTest;


/**
 * @author Burulai Narzieva
 */


public class AddCoursePageTest extends BaseUiTest{
    CoursesHomePage coursesHomePage = new CoursesHomePage();
    AddCoursePage addCoursePage = new AddCoursePage();
    LoginPage loginPage = new LoginPage();


    @BeforeClass
    public void openAndLogin() {
        loginPage.openPage();
        loginPage.authorization();
        coursesHomePage.openCoursesPage();
    }


    @Test(description = "Verify 'Add course' button is displayed")
    @Story("As a user i should be able to click new course button")
    @Severity(SeverityLevel.CRITICAL)
    @TestCase (id = 3)
    public void verifyAddCourseBtnAndAssert() {
        addCoursePage.addingNewCourse();
    }


    @Test(description = "Verify user can add course with valid credentials")
    @Story("As a user i should be able to add new course")
    @Severity(SeverityLevel.CRITICAL)
    @TestCase (id = 5)
    public void addCourseWithValidCreden() {
        addCoursePage.addingNewCourse()
                .fillCourseInputs()
                .saveNewCourse()
                .checkAddedCourseWithAssert();
    }

    @Test(description = "Verify user can add course with price")
    @Story("As a user i should be able to add new course with price")
    @Severity(SeverityLevel.NORMAL)
    @TestCase (id = 6)
    public void addCourseWithPrice() {
        addCoursePage.addingNewCourse()
                .fillCourseInputs()
                .choosePrice()
                .saveNewCourse()
                .checkAddedCourseWithAssert();
    }


    @Test (description = "Verify user can not add course with empty input fields")
    @Story("As a user i can not add course with empty input fields")
    @Severity(SeverityLevel.CRITICAL)
    @TestCase (id = 7)
    public void emptyFieldsFailed() {
        addCoursePage.addingNewCourse()
                .choosePrice()
                .saveNewCourse()
                .checkEmptyFieldsWithAssert();
    }


    @Test (description = "Verify user can click 'Cancel' button")
    @Story("As a user i should be able to click 'Cancel' button")
    @Severity(SeverityLevel.NORMAL)
    @TestCase (id = 8)
    public void verifyCancelBtnAndAssert() {
        addCoursePage.addingNewCourse();
        addCoursePage.cancelBtn();
    }

}
