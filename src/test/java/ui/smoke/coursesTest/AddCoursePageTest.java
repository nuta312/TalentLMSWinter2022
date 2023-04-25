package ui.smoke.coursesTest;


import com.digital.annotations.TestCase;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.courses_page.AddCoursePage;
import com.digital.ui.pages.courses_page.CoursesHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.BaseUiTest;


public class AddCoursePageTest extends BaseUiTest{
    CoursesHomePage coursesHomePage = new CoursesHomePage();
    AddCoursePage addCoursePage = new AddCoursePage();
    LoginPage loginPage = new LoginPage();


    @BeforeClass
    public void openAndLogin() {
        loginPage.openPage()
                .authorization();
        coursesHomePage.openCoursesPage();
        addCoursePage.addingNewCourse();
    }


//    @Test(description = "Verify 'Add course' button is displayed")
//    @TestCase (id = 3)
//    public void verifyAddCourseBtn() {
//        addCoursePage.addingNewCourse();
//    }



    @Test(description = "Verify user can add course with valid credentials")
    @TestCase (id = 6)
    public void addCourWithValidCreden() {
        addCoursePage.fillCourseInputs()
                .saveNewCourse()
                .checkAddedCourseWithAssert();
    }

    @Test(description = "Verify user can add course with price")
    @TestCase (id = 6)
    public void addCourseWithPrice() {
        addCoursePage.fillCourseInputs()
                .choosePrice()
                .saveNewCourse()
                .checkAddedCourseWithAssert();
    }

    @Test (description = "Verify user can not add course with empty course name input field")
    @TestCase (id = 7)
    public void emptyFieldsFailed() {
        addCoursePage.choosePrice()
                .saveNewCourse();
    }

    @Test (description = "Verify 'Cancel' button are displayed and verify user can click 'Cancel' button ")
    @TestCase (id = 8)
    public void verifyCancelBtn() {
        addCoursePage.cancelBtn();
    }





}
