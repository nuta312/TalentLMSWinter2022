package ui.smoke.coursesTest;

import com.digital.annotations.TestCase;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.courses_page.CoursesHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @author Burulai Narzieva
 */


public class CoursesHomeTest {
    CoursesHomePage coursesHomePage = new CoursesHomePage();
    LoginPage loginPage = new LoginPage();


    @BeforeClass
    public void openAndLogin() {
        loginPage.openPage().authorization();
        coursesHomePage.openCoursesPage();

    }

    @Test
    @TestCase
    public void reportCourseBtn() {
        coursesHomePage.reportCourseBtnOnCoursePage();
    }

    @Test
    @TestCase
    public void editCourseBtn() {
        coursesHomePage.editCourseBtnOnCoursePage();
    }

    @Test
    @TestCase
    public void cloneCourseBtn() {
        coursesHomePage.cloneCourseBtnOnCoursePage();
    }

    @Test
    @TestCase
    public void deletingCourseBtn() {
        coursesHomePage.deletingCourseBtnOnCoursePage();
    }

    @Test
    @TestCase
    public void viewCourseBtn() {
        coursesHomePage.viewCourseBtnOnCoursePage();
    }
}
