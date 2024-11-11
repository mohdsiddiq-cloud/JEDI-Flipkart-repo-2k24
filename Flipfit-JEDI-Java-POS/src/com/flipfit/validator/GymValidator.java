//package com.flipkart.validator;
//
//import com.flipkart.utils.DatabaseConnector;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class GymValidator {
//    public boolean IsGymAlreadyRegistered(String GymName, String GymAddress)
//    {
//        conn = DatabaseConnector.getConnection();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        String ViewGymQuery=  "SELECT * FROM gyms where gymName=? AND gymAddress=?";
//        try {
//            preparedStatement = conn.prepareStatement(ViewGymQuery);
//            preparedStatement.setString(1, GymName);
//            preparedStatement.setString(2, GymAddress);
//
//            resultSet = preparedStatement.executeQuery();
//            System.out.println(resultSet);
//
//            if(resultSet.next())
//                return true;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        finally {
//            // Close resources in the finally block to avoid resource leaks
//            try {
//                if (resultSet != null) resultSet.close();
//                if (preparedStatement != null) preparedStatement.close();
//            } catch (SQLException e) {
//                System.out.println(e);// Handle closing exceptions
//            }
//        }
//
//        return false;
//
//    }
//
//}
