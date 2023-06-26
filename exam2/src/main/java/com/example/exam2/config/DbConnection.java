package com.example.exam2.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=mytestDb";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static final String USERNAME = "sa";

    private static final String PASSWORD = "sa";

    private static Connection connection = null;

    public static Connection openConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
