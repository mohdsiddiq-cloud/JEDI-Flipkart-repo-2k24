
package com.flipfit.business;

import java.util.List;
import java.util.HashMap;
import java.util.Scanner;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.dao.FlipFitGymOwnerDAOImpl;
import com.flipfit.dao.FlipFitGymOwnerDAOInterface;
import com.flipfit.dao.UpdatePasswordDAOImpl;
import com.flipfit.dao.UpdatePasswordDAOInterface;

/**
 * Implementation of FlipFitGymOwnerService for managing gym owners.
 */
public class FlipFitGymOwnerServiceOperation implements FlipFitGymOwnerService {

    // HashMap to store gym owners
    HashMap<String, FlipFitGymOwner> flipFitGymOwners = new HashMap<>();

    // DAO interface for gym owner operations
    FlipFitGymOwnerDAOInterface flipFitGymOwnerDAOInterface = new FlipFitGymOwnerDAOImpl();

    // Scanner object for user input
    Scanner obj = new Scanner(System.in);

    // DAO interface for password update operations
    UpdatePasswordDAOInterface updatePasswordInterface = new UpdatePasswordDAOImpl();

    int id = 0; // ID tracker (not used in current implementation)

    @Override
    public void addGymWithSlots(FlipFitGym flipFitGym) {
        flipFitGymOwnerDAOInterface.addGym(flipFitGym); // Delegate to DAO to add gym with slots
    }

    @Override
    public List<FlipFitGym> viewMyGyms(int userId) {
        return flipFitGymOwnerDAOInterface.viewGymSlots(userId); // Delegate to DAO to view gyms for a user
    }

    @Override
    public boolean validateLogin(String email, String password) {
        return updatePasswordInterface.verifyGymUserPassword(email, password); // Delegate to DAO to validate login
//		if(gymOwnerDaoInterface.validateLogin(email,password)) return true;
//      return false;
    }

    @Override
    public void createGymOwner(FlipFitGymOwner flipFitGymOwner) {
        flipFitGymOwnerDAOInterface.newGymOwner(flipFitGymOwner); // Delegate to DAO to create a new gym owner
    }

    @Override
    public boolean verifyGymOwnerPassword(String email, String password) {
        return updatePasswordInterface.verifyGymUserPassword(email, password); // Delegate to DAO to verify gym owner's password
    }

    @Override
    public void updateGymOwnerPassword(String email, String password, String updatedPassword) {
        updatePasswordInterface.updateGymOwnerPassword(email, password, updatedPassword); // Delegate to DAO to update gym owner's password
    }

}

