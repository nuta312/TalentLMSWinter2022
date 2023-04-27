package ui.smoke;



import com.digital.annotations.TestCase;
import com.digital.enums.Courses;
import com.digital.ui.driver.Driver;
import com.digital.ui.pages.BuyCoursesPage;
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.courses_page.CourseHomePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class BuyCoursesTest {
        CourseHomePage courseHomePage = new CourseHomePage();

        LoginPage loginPage = new LoginPage();
      //  HomePage homePage = new HomePage();

        BuyCoursesPage buyCoursesPage = new BuyCoursesPage();

        @BeforeClass
        public void openAndLogin(){
            loginPage.openPage();
            loginPage.authorization();
            courseHomePage.openCoursesPage();
        }

        @Test(description = "Verify the Buy Course Page exists")
        @TestCase(id = 20)
        @Severity(SeverityLevel.NORMAL)
        public void SearchCourse() throws InterruptedException {
            buyCoursesPage.clickCourses();
            buyCoursesPage.searchAndFindCourse();
        }

        @Test(description = "Verify the search field by searching some course")
        @TestCase(id = 21)
        @Severity(SeverityLevel.NORMAL)
        public void CheckMachineByAssert() throws InterruptedException {
            buyCoursesPage.clickCourses()
            .searchAndFindCourse()
            .myAssertEquals(buyCoursesPage.machineLearnText, Courses.MACHINE_COURSE.getCourse());
        }

        @Test(description = "Verify choose the course and check by assert")
        @TestCase(id = 22)
        @Severity(SeverityLevel.NORMAL)
        public void clickMachineCourse() throws InterruptedException {
            buyCoursesPage.clickCourses()
                    .searchAndFindCourse();
                    Thread.sleep(2000);
                    buyCoursesPage.pressMachineCourse()
                    .myAssertEquals(buyCoursesPage.enteredMachineText, Courses.SECOND_MACHINE.getCourse());
        }

        @Test(description = "Verify choose the course enter and go back")
        @TestCase(id = 23)
        @Severity(SeverityLevel.NORMAL)
        public void pressReturnBtn() throws InterruptedException {
            buyCoursesPage.clickCourses()
                    .searchAndFindCourse()
                    .pressMachineCourse()
                    .pressReturnLinkBtn();
        }
        @Test(description = "Verify other course link displays and click it")
        @TestCase(id = 24)
        @Severity(SeverityLevel.NORMAL)
        public void otherCourseProv() throws InterruptedException {
            buyCoursesPage.clickCourses();
            buyCoursesPage.clickOtherCourseProv()
                    .myAssertEquals(buyCoursesPage.checkOtherCur, "You and Your Boss");
            assertTrue(buyCoursesPage.checkOtherCur.isDisplayed());
        }
        @Test(description = "Verify is entered to other course page and check by assert")
        @TestCase(id = 25)
        @Severity(SeverityLevel.NORMAL)
        public void findBuildCourse() throws InterruptedException {
            buyCoursesPage.clickCourses()
                 .clickOtherCourseProv()
                 .findBuildingOtherCourse(Courses.BUILDING_COURSE.getCourse())
                 .buildingCareerByAssert();

            Driver.closeDriver();
        }

        @Test(description = "Verify the GO TO button displayed then GO TO COURSES")
        @TestCase(id = 26)
        @Severity(SeverityLevel.NORMAL)
        public void goToTest() throws InterruptedException {
            buyCoursesPage.clickCourses()
                    .clickOtherCourseProv()
                    .goTO();

            Driver.closeDriver();
        }











    }

