package ui.smoke.user;

import com.digital.annotations.TestCase;
import com.digital.enums.DataOfUsers;
import com.digital.enums.LinksOfTalentLMS;
import com.digital.ui.driver.Driver;
import com.digital.ui.pages.usersHP.course.Asserts;
import com.digital.ui.pages.usersHP.course.Courses;
import com.digital.ui.pages.loginPage.FirstPageTLMS;
import com.digital.ui.element_helper.WebElementActions;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class CoursesTest {
    WebElementActions elementActions = new WebElementActions();
    public FirstPageTLMS firstPage = new FirstPageTLMS();
    public Courses courses = new Courses();
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void openPage() throws InterruptedException {
        driver = Driver.getDriver();
        driver.navigate().to(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .goToUserPage();

    }

    @AfterMethod(alwaysRun = true)
    public void closePage() {
//        driver.close();
    }

    @Test(description = "Verify that user can enroll to the SPECIFIED course",priority = 0)
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("User can enroll to specified course")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void enrollToCourseTest() throws InterruptedException {
        firstPage.goToUserPage()
                .clickUser("a. asdasd")
                .selectSectionCoursesField();
        elementActions.scrollDown();
        courses.enroll("New Courses Name (143241)");
        courses.enroll("will school");

        List<WebElement> e = Driver.getDriver().findElements(By.xpath("//a[@class='label label-learner']"));
        for (int i = 0; i < e.size(); i++) {
            Asserts.assertEqualsCourse("LEARNER", e.get(i).getText());
        }

    }

    @Test(description = "Verify that user can unenroll from SPECIFIED course",priority = 1)
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("User can unenroll from specified course")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void unenrollFromCourseTest() throws InterruptedException {
        firstPage.goToUserPage()
                .clickUser("a. asdasd")
                .selectSectionCoursesField();
        elementActions.scrollDown();
        courses.unenroll("New Courses Name (143241)");
        courses.unenroll("will school");
        List<WebElement> e = Driver.getDriver().findElements(By.xpath("//a[@class='label label-learner']"));
        for (int i = 0; i < e.size(); i++) {
            Asserts.assertEqualsCourse("-", e.get(i).getText());
        }
    }

    @Test(description = "Verify that user can enroll to ALL courses",priority = 2)
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("User can unenroll from courses")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void enrollToAllCoursesTest() throws InterruptedException {
        firstPage.goToUserPage()
                .clickUser("a. asdasd")
                .selectSectionCoursesField()
                .goToCourses()
                .enrollToAllCourses();
        Thread.sleep(5000);
        List<WebElement> e = Driver.getDriver().findElements(By.xpath("//a[@class='label label-learner']"));
        for (int i = 0; i < e.size(); i++) {
            Asserts.assertEqualsCourse("LEARNER", e.get(i).getText());
        }

    }

    @Test(description = "Verify that user can unenroll from ALL courses",priority = 3)
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("User can unenroll from courses")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void unenrollFromAllCoursesTest() throws InterruptedException {
        firstPage.goToUserPage()
                .clickUser("a. asdasd")
                .selectSectionCoursesField()
                .goToCourses()
                .unenrollFromAllCourses();
        Thread.sleep(3000);
        List<WebElement> e = Driver.getDriver().findElements(By.xpath("//a[@class='label label-learner']"));
        for (int i = 0; i < e.size(); i++) {
            Asserts.assertEqualsCourse("-", e.get(i).getText());
        }

    }

    @Test(description = "Verify that admin can change role TO LEARNER",priority = 4)
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("Admin can change role")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void changeRoleToLearnerTest() throws InterruptedException {
        firstPage.goToUserPage()
                .clickUser("S. Reichel")
                .selectSectionCoursesField()
                .goToCourses()
                .changeRoleToLearner("New Courses Name (143241)");
        Thread.sleep(5000);
        WebElement element = Driver.getDriver().findElement(By
                .xpath("//a[@class='dropdown-toggle label label-learner']"));
        Asserts.assertEqualsCourse("LEARNER", element.getText());
    }

    @Test(description = "Verify that admin can change all roles TO LEARNER",priority = 5)
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("Admin can change roles")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void changeAllRolesToLearnerTest() throws InterruptedException {
        firstPage.goToUserPage()
                .clickUser("E. Gulgowski")
                .selectSectionCoursesField()
                .goToCourses()
                .changeAllRolesToLearner();
        Thread.sleep(5000);
        List<WebElement> e = Driver.getDriver().findElements(By
                .xpath("//a[@class='dropdown-toggle label label-learner']"));
        for (int i = 0; i < e.size(); i++) {
            Asserts.assertEqualsCourse("LEARNER", e.get(i).getText());
        }
    }

    @Test(description = "Verify that admin can change role to INSTRUCTOR",priority = 6)
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("Admin can change role")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void changeRoleToInstructorTest() throws InterruptedException {
        firstPage.goToUserPage()
                .clickUser("S. Reichel")
                .selectSectionCoursesField()
                .goToCourses()
                .changeRoleToInstructor("New Courses Name (143241)");
        Thread.sleep(5000);
        WebElement element = Driver.getDriver().findElement(By
                .xpath("//a[@class='dropdown-toggle label label-trainer']"));
        Asserts.assertEqualsCourse("INSTRUCTOR", element.getText());

    }

    @Test(description = "Verify that admin can change all roles TO INSTRUCTOR",priority = 7)
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("Admin can change roles")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void changeAllRolesToInstructorTest() throws InterruptedException {
        firstPage.goToUserPage()
                .clickUser("E. Gulgowski")
                .selectSectionCoursesField()
                .goToCourses()
                .changeAllRolesToInstructor();
        Thread.sleep(5000);
        List<WebElement> e = Driver.getDriver().findElements(By.xpath("//a[@class='dropdown-toggle label label-trainer']"));
        for (int i = 0; i < e.size(); i++) {
            Asserts.assertEqualsCourse("INSTRUCTOR",e.get(i).getText());
        }
    }
    @Test(description = "Verify that admin can see reports",priority = 8)
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("Admin can change roles")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void seeReportsTest(){
        firstPage.goToUserPage()
                .seeReportsOfLearner("E. Gulgowski");

    }

    @Test(description = "Verify that admin can log into account",priority = 8)
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("Admin can change roles")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void logIntoAccTest(){
        firstPage.goToUserPage()
                .logIntoAccount("E. Gulgowski");

    }


}

