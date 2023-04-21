package ui.smoke;


import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.courses_page.AddCoursePage;
import com.digital.ui.pages.courses_page.CourseHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.BaseUiTest;

public class AddCoursePageTest extends BaseUiTest{
    CourseHomePage courseHomePage = new CourseHomePage();
    AddCoursePage addCoursePage = new AddCoursePage();
    LoginPage loginPage = new LoginPage();


    @BeforeClass
    public void openAndAddCourse() {
        loginPage.openPage();
        loginPage.authorization();
        courseHomePage.openCoursesPage();
//        addCoursePage.addCourseMethod();
    }


    @Test(description = "C3 - Verify 'Add course' button is displayed")
    public void verifyAddCourseBtn() {
        addCoursePage.addCourseMethod();
    }

    @Test(description = "C4 - Verify input fields are displayed")
    public void inputFieldsDisplayed() {
        addCoursePage.fillCourseInputs();
        addCoursePage.choosePrice();
    }


    @Test(description = "C6")
    public void blabla() {
        addCoursePage.fillCourseInputs();
        addCoursePage.choosePrice();
        addCoursePage.clickSaveBtn();
    }

    @Test(description = "C6")
    public void test() {
        addCoursePage.fillCourseInputs();
        addCoursePage.choosePrice();
        addCoursePage.clickSaveBtn();
    }

    @Test (description = "C4 - Verify input fields are displayed")
    public void emptyField() {
        addCoursePage.fillCourseInputs();
        addCoursePage.choosePrice();

    }






}
