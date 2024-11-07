package com.flipfit.dao;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.constant.DBConstants;
import com.flipfit.dao.interfaces.*;
import com.flipfit.bean.FlipFitGymCustomer;
import com.flipfit.bean.FlipFitUser;

import java.sql.*;
import java.util.Random;

public class FlipFitUserDAOImpl implements IFlipFitUserDAO {
    Random rand = new Random();
//
//    public static void main(String[] args) {
//        FlipFitUser FFU = new FlipFitUser();
//
//        FFU.setUserName("PP");
//        FFU.setPassword("pp2");
//        FFU.setRoleID(1);
//        FFU.setEmailID("pp@mail");
//        FFU.setPhoneNumber("9800756987");
//
//        FlipFitUserDAOImpl FFUDAO = new FlipFitUserDAOImpl();
//        FFUDAO.addUser(FFU);
//
//        FlipFitUser FFU1 = new FlipFitUser();
//
//        FFU.setUserName("GG");
//        FFU.setPassword("gg2");
//        FFU.setRoleID(0);
//        FFU.setEmailID("gg@mail");
//        FFU.setPhoneNumber("9899756987");
//
//        FFUDAO.changeUser(FFU);
//        FlipFitUser FFU2 = FFUDAO.getUser(644);
//        System.out.println(FFU2.getEmailID());
//        System.out.println(FFU2.getPhoneNumber());
//
//    }

    @Override
    public FlipFitUser loginAsCustomer(String emailID, String password) {
        String sql = "SELECT * from user where email=? and password=? and role=3";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emailID);
            stmt.setString(2, password);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    FlipFitUser flipFitUser = new FlipFitUser();
                    flipFitUser.setEmailID(emailID);
                    flipFitUser.setPassword(password);
                    flipFitUser.setUserID(rs.getInt("user_id"));
                    flipFitUser.setRoleID(rs.getInt("role"));
                    flipFitUser.setUserName(rs.getString("user_name"));
                    return flipFitUser;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FlipFitUser loginAsOwner(String emailID, String password) {
        String sql = "SELECT * from user where email=? and password=? and role=2";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emailID);
            stmt.setString(2, password);

            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    FlipFitUser flipFitUser = new FlipFitUser();
                    flipFitUser.setEmailID(emailID);
                    flipFitUser.setPassword(password);
                    flipFitUser.setUserID(rs.getInt("user_id"));
                    flipFitUser.setRoleID(rs.getInt("role"));
                    flipFitUser.setUserName(rs.getString("user_name"));
                    return flipFitUser;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(FlipFitUser FFU) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            FFU.setUserID(rand.nextInt(1000));
            stmt.setInt(1,FFU.getUserID());
            stmt.setInt(2, FFU.getUserID());
            stmt.setInt(3, FFU.getRoleID());
            stmt.setString(5, FFU.getPhoneNumber());
            stmt.setString(4, FFU.getEmailID());
            stmt.setString(6, FFU.getPassword());


            int i = stmt.executeUpdate();
            System.out.println(i + " user added");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteUser(FlipFitUser FFU) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM user WHERE user_id=(?)");

            stmt.setInt(1, FFU.getUserID());

            int i = stmt.executeUpdate();
            System.out.println(i + " user removed");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void changeUser(FlipFitUser FFU) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement(("UPDATE user SET user_name = ?, role =? , email = ?, phone = ?, password = ? WHERE user_id = ?"));

            stmt.setInt(1,FFU.getUserID());
            stmt.setInt(2, FFU.getUserID());
            stmt.setInt(3, FFU.getRoleID());
            stmt.setString(5, FFU.getPhoneNumber());
            stmt.setString(4, FFU.getEmailID());
            stmt.setString(6, FFU.getPassword());

            int i = stmt.executeUpdate();
            System.out.println(i + " user changed");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public FlipFitUser getUser(int userID) {
        FlipFitUser FFU = new FlipFitUser();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM user WHERE user_id = ?");
            stmt.setInt(1, userID);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            FFU.setUserName(rs.getString("user_name"));
            FFU.setUserID(rs.getInt("user_id"));
            FFU.setPassword(rs.getString("password"));
            FFU.setPhoneNumber(rs.getString("phone"));
            FFU.setRoleID(rs.getInt("role"));
            FFU.setEmailID(rs.getString("email"));

            int i = stmt.executeUpdate();
            System.out.println(i + " user fetched");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return FFU;
    }
}
