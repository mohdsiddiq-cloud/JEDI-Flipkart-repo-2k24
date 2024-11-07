package com.flipfit.dao;

import com.flipfit.bean.*;
import com.flipfit.dao.interfaces.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminDAOImpl implements  IFlipFitAdminDAO {
    @Override
    public boolean adminLogin(FlipFitAdmin flipFitAdmin) {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ? and role= '1' ";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, flipFitAdmin.getEmailID());
            stmt.setString(2, flipFitAdmin.getPassword());

            try (ResultSet rs = stmt.executeQuery()) {
                boolean res= rs.next();
                if(res){
                    System.out.println("Logged in Successfully");
                }
                else{
                    System.out.println("Invalid Credentials!!!!");
                }
                return res;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Logged in Failed");
            return false;
        }
    }

    @Override
    public List<FlipFitGymOwner> getPendingOwnerList() {
        List<FlipFitGymOwner> pendingOwners = new ArrayList<>();
        String sql = "SELECT user_id, adhaar_number FROM flipfit_gym_owner_pi WHERE is_approved_by_admin = 0";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FlipFitGymOwner owner = new FlipFitGymOwner();
                owner.setUserId(rs.getInt("user_id"));
                owner.setAadharNumber(rs.getString("adhaar_number"));
                pendingOwners.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingOwners;
    }
    @Override
    public List<FlipFitGymOwner> getApprovedOwnerList() {
        List<FlipFitGymOwner> pendingOwners = new ArrayList<>();
        String sql = "SELECT * FROM flipfit_gym_owner_pi WHERE is_approved_by_admin = 1";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FlipFitGymOwner owner = new FlipFitGymOwner();
                owner.setUserId(rs.getInt("user_id"));
                owner.setAadharNumber(rs.getString("adhaar_number"));
                pendingOwners.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingOwners;
    }


    @Override
    public List<FlipFitGymCustomer> getUserList() {
        List<FlipFitGymCustomer> users = new ArrayList<>();
        String sql = "SELECT * FROM user where role='3'";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Assuming you have a User class
                FlipFitGymCustomer user = new FlipFitGymCustomer(); // Replace with actual User class
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean validateOwner(int ownerId) {
        String sql = "UPDATE flipfit_gym_owner_pi SET is_approved_by_admin = 1 WHERE user_id = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ownerId);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteOwner(int ownerId) {
        String sql = "DELETE FROM flipfit_gym_owner_pi WHERE user_id = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ownerId);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId) {
        List<FlipFitGymCentre> gymCentres = new ArrayList<>();
        String sql = "SELECT * FROM flipfit_gym_center WHERE gym_owner_id = ? AND approved = 1";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ownerId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FlipFitGymCentre gymCentre = new FlipFitGymCentre();
                    gymCentre.setCentreID(rs.getInt("center_id"));
                    gymCentre.setCapacity(rs.getInt("capacity"));
                    gymCentre.setCity(rs.getString("city"));
                    gymCentres.add(gymCentre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the error or throwing a custom exception
        }
        return gymCentres;
    }


}

