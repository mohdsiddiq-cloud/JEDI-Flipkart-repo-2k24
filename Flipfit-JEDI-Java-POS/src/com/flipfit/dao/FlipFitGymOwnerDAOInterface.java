

package com.flipfit.dao;

import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitSlots;

import java.util.List;

public interface FlipFitGymOwnerDAOInterface {

    /**
     * Insert slots for a gym into the database.
     * @param flipFitSlots List of FlipFitSlots to insert
     * @param gymId ID of the gym for which slots are to be inserted
     */
    void insertSlots(List<FlipFitSlots> flipFitSlots, int gymId);

    /**
     * Retrieve gyms and their slots associated with a gym owner.
     * @param gymOwnerID ID of the gym owner
     * @return List of FlipFitGym objects with associated slots
     */
    List<FlipFitGym> viewGymSlots(int gymOwnerID);

    /**
     * Add a new gym to the database.
     * @param flipFitGym FlipFitGym object representing the gym to add
     */
    void addGym(FlipFitGym flipFitGym);

    /**
     * Register a new gym owner in the database.
     * @param flipFitGymOwner FlipFitGymOwner object representing the gym owner to register
     */
    void newGymOwner(FlipFitGymOwner flipFitGymOwner);

    /**
     * Validate login credentials of a gym owner.
     * @param email Email of the gym owner
     * @param password Password of the gym owner
     * @return true if login is successful, false otherwise
     */
    boolean validateLogin(String email, String password);
}
