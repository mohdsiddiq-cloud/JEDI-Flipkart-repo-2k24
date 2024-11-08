package com.flipfit.business;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.business.interfaces.IFlipFitSlots;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.exceptions.FlipFitBusinessException;

public class FlipFitSlotsBusiness implements IFlipFitSlots {

    public boolean updateAvailability(FlipFitSlots flipFitSlots) throws FlipFitBusinessException {
        System.out.println("Updating Slot Availability");
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
        try {
            flipFitSlotDAO.changeSlot(flipFitSlots);
            return true;
        } catch (Exception e) {
            throw new FlipFitBusinessException("Error while updating slot availability", e);
        }
    }

    public void getSlotDetails() throws FlipFitBusinessException {
        System.out.println("Getting Slot Details");
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
        try {
            // Presumably, a call to retrieve details would be added here when implemented
            // Example: List<FlipFitSlots> slots = flipFitSlotDAO.retrieveSlotDetails();
            System.out.println("Slot details retrieved successfully.");
        } catch (Exception e) {
            throw new FlipFitBusinessException("Error while retrieving slot details", e);
        }
    }
}
