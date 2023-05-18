package ui.regression;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import ui.BaseUiTest;

public class UsersFiles extends BaseUiTest {



    @Test(priority = 1)
    @Description("Make sure the file is loading successfully")
    @Feature("Test FilePage")
    public void uploadFileTest() throws InterruptedException {
    loginPage.authorization();
    homePage.openUsers();
    usersPage.openUser("E. Chadaev");
    usersOptions.openFiles();
    filesPage.uploadFile("C:\\Users\\DMC_Nora\\Desktop\\Routes.txt")
            .assertFile("Routes.txt");
    }

    @Test(priority = 2)
    @Description("Make sure that the file name is changed successfully")
    @Feature("Test FilePage")
    public void renameFileTest() throws InterruptedException {
        filesPage.refresh()
                .openEditForm("Routes.txt")
                .renameFile("MikrotikConfig")
                .confirmEditForm()
                .assertFile("MikrotikConfig");
    }

    @Test(priority = 3)
    @Description("Make sure that the file tags are successfully changed")
    @Feature("Test FilePage")
    public void tagsFileTest() throws InterruptedException {
        filesPage.refresh()
                .openEditForm("MikrotikConfig")
                .inputTags("cisco,vpn,mikro")
                .confirmEditForm()
                .assertFileTags("cisco,vpn,mikro");
    }

    @Test(priority = 4)
    @Description("Make sure that the user's access changes to User can view that file")
    @Feature("Test FilePage")
    public void canViewFileTest() throws InterruptedException {
        filesPage.refresh()
                .userNotViewChangeView("MikrotikConfig")
                .assertFileCanView("MikrotikConfig");

    }

    @Test(priority = 5)
    @Description("Make sure that the user's access changes to User cannot view that file")
    @Feature("Test FilePage")
    public void cannotViewFileTest() throws InterruptedException {
        filesPage.refresh()
                .userViewChangeNotView("MikrotikConfig")
                .assertFileCannotView("MikrotikConfig");
    }

    @Test(priority = 6)
    @Description("Make sure that the user's access changes to User cannot view that file")
    @Feature("Test FilePage")
    public void deleteFileTest() throws InterruptedException {
        filesPage.refresh()
                .deleteFile("MikrotikConfig")
                .assertFile("MikrotikConfig");
    }
}
