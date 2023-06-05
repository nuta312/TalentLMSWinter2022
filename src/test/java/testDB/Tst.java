package testDB;

import com.digital.dbUtils.UserBean;
import com.digital.dbUtils.DBConnection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Tst {

    @Test
    public void CreateNewUserTest() throws SQLException {
        DBConnection.open("employees");
        UserBean georgi = new UserBean(10001,"Georgi","Facello","1953-09-02","M","1986-06-26");
//        LoginPage loginPage = new LoginPage();
//        loginPage.login.sendKeys(georgi.getFirst_name());

        ResultSet rs = DBConnection.query("SELECT * FROM employees WHERE first_name = ?;", "Georgi");
        while (rs.next()) {
            UserBean user = new UserBean(rs);
            Assert.assertEquals(user.getFirst_name(),georgi.getFirst_name());
            Assert.assertEquals(user.getGender(),georgi.getGender());
            Assert.assertEquals(user.getBirth_date(),georgi.getBirth_date());
            Assert.assertEquals(user.getLast_name(),georgi.getLast_name());
            Assert.assertEquals(user.getHire_date(),georgi.getHire_date());
            break;
        }
        DBConnection.close();
    }

}