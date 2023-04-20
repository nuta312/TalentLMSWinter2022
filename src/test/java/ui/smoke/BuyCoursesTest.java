package ui.smoke;



import com.digital.ui.pages.BuyCoursesPage;
import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import org.testng.annotations.Test;

    public class BuyCoursesTest {

        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        BuyCoursesPage buyCoursesPage = new BuyCoursesPage();

        @Test
        public void test() throws InterruptedException {
            loginPage.openPage();
            loginPage.authorization();
            homePage.goToHomePage();
            homePage.clickCourses();
            buyCoursesPage.clickCourses()
                    .searchAndFindCourse("What is Machine Learning?")
                    .clickYouTubeWindow();


        }




    }

