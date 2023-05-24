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
public class UserBean {
    int emp_no;
    String first_name;
    String last_name;
    String birth_date;
    String gender;
    String hire_date;

    public static List<UserBean> getAll() throws SQLException {
        String query = "SELECT * FROM employees";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, UserBean.class);
        }
    }

    public static UserBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM employees WHERE " + column + " = ?;";
        ResultSet rs = DBConnection.query(query, value);
        if (!rs.next()) return null;
        return new BeanProcessor().toBean(rs, UserBean.class);
    }

    public UserBean(ResultSet rs) throws SQLException {
        new BeanProcessor().populateBean(rs, this);
    }

}