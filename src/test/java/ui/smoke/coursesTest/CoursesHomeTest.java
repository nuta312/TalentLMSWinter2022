package ui.smoke.coursesTest;

import com.digital.annotations.TestCase;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.courses_page.CoursesHomePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

    @Test (description = "Verify user can click Report Course button")
    @Severity(SeverityLevel.CRITICAL)
    @TestCase (id = 9)
    public void reportingCourseAndAssert() {
        coursesHomePage.reportCourseBtnOnCoursePage();
    }

    @Test (description = "Verify user can click Edit Course button")
    @Severity(SeverityLevel.CRITICAL)
    @TestCase (id = 10)
    public void editingCourseAndAssert() {
        coursesHomePage.editCourseBtnOnCoursePage();
    }

    @Test (description = "Verify user can click Clone Course button")
    @Severity(SeverityLevel.CRITICAL)
    @TestCase (id = 11)
    public void cloningCourseAndAssert() {
        coursesHomePage.cloneCourseBtnOnCoursePage();
    }

    @Test (description = "Verify user can click Confirm Clone Course button")
    @Severity(SeverityLevel.CRITICAL)
    @TestCase (id = 12)
    public void confirmCloneAndAssert() {
        coursesHomePage.cloneCourseBtnOnCoursePage();
        coursesHomePage.confirmClone();
    }

    @Test (description = "Verify user can click Delete Course button")
    @Severity(SeverityLevel.CRITICAL)
    @TestCase (id = 13)
    public void deletingCourseAndAssert() {
        coursesHomePage.deleteCourseBtnOnCoursePage();
    }

    @Test (description = "Verify user can click Confirm Delete Course button")
    @Severity(SeverityLevel.CRITICAL)
    @TestCase (id = 14)
    public void confirmDeletionAndAssert() {
        coursesHomePage.deleteCourseBtnOnCoursePage();
        coursesHomePage.confirmDeletion();
    }

    @Test (description = "Verify user can click View Course button")
    @Severity(SeverityLevel.CRITICAL)
    @TestCase (id = 15)
    public void viewCourseBtnAndAssert() {
        coursesHomePage.viewCourseBtnOnCoursePage();
    }
}
