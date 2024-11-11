//package com.flipkart.validator;
//
//import com.flipkart.bean.FlipFitBookings;
//import com.flipkart.bean.FlipFitUser;
//import com.flipkart.utils.DatabaseConnector;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CustomerValidator {
//
//    public boolean IsUserAlreadyRegistered(String UserEmail, String Phone)
//    {
//        conn = DatabaseConnector.getConnection();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<FlipFitUser> user = new ArrayList<>();
//        String ViewUserQuery=  "SELECT * FROM User where email=? OR phoneNumber=?";
//        try {
//            preparedStatement = conn.prepareStatement(ViewUserQuery);
//            preparedStatement.setString(1, UserEmail);
//            preparedStatement.setString(2, Phone);
//            resultSet = preparedStatement.executeQuery();
//
//            if(resultSet!=null)
//                return true;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        return false;
//
//    }
//
//    public boolean IsSlotAlreadyRegistered(String email, int time, int GymId)
//    {
//        conn = DatabaseConnector.getConnection();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<FlipFitBookings> bookings = new ArrayList<>();
//        String ViewBookingQuery=  "SELECT userID, time, gymId FROM Booking where UserEmail=?";
//        try {
//            preparedStatement = conn.prepareStatement(ViewBookingQuery);
//            preparedStatement.setString(1, email);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                int UserId = resultSet.getInt("userID");
//                int slot_time = resultSet.getInt("time");
//                int gym_id  = resultSet.getInt("gymId");
//
//                FlipFitBookings flipFitbooking = new FlipFitBookings();
//                flipFitbooking.setUserId(UserId);
//                flipFitbooking.setTime(slot_time);
//                flipFitbooking.setGymId(gym_id);
//                bookings.add(flipFitbooking);
//
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        for (FlipFitBookings booking: bookings) {
//            if (booking.getTime() == time && booking.getGymId() == GymId)
//                return true;
//        }
//
//        return false;
//
//    }
//}
