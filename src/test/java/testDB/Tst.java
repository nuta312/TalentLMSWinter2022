package testDB;

import com.digital.dbUtils.UserBean;
import com.digital.dbUtils.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Tst {
    public static void main(String[] args) throws SQLException {
        DBConnection.open("employees");
        ResultSet rs = DBConnection.query("SELECT * FROM employees WHERE first_name = ?;", "Georgi");
        rs.next();
        System.out.println(new UserBean(rs));
//        UserBean.getAll().forEach(System.out::println);
        System.out.println(UserBean.getBy("first_name", "Georgi"));
        List<UserBean> employeesData = UserBean.getAll();
        employeesData.forEach(System.out::println);
        System.out.println(employeesData.size());
        DBConnection.close();





    }
}