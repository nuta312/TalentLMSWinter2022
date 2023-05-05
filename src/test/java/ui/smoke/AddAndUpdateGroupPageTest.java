package ui.smoke;

import com.digital.annotations.TestCase;
import com.digital.ui.pages.AddAndUpdateGroupPage;
<<<<<<< HEAD
import io.qameta.allure.*;
import org.testng.annotations.*;
=======
import com.digital.ui.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;
>>>>>>> db3f167 (New commit)
import ui.BaseUiTest;

public class AddAndUpdateGroupPageTest extends BaseUiTest {

    AddAndUpdateGroupPage group = new AddAndUpdateGroupPage();
<<<<<<< HEAD



    @Test(priority=1, description = "Verify a user can add a new group")
=======
    LoginPage login = new LoginPage();


    @Test(description = "Verify a user can add a new group")
>>>>>>> db3f167 (New commit)
    @TestCase(id = 001)
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Aigerim Dzhanybekova")
    @Story("As a user i should be able to login Home page. Navigate to the 'Groups' tab in the system\n" +
            "Click on the \"\"ADD\"\" button\n" +
            "Fill in the \"\"Name\"\" field with a valid name for the group\n" +
            "Fill in the \"\"Description\"\" field with a valid description up to 500 characters\n" +
            "Fill in the \"\"Group key\"\" field with a valid key for the group\n" +
            "Fill in the \"\"Price\"\" field with a valid price for the group\n" +
            "Verify that the system displays a success message indicating the group has been created\n")

<<<<<<< HEAD
    @Link(name = "requirements", url = "https://aigerim3110.talentlms.com/dashboard")
    public void addGroupTest()  {


        group.openPage();
        group.authorization();
=======
    @Link(name = "requirements", url = "https://nuta1bema.talentlms.com/group/index")
    public void addGroupTest()  {

        login.openPage()
                .authorization();
>>>>>>> db3f167 (New commit)

        group.addNewGroup()
                .inputNameOfGroup("QA")
                .inputDescription("This group for QA automation engineers")
                .inputKey("123")
                .inputPrice("1000")
                .submitGroup()
<<<<<<< HEAD
                        .backToGroupList();


       group.assertCondition(group.expectedName.getText().contains("QA"))
               .assertCondition(group.expectedDescription.getText().contains("This group for QA automation engineers"))
               .assertCondition(group.expectedPrice.getText().contains("$1,000.00"));
=======
                .backToGroupList();


        group.assertCondition(group.expectedName.getText().contains("QA"))
                .assertCondition(group.expectedDescription.getText().contains("This group for QA automation engineers"))
                .assertCondition(group.expectedPrice.getText().contains("$1,000.00"));
>>>>>>> db3f167 (New commit)


    }


<<<<<<< HEAD
    @Test(priority=2,description = "Verify user can add group by filling only 'Name' field")
=======
    @Test(description = "Verify user can add group by filling only 'Name' field")
>>>>>>> db3f167 (New commit)
    @TestCase(id = 002)
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Aigerim Dzhanybekova")
    @Story("As a user i should be able to login home page. Click 'add groups' button and " +
            "add group by filling only 'Name' field" )
<<<<<<< HEAD
    @Link(name = "requirements",url = "https://aigerim3110.talentlms.com/dashboard")
    public void addGroupWithOnlyNameTest() {


        group.openPage();
        group.addNewGroup()
                .inputNameOfGroup("Digital nomads")
                .submitGroup()
                        .backToGroupList();
=======
    @Link(name = "requirements",url = "https://nuta1bema.talentlms.com/group/index")
    public void addGroupWithOnlyNameTest() {

        login.openPage();

        group.addNewGroup()
                .inputNameOfGroup("Digital nomads")
                .submitGroup()
                .backToGroupList();
>>>>>>> db3f167 (New commit)



        group.assertCondition(group.expectedName.getText().contains("Digital nomads"));


    }

<<<<<<< HEAD
    @Test(priority=3,description = "Verify user cannot add group without filling a 'Name' field")
=======
    @Test(description = "Verify user cannot add group without filling a 'Name' field")
>>>>>>> db3f167 (New commit)
    @TestCase(id = 003)
    @Severity(SeverityLevel.TRIVIAL)
    @Owner("Aigerim Dzhanybekova")
    @Story("As a user i should be able to login home page. Select 'add groups' button and add group without " +
            "filling 'name' field." +
            "Verify that the system displays: ''Name' is required' text")
<<<<<<< HEAD
    @Link(name = "requirements",url = "https://aigerim3110.talentlms.com/dashboard")
    public void addGroupWithoutNameTest()  {


        group.openPage();
=======
    @Link(name = "requirements",url = "https://nuta1bema.talentlms.com/group/index")
    public void addGroupWithoutNameTest()  {


        login.openPage();

>>>>>>> db3f167 (New commit)
        group.addNewGroup()
                .inputNameOfGroup("")
                .inputDescription("Hi there")
                .inputKey("25416")
                .inputPrice("144")
                .submitGroup();

        group.assertCondition(group.nameRequired.getText().equals("'Name' is required"));


    }


<<<<<<< HEAD
    @Test(priority=4, description = "Verify a user can update group")
=======
    @Test(description = "Verify a user can update group")
>>>>>>> db3f167 (New commit)
    @TestCase(id = 004)
    @Severity(SeverityLevel.NORMAL)
    @Owner("Aigerim Dzhanybekova")
    @Story("As a user i should be able to login. Navigate to the 'Groups' tab in the system. " +
            "Click the edit button and update group." +
            "Verify that the system displays a success message indicating the group has been updated")
<<<<<<< HEAD
    @Link(name = "requirements",url = "https://aigerim3110.talentlms.com/dashboard")
    public void editGroupTest() {


        group.openPage();
=======
    @Link(name = "requirements",url = "https://nuta1bema.talentlms.com/group/index")
    public void editGroupTest() {


        login.openPage();

>>>>>>> db3f167 (New commit)
        group.displayGroupList()
                .editGroup()
                .inputDescription("Here we learn Java")
                .inputKey("89658")
                .inputPrice("100")
                .submitGroup();

        group.assertCondition(group.expectedName.getText().contains("Digital nomads"))
                .assertCondition(group.expectedDescription.getText().contains("Here we learn Java"))
                .assertCondition(group.expectedPrice.getText().contains("$100.00"));


    }
<<<<<<< HEAD

}
=======
}
>>>>>>> db3f167 (New commit)
