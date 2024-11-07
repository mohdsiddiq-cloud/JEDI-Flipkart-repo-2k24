package com.flipfit.dao;
import com.flipfit.bean.*;
import com.flipfit.dao.interfaces.IFlipFitGymCustomerDAO;

import java.util.*;
        import java.sql.*;


public class FlipFitGymCustomerDAOImpl implements IFlipFitGymCustomerDAO{


    public List<FlipFitSlots> viewBookedSlots(int userID) {
        List<FlipFitSlots> bookedSlots = new ArrayList<>();
        String sql = "SELECT * FROM flipfit_booking WHERE user_id = ? and is_deleted=FALSE";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(rs.getInt("slot_id"));
                bookedSlots.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookedSlots;
    }


    public FlipFitBooking checkBookingConflicts(int userId, int slotTime) {
        String sql = "SELECT * FROM flipfit_booking WHERE user_id = ? and slot_start_time = ?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userId);
            stmt.setInt(2, slotTime);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    FlipFitBooking booking = new FlipFitBooking();
                    booking.setSlotTime(rs.getInt("slot_start_time"));
                    booking.setSlotId(rs.getInt("slot_id"));
                    booking.setUserId(userId);
                    booking.setBookingId(rs.getInt("booking_id"));
                    booking.setIsdeleted(rs.getBoolean("is_deleted"));
                    return booking;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<FlipFitGymCentre> viewCentres() {
        List<FlipFitGymCentre> gymcentres = new ArrayList<>();
        String sql = "SELECT * FROM flipfit_gym_center";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitGymCentre gymcentre = new FlipFitGymCentre();
                gymcentre.setCentreID(rs.getInt("center_id"));
                gymcentre.setOwnerID(rs.getInt("gym_owner_id"));
                gymcentre.setCapacity(rs.getInt("capacity"));
                gymcentre.setCity(rs.getString("city"));
                gymcentre.setPincode(rs.getString("pincode"));
                gymcentres.add(gymcentre);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return gymcentres;
    }


    public boolean makePayment(int userID) {
        return false;
    }


    public void viewPaymentDetails(int userID) {

    }

    public void editPaymentDetails(int userID) {

    }


    public FlipFitGymCustomer editDetails(FlipFitGymCustomer customer) {
        String sql = "UPDATE user SET city=?, pincode=? WHERE user_id=? and role=3 " ;

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, customer.getCity());
            stmt.setString(2, customer.getPinCode());
            stmt.setInt(3,customer.getUserId());
            ResultSet rs = stmt.executeQuery();
            if(rs==null) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "UPDATE user SET user_name=?, password=? WHERE user_id=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, customer.getUserName());
            stmt.setString(2, customer.getPassword());
            stmt.setInt(3,customer.getUserId());
            ResultSet rs = stmt.executeQuery();
            if(rs==null) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    public FlipFitUser addUser(FlipFitUser user) {
        String sql = "INSERT INTO user (user_name, role, email, phone, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getUserName());
            stmt.setInt(2, user.getRoleID());
            stmt.setString(3, user.getEmailID());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getPassword());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int userID = generatedKeys.getInt(1);
                    user.setUserID(userID);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public FlipFitGymCustomer addCustomer(FlipFitGymCustomer customer, FlipFitUser user) {
        String sql = "INSERT INTO user (user_id, city, pincode) VALUES (?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getUserID());
            stmt.setString(2, customer.getCity());
            stmt.setString(3, customer.getPinCode());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        customer.setUserId(user.getUserID());
        return customer;
    }


    public void main(String[] args) {
        FlipFitUser user = new FlipFitUser();
        user.setEmailID("dee");
//        user.setUserID(1);
        user.setPassword("123");
        user.setPhoneNumber("123");
        user.setUserName("deepu");
        user.setRoleID(3);

        FlipFitGymCustomer customer = new FlipFitGymCustomer();
        customer.setCity("xyz");
        customer.setPinCode("123");
        customer.setUserName("deepu");
        customer.setPassword("xyz");
        customer.setEmailID("xyz");
        customer.setPhoneNumber("123");
        customer.setRole(1);
        customer.setPaymentInfo("upi");
        customer.setPaymentType(1);

        addUser(user);
        addCustomer(customer, user);
    }
}

