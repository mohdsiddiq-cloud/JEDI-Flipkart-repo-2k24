package com.flipfit.business;
import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.business.interfaces.IFlipFitGymCentre;
import com.flipfit.dao.FlipFitGymCentreDAOImpl;
import com.flipfit.exceptions.GymCentreDeletionFailedException;
import com.flipfit.exceptions.GymCentreNotFoundException;
import com.flipfit.exceptions.GymCentreUpdateFailedException;

import java.util.List;

public class FlipFitGymCentreBusiness implements IFlipFitGymCentre {
    private final FlipFitGymCentreDAOImpl gymCentreDAO;

    public FlipFitGymCentreBusiness(FlipFitGymCentreDAOImpl FFCentre) {
        this.gymCentreDAO = FFCentre;
    }

    public FlipFitGymCentre updateGymCentre(FlipFitGymCentre flipFitGymCentre) throws GymCentreUpdateFailedException {
        System.out.println("Updating Gym Centre:> ");

        try {
            gymCentreDAO.updateGymCentre(flipFitGymCentre);
        } catch (Exception e) {
            throw new GymCentreUpdateFailedException("Failed to update Gym Centre with ID " + flipFitGymCentre.getCentreID(), e);
        }

        return flipFitGymCentre;
    }

    public boolean deleteGymCentre(int centreId) throws GymCentreDeletionFailedException {
        System.out.println("Deleting Gym Centre:> ");

        try {
            FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();
            flipFitGymCentre.setCentreID(centreId);
            gymCentreDAO.deleteGymCentre(flipFitGymCentre);
        } catch (Exception e) {
            throw new GymCentreDeletionFailedException("Failed to delete Gym Centre with ID " + centreId, e);
        }

        return true;
    }

    public List<FlipFitSlots> viewAvailableSlots(int centreId) {
        System.out.println("Viewing Available Slots:> ");

        FlipFitGymCentre flipFitGymCentre = new FlipFitGymCentre();
        flipFitGymCentre.setCentreID(centreId);

        try {
            return gymCentreDAO.viewAvailableSlots(flipFitGymCentre);
        } catch (Exception e) {
            System.err.println("Error retrieving available slots for Centre ID " + centreId + ": " + e.getMessage());
            return null; // Return null or handle as per business logic
        }
    }
}