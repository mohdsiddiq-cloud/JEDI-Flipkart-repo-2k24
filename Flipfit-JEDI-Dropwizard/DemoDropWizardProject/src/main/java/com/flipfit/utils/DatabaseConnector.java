package com.flipfit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection connection = null;

    public static Connection getConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_db", "root", "P0A@s#s#");
                return con;
            }
            catch (Exception e) {
                System.out.println(e);
                return null;
            }
    }

    public static boolean isValid() throws SQLException {
        return connection != null && !connection.isClosed();
    }
}
