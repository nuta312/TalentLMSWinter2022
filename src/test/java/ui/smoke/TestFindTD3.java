package ui.smoke;

import com.digital.ui.pages.HomePage;
import com.digital.ui.pages.LoginPage;
import com.digital.ui.pages.UserPage.FilesPage;
import com.digital.ui.pages.UserPage.PageGroups;
import com.digital.ui.pages.UserPage.UsersOptions;
import com.digital.ui.pages.UserPage.UsersPage;
import lombok.extern.java.Log;
import org.testng.annotations.Test;
import com.digital.ui.pages.LoginPage.*;
import ui.BaseUiTest;

public class TestFindTD3 extends BaseUiTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    UsersPage usersPage = new UsersPage();

    PageGroups pageGroups = new PageGroups();
    UsersOptions usersOptions = new UsersOptions();

    FilesPage filesPage = new FilesPage();

    @Test
    public void openTd3() throws InterruptedException {
        loginPage.authorization();
        homePage.openUsers();
        usersPage.openUser("E. Chadaev");
        usersOptions.openFiles();
        filesPage.editFile("Digital","sd,dddds,sdds");
        Thread.sleep(5000);
    }
}
