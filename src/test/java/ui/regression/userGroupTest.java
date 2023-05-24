package ui.regression;

import com.digital.annotations.TestCase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.BaseUiTest;

public class userGroupTest extends BaseUiTest{

    @Test(priority = 1)
    public void opengroup() throws InterruptedException {
        loginPage.authorization();
        homePage.openUsers();
        usersPage.openUser("K Argen");
        usersOptions.openGroups();

    }

    @Test(priority = 2)
    @TestCase(id = 010)
    @Description("Synchronize User with Courses in Groups")
    public void openGroupname(){
        usersGroupsAdmins.
                openRandomGroup()
                .openCourses()
                .refresh();
        waitforSeconds.IfYouNeedTowait(5);
        usersGroupsAdmins.selectcourses();
    }

    @Test(priority = 3)
    @Description("test Download And Search")
    public void testDownloadAndSearch(){
        usersGroupsAdmins.refresh()
                .DownloadDocument();
        usersGroupsAdmins.isFileDownload("C:\\\\Users\\\\DELL\\\\Downloads","argoproject-user-2-groups");
        usersGroupsAdmins.SearchFiled();
    }


    @Test(priority = 4)
    @TestCase(id = 012)
    @Description("Remove user from a group")
    public void clickOptionsButton2(){
        usersGroupsAdmins.refresh()
                .getMinusToPlusCourses();

        usersGroupsAdmins.refresh()
                .getMinusToPlusGroups()
                .DownloadDocument()
                .isFileDownload("C:\\\\Users\\\\DELL\\\\Downloads","argoproject-user-2-groups");

    }

}
