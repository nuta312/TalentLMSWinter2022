package ui.smoke;



import com.digital.annotations.TestCase;
import com.digital.enums.Courses;
import com.digital.ui.driver.Driver;
import com.digital.ui.pages.courses_page.BuyCoursesPage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.courses_page.CourseHomePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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

        @Test(priority = 1, description = "Verify the Buy Course Page exists")
        @TestCase(id = 20)
        @Severity(SeverityLevel.NORMAL)
        public void SearchCourse() throws InterruptedException {
            buyCoursesPage.clickCourses();
            buyCoursesPage.searchAndFindCourse();
        }



        @Test(priority = 2, description = "Verify the search field by searching some course")
        @TestCase(id = 21)
        @Severity(SeverityLevel.NORMAL)
        public void CheckMachineByAssert() throws InterruptedException {
        //    buyCoursesPage.clickCourses();
        //    buyCoursesPage.searchAndFindCourse();
            buyCoursesPage.myAssertEquals(buyCoursesPage.machineLearnText, Courses.MACHINE_COURSE.getCourse());
        }

        @Test(priority = 3, description = "Verify choose the course and check by assert")
        @TestCase(id = 22)
        @Severity(SeverityLevel.NORMAL)
        public void clickMachineCourse() throws InterruptedException {
//            buyCoursesPage.clickCourses();
//            buyCoursesPage.searchAndFindCourse();
            Thread.sleep(2000);
                    buyCoursesPage.pressMachineCourse();
            buyCoursesPage.myAssertEquals(buyCoursesPage.enteredMachineText, Courses.SECOND_MACHINE.getCourse());
        }

        @Test(priority = 4, description = "Verify choose the course enter and go back")
        @TestCase(id = 23)
        @Severity(SeverityLevel.NORMAL)
        public void pressReturnBtn() throws InterruptedException {
//            buyCoursesPage.clickCourses();
//            buyCoursesPage.searchAndFindCourse();
         //   buyCoursesPage.pressMachineCourse()
                    buyCoursesPage.pressReturnLinkBtn();
        }
        @Test(priority = 5, description = "Verify other course link displays and click it")
        @TestCase(id = 24)
        @Severity(SeverityLevel.NORMAL)
        public void otherCourseProv() throws InterruptedException {
         //   buyCoursesPage.clickCourses();
            buyCoursesPage.clickOtherCourseProv()
                    .myAssertEquals(buyCoursesPage.checkOtherPreventing, "Preventing Discrimination & Harassment: CA Employee");
            assertTrue(buyCoursesPage.checkOtherPreventing.isDisplayed());
        }
        @Test(priority = 6, description = "Verify is entered to other course page and check by assert")
        @TestCase(id = 25)
        @Severity(SeverityLevel.NORMAL)
        public void findBuildCourse() throws InterruptedException {
//            buyCoursesPage.clickCourses();
//            buyCoursesPage.clickOtherCourseProv()
                 buyCoursesPage.findBuildingOtherCourse(Courses.BUILDING_COURSE.getCourse())
                 .buildingCareerByAssert();


        }

        @Test(priority = 7, description = "Verify the GO TO button displayed then GO TO COURSES")
        @TestCase(id = 26)
        @Severity(SeverityLevel.NORMAL)
        public void goToTest() throws InterruptedException {
//            buyCoursesPage.clickCourses();
//            buyCoursesPage.clickOtherCourseProv()
                    buyCoursesPage.goTO();

            Driver.closeDriver();
        }











    }

