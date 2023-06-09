package api;

import com.digital.asserts.ApiAssert;
import com.digital.entities.User;
import com.digital.utils.EntitiesManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserTest extends BaseApiTest {
    User expectedUser;
    User actualUser;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        expectedUser = EntitiesManager.generateUser();
    }
    @Test
    public void testUsers() {
        actualUser = userController.createUser(expectedUser);
        ApiAssert.assertThat(userController.getResponse())
                .isCorrectStatusCode(200)
                .assertUser(actualUser)
                .isCorrectName(expectedUser.getFirstName())
                .isCorrectLastName(expectedUser.getLastName());
    }
    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        userController.deleteUser(actualUser.getId());
    }
}
