package testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDemo {


    @Test
    public void createNewUserTest() {
        User firstUser = null;
        Assert.assertNotNull(firstUser);
    }

    @Test(dependsOnMethods = "createNewUserTest")
    public void loginTest() {
        Assert.assertTrue(true);
    }

    @DataProvider(name = "inputValues")
    public Object[][] getInputValues() {
        return new Object[][] {
                {"john@gmail.com", "ValidPass"},
                {"johngmail.com", "ValidPass"},
                {"john@gmail.com","InvalidPas"}
        };
    }

    @Test(dataProvider = "inputValues")
    public void testLoginFun(String username,String password){
        System.out.println(username + " " + password);
    }

}
