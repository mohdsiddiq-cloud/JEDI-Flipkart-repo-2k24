package com.flipfit.dao;

import com.flipfit.bean.*;
import com.flipfit.dao.interfaces.IFlipFitGymOwnerDAO;
import java.util.Random;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerDAOImpl implements IFlipFitGymOwnerDAO {
    Random rand = new Random();
    @Override
    public FlipFitGymCentre addCentre(FlipFitGymCentre centre) {
        String sql = "INSERT INTO flipfit_gym_center (gym_owner_id, capacity, approved, city, state, pincode) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, centre.getOwnerID());
            stmt.setInt(2, centre.getCapacity());
            stmt.setBoolean(3, centre.isApproved());
            stmt.setString(4, centre.getCity());
            stmt.setString(5, centre.getState());
            stmt.setString(6, centre.getPincode());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating centre failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int centreID = generatedKeys.getInt(1);
                    centre.setCentreID(centreID);
                } else {
                    throw new SQLException("Creating centre failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return centre;
    }

    @Override
    public List<FlipFitGymCentre> viewCentresByOwnerID(FlipFitGymOwner owner) {
        List<FlipFitGymCentre> gymcentres = new ArrayList<>();
        int userId = owner.getUserId();
        String sql = "SELECT center_id, gym_owner_id, capacity, city, state, pincode FROM flipfit_gym_center where gym_owner_id=?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitGymCentre gymcentre = new FlipFitGymCentre();
                gymcentre.setCentreID(rs.getInt("center_id"));
                gymcentre.setOwnerID(rs.getInt("gym_owner_id"));
                gymcentre.setCapacity(rs.getInt("capacity"));
                gymcentre.setCity(rs.getString("city"));
                gymcentre.setState(rs.getString("state"));
                gymcentre.setPincode(rs.getString("pincode"));
                gymcentres.add(gymcentre);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return gymcentres;
    }

//    @Override
//    public List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre centre) {
//        List<FlipFitUser> flipfitusers = new ArrayList<>();
//        String sql = "SELECT * from Booking where userID = ? and isDeleted = false";
//        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
//            stmt.setInt(1, centre.getOwnerID());
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                FlipFitUser flipfituser = new FlipFitUser();
//                flipfituser.setUserID(rs.getInt("userID"));
//                flipfitusers.add(flipfituser);
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return flipfitusers;
//   }




    @Override
    public FlipFitGymOwner editDetails(FlipFitGymOwner owner) {
        int userId = owner.getUserId();
        String sql = "UPDATE flipfit_gym_owner_pi SET pan_id=?, adhaar_number=? ,gst_number=? WHERE owner_id=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, owner.getPanId());
            stmt.setString(2, owner.getAadharNumber());
            stmt.setString(3,owner.getGSTNum());
            stmt.setInt(4, userId);
            try{
                int count= stmt.executeUpdate();
                if(count>0) {
                    return owner;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    public FlipFitGymOwner addGymOwner(FlipFitGymOwner owner) {


        String sql = "INSERT INTO user (user_name, role, email, phone, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, owner.getUserName());
            stmt.setInt(2, owner.getRole());
            stmt.setString(3, owner.getEmailID());
            stmt.setString(4, owner.getPhoneNumber());
            stmt.setString(5, owner.getPassword());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int userID = generatedKeys.getInt(1);
                    owner.setUserId(userID);

                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return owner;
        }

        sql = "INSERT INTO flipfit_gym_owner_pi (owner_id ,pan_id, adhaar_number, gst_number, is_approved_by_admin) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, owner.getUserId());
            stmt.setString(2, owner.getPanId());
            stmt.setString(3, owner.getAadharNumber());
            stmt.setString(4, owner.getGSTNum());
            stmt.setBoolean(5, owner.getIsApproved());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating owner failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return owner;
    }




    public static void main(String[] args) {
//        FlipFitUser user = new FlipFitUser();
//        user.setEmailID("dee@gmail.com");
////        user.setUserID(1);
//        user.setPassword("123@123");
//        user.setPhoneNumber("1234567890");
//        user.setUserName("DEEP");
//        user.setRoleID(3);

        FlipFitGymOwner owner = new FlipFitGymOwner();
        owner.setCity("xyz");
        owner.setPinCode("123");
        owner.setUserName("Sidque");
        owner.setPassword("xyz");
        owner.setEmailID("xyz@gmail.commingw");
        owner.setPhoneNumber("1234255");
        owner.setRole(2);
        owner.setAadharNumber("123454");
        owner.setPanId("DKJDHD");
        owner.setGSTIN("GST123362");
        owner.setIsApproved(false);
        owner.setUserId(4);

        System.out.println(owner.getUserName());

//        addUser(user);
        FlipFitGymOwner own= new FlipFitGymOwnerDAOImpl().editDetails(owner);

        System.out.println(owner.getUserId());

//
//        FlipFitGymCentre center = new FlipFitGymCentre();
//
//        center.setOwnerID(owner.getUserId());
//        center.setCapacity(5);
//        center.setCity("HYDD");
//        center.setState("TGS");
//        center.setPincode("5063212");
//        center.setApproved(false);
//
//        new FlipFitGymOwnerDAOImpl().addCentre(center);


    }

}