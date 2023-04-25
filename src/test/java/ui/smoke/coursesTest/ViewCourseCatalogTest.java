package ui.smoke.coursesTest;

import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.courses_page.CoursesHomePage;
import com.digital.ui.pages.courses_page.ViewCoursesCatalogPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewCourseCatalogTest {

    CoursesHomePage courseHomePage = new CoursesHomePage();
    LoginPage loginPage = new LoginPage();

    ViewCoursesCatalogPage viewCoursesCatalogPage = new ViewCoursesCatalogPage();

    @BeforeClass
    public void openAndLogin() {
        loginPage.openPage();
        loginPage.authorization();
        courseHomePage.openCoursesPage();
    }

    @Test
    public void catalogMethod() {
        viewCoursesCatalogPage.catalogBtn();
        viewCoursesCatalogPage.inputCourses();
        viewCoursesCatalogPage.backBtn();
    }






}
