package com.digital.dbUtils;

import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Dept_emp {
    int emp_no;
    String dept_no;
    String From_date;
    String to_date;

    public static List<Dept_emp> getAll() throws SQLException {
        String query = "SELECT * FROM dept_emp";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, Dept_emp.class);
        }
    }

    public static Dept_emp getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM dept_emp WHERE " + column + " = ?;";
        ResultSet rs = DBConnection.query(query, value);
        if (!rs.next()) return null;
        return new BeanProcessor().toBean(rs, Dept_emp.class);
    }

    public Dept_emp(ResultSet rs) throws SQLException {
        new BeanProcessor().populateBean(rs, this);
    }
}
