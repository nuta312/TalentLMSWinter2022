package testDB;

import com.digital.dbUtils.Bean;
import com.digital.dbUtils.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tst {
    public static void main(String[] args) throws SQLException {
        DBConnection.open("employees");

        ResultSet rs = DBConnection.query("SELECT * FROM employees WHERE first_name = ?;", "Georgi");
        rs.next();
        System.out.println(new Bean(rs));
        Bean.getAll().forEach(System.out::println);
        System.out.println(Bean.getBy("first_name", "Georgi"));
        DBConnection.close();

    }
}