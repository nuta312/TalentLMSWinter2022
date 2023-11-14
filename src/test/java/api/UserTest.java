package api;

import com.digital.asserts.ApiAssert;
import com.digital.entities.User;
import com.digital.utils.EntitiesManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

public class UserTest extends BaseApiTest{
    User expectedUser;
    User createdUser;
    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        expectedUser = EntitiesManager.generateUser();
    }

    @Test
    public void testUsers(){
       createdUser = userController.createUser(expectedUser);
      //  user.setId(createdUser.getId());
       ApiAssert.assertThat(userController.getResponse())
               .isCorrectStatusCode(200)
               .assertUser(createdUser)
               .isCorrectName(expectedUser.getFirstName())
               .isCorrectLastName(expectedUser.getLastName());
//      User receivedUser = userController.receiveSingleUser("id", createdUser.getId());
//      user.setId(createdUser.getId());
//      userController.getResponse();
//        AssertJUnit.assertNotNull(receivedUser);

    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(){
        userController.deleteUser(createdUser.getId());
    }
}
