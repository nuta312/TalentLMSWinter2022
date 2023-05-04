package ui.smoke.user;

import com.digital.annotations.TestCase;
import com.digital.enums.DataOfUsers;
import com.digital.enums.LinksOfTalentLMS;
import com.digital.ui.driver.Driver;
import com.digital.ui.pages.usersHP.course.Courses;
import com.digital.ui.pages.loginPage.FirstPageTLMS;
import com.digital.ui.element_helper.WebElementActions;
import io.qameta.allure.*;
import org.testng.annotations.Test;



public class CoursesTest  {
    WebElementActions elementActions = new WebElementActions();
    public FirstPageTLMS firstPage = new FirstPageTLMS();
    public Courses courses = new Courses();


    @Test(description = "Verify that user can enroll to the SPECIFIED course")
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("User can enroll to specified course")
    @Link(name = "courses", url = "https://nuta1bema.talentlms.com/user/courses")
    public void enrollToCourseTest() throws InterruptedException {
        Driver.getDriver().get(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        Thread.sleep(3000);
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .toToUserPage()
                .clickUser("a. asdasd")
                .selectSectionCoursesField();
        elementActions.scrollDown();
        courses.enroll("New Courses Name (143241)");
        courses.enroll("will school");


//       Assert.assertTrue(elementText1.contains("Learner"));
//       Assert.assertTrue(elementText2.contains("Learner"));

    }

    @Test(description = "Verify that user can unenroll from SPECIFIED course")
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("User can unenroll from specified course")
    @Link(name = "courses", url = "https://aisana0803.talentlms.com/user/courses")
    public void unenrollFromCourseTest() throws InterruptedException {
        Driver.getDriver().navigate().to(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        Thread.sleep(3000);
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .toToUserPage()
                .clickUser("a. asdasd")
                .selectSectionCoursesField();
        elementActions.scrollDown();
        courses.unenroll("New Courses Name (143241)");
        courses.unenroll("will school");
        Driver.closeDriver();
    }

    @Test(description = "Verify that user can enroll to ALL courses")
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("User can unenroll from courses")
    @Link(name = "courses", url = "https://aisana0803.talentlms.com/user/courses")
    public void enrollToAllCoursesTest() throws InterruptedException {
        Driver.getDriver().navigate().to(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        Thread.sleep(3000);
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .toToUserPage()
                .clickUser("a. asdasd")
                .selectSectionCoursesField()
                .goToCourses()
                .enrollToAllCourses();
        Thread.sleep(5000);
    }

    @Test(description = "Verify that user can unenroll from ALL courses")
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("User can unenroll from courses")
    @Link(name = "courses", url = "https://aisana0803.talentlms.com/user/courses")
    public void unenrollFromAllCoursesTest() throws InterruptedException {
        Driver.getDriver().navigate().to(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        Thread.sleep(1000);
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .toToUserPage()
                .clickUser("a. asdasd")
                .selectSectionCoursesField()
                .goToCourses()
                .unenrollFromAllCourses();
        Thread.sleep(3000);
    }

    @Test(description = "Verify that admin can change role TO LEARNER")
    @TestCase(id = 1)
    @Severity(SeverityLevel.NORMAL)
    @Owner("AisanaE")
    @Story("Admin can change role")
    @Link(name = "courses", url = "https://aisana0803.talentlms.com/user/courses")
    public void changeRoleToLearnerTest() throws InterruptedException {
        Driver.getDriver().navigate().to(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        Thread.sleep(3000);
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .toToUserPage()
                .clickUser("A. Erlanova")
                .selectSectionCoursesField()
                .goToCourses()
                .changeRoleToLearner("Employee Training 101");
        Thread.sleep(5000);
    }

    @Test
    public void changeAllRolesToLearnerTest() throws InterruptedException {
        Driver.getDriver().navigate().to(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        Thread.sleep(3000);
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .toToUserPage()
                .clickUser("A. Erlanova")
                .selectSectionCoursesField()
                .goToCourses()
                .changeAllRolesToLearner();
        Thread.sleep(5000);
    }

    @Test
    public void changeRoleToInstructorTest() throws InterruptedException {
        Driver.getDriver().navigate().to(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        Thread.sleep(3000);
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .toToUserPage()
                .clickUser("A. Erlanova")
                .selectSectionCoursesField()
                .goToCourses()
                .changeRoleToInstructor("CookingDeserts");
        Thread.sleep(5000);

    }

    @Test
    public void changeAllRolesToInstructorTest() throws InterruptedException {
        Driver.getDriver().navigate().to(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        Thread.sleep(3000);
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .toToUserPage()
                .clickUser("A. Erlanova")
                .selectSectionCoursesField()
                .goToCourses()
                .changeAllRolesToInstructor();
        Thread.sleep(5000);

    }

    @Test
    public void seeReportsTest() throws InterruptedException {
        Driver.getDriver().navigate().to(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        Thread.sleep(3000);
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .toToUserPage()
                .seeReportsOfLearner("A. Orozakunova");

    }
    @Test
    public void logIntoAccTest() throws InterruptedException {
        Driver.getDriver().navigate().to(LinksOfTalentLMS.FIRSTPAGE.getFirstTalentLMSPage());
        Thread.sleep(3000);
        firstPage.login(DataOfUsers.LOGIN.getUsersData(), DataOfUsers.PASSWORD.getUsersData())
                .toToUserPage()
                .logIntoAccount("A. Orozakunova");

    }


}

