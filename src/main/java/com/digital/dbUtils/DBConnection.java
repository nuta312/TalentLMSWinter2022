package com.digital.dbUtils;

import com.digital.config.ConfigReader;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;


public class DBConnection {
    private static Connection connection;
    private static Statement statement;


    private DBConnection() {
    }

    public static void open(String db) throws SQLException {
        if (connection == null) {
            connection = getBaseDataSource(db).getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
    }

    public static ResultSet query(String query, Object... params) throws SQLException {
        if (params.length == 0)
            return statement.executeQuery(query);
        else{
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            for(int i = 0; i < params.length; i++){
                preparedStatement.setObject(i + 1, params[i]);
            }

            return preparedStatement.executeQuery();
        }
    }


    public static void close() {
        try {
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (connection != null) {
                connection.close();
                connection = null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static MysqlDataSource getBaseDataSource(String database) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(ConfigReader.getProperty("server"));
        dataSource.setPortNumber(Integer.parseInt(ConfigReader.getProperty("port")));
        dataSource.setUser(ConfigReader.getProperty("DBuser"));
        dataSource.setPassword(ConfigReader.getProperty("DBpassword"));
        dataSource.setDatabaseName(database);
        return dataSource;
    }

}