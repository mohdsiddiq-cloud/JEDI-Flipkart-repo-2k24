//import com.flipkart.utils.DatabaseConnector;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
////package com.flipkart.validator;
////
////public class GymOwnerValidator {
//public boolean IsGymOwnerAlreadyRegistered(String OwnerEmail, String Phone, String PAN, String GST, String Aadhar)
//{
//    conn = DatabaseConnector.getConnection();
//    PreparedStatement preparedStatement = null;
//    ResultSet resultSet = null;
//    String ViewUserQuery=  "SELECT * FROM gym_owner where email=? OR phone_number=? OR pancard=? OR aadhar=? OR gst=?";
//    try {
//        preparedStatement = conn.prepareStatement(ViewUserQuery);
//        preparedStatement.setString(1, OwnerEmail);
//        preparedStatement.setString(2, Phone);
//        preparedStatement.setString(3, PAN);
//        preparedStatement.setString(4, Aadhar);
//        preparedStatement.setString(5, GST);
//        resultSet = preparedStatement.executeQuery();
//
//        if(resultSet.next())
//            return true;
//    } catch (Exception e) {
//        throw new RuntimeException(e);
//    }
//    finally {
//        // Close resources in the finally block to avoid resource leaks
//        try {
//            if (resultSet != null) resultSet.close();
//            if (preparedStatement != null) preparedStatement.close();
//        } catch (SQLException e) {
//            System.out.println(e); // Handle closing exceptions
//        }
//    }
//
//    return false;
//
//}
//
////}
