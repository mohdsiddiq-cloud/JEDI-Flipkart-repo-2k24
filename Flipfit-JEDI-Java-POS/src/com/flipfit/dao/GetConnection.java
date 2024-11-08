package com.flipfit.dao;
import com.flipfit.constant.DBConstants;

import java.sql.*;
public class GetConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit", "root", DBConstants.PASSWORD);
            return con;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
