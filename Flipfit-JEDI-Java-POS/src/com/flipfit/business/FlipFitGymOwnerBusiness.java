package com.flipfit.business;

import com.flipfit.dao.*;
import com.flipfit.dao.FlipFitGymOwnerDAOImpl;
import com.flipfit.dao.interfaces.IFlipFitGymOwnerDAO;
import com.flipfit.bean.*;
import com.flipfit.business.interfaces.IFlipFitGymOwner;
import com.flipfit.exceptions.*;

import java.util.List;

public class FlipFitGymOwnerBusiness implements IFlipFitGymOwner {
    private final IFlipFitGymOwnerDAO flipFitGymOwnerDAO ;
    public FlipFitGymOwnerBusiness(FlipFitGymOwnerDAOImpl FFOwner){
        this.flipFitGymOwnerDAO= FFOwner;
    }

    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre){
        FlipFitGymCentre centre = flipFitGymOwnerDAO.addCentre(flipFitGymCentre);
        if (centre == null) {
            try {
                throw new GymCentreNotFoundException("Failed to add gym centre.");
            } catch (GymCentreNotFoundException e) {
                e.printStackTrace();
            }
        }
        return centre;
    }

    public FlipFitSlots addSlot(FlipFitSlots flipFitSlot) throws NoSlotsFoundException {
        FlipFitSlotDAOImpl flipFitSlotDAOImpl = new FlipFitSlotDAOImpl();
        FlipFitSlots slot = flipFitSlotDAOImpl.addSlot(flipFitSlot);
        if (slot == null) {
            throw new NoSlotsFoundException("Slot could not be added. It may already exist.");
        }
        return slot;
    }

    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner flipFitGymOwner) throws GymOwnerNotFoundException {
        List<FlipFitGymCentre> centres = flipFitGymOwnerDAO.viewCentresByOwnerID(flipFitGymOwner);
        if (centres.isEmpty()) {
            throw new GymOwnerNotFoundException("No centres found for the gym owner.");
        }
        System.out.println("Centres listed:> ");
        return centres;
    }
//    public List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre flipFitGymCentre) {
//        return flipFitGymOwnerDAO.viewFlipFitCustomers(flipFitGymCentre);
//    }
    public List<FlipFitPayments> viewPayments() {
        System.out.println("Payments listed:> ");
        return null;
    }
    public FlipFitGymOwner editDetails(FlipFitGymOwner owner) throws InvalidChoiceException, GymOwnerNotFoundException {
        FlipFitGymOwner updatedOwner = flipFitGymOwnerDAO.editDetails(owner);
        if (updatedOwner == null) {
            throw new GymOwnerNotFoundException("Failed to edit details. Gym owner not found.");
        }
        return updatedOwner;
    }
    public FlipFitGymOwner registerOwner(FlipFitGymOwner GymOwner) {

//        FlipFitUser user = new FlipFitUser();
//        user.setPassword(GymOwner.getPassword());
//        user.setEmailID(GymOwner.getEmailID());
//        user.setPhoneNumber(GymOwner.getPhoneNumber());
//        user.setUserName(GymOwner.getUserName());
//        user.setRoleID(2);
//        GymOwner.setRole(2);
//
//        user=flipFitGymOwnerDAO.addUser(user);
//        return flipFitGymOwnerDAO.addGymOwner(GymOwner, user);
        FlipFitGymOwner owner = flipFitGymOwnerDAO.addGymOwner(GymOwner);
        if (owner == null) {
            try {
                throw new GymOwnerNotFoundException("Failed to register the gym owner.");
            } catch (GymOwnerNotFoundException e) {
                e.printStackTrace();
            }
        }
        return owner;
    }
    @Override
    public FlipFitUser login(FlipFitUser flipFitUser) throws InvalidLoginException {
        FlipFitUserDAOImpl userDAO = new FlipFitUserDAOImpl();
        flipFitUser.setRoleID(2);
        FlipFitUser loggedInUser = userDAO.loginAsOwner(flipFitUser.getEmailID(), flipFitUser.getPassword());
        if (loggedInUser == null) {
            throw new InvalidLoginException("Invalid login credentials.");
        }
        return loggedInUser;
    }
}
