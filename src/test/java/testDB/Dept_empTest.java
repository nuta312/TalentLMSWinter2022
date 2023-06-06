package testDB;

import com.digital.dbUtils.DBConnection;
import com.digital.dbUtils.Dept_emp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dept_empTest {
    public static void main(String[] args) throws SQLException {
        DBConnection.open("employees");
        ResultSet rs = DBConnection.query("SELECT DISTINCT dept_no FROM dept_emp");
        List<String> userList = new ArrayList<>();
 //       rs.next();
        while (rs.next()) {
            String depNo = rs.getString("dept_no");
            userList.add(depNo);
//            Dept_emp user = new Dept_emp(rs);
//         //   System.out.println(user.getDept_no());
//            userList.add(user.getDept_no());
        }
        System.out.println(userList);
 //       System.out.println(new Dept_emp(rs));
//        System.out.println(Dept_emp.getBy("dept_no", "d005"));
//        System.out.println(Dept_emp.getBy("dept_no", "d005"));
//        List<Dept_emp> employeesData = Dept_emp.getAll();
//        employeesData.forEach(System.out::println);
//        System.out.println(employeesData.size());
        DBConnection.close();


    }
}
