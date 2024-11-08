package com.flipfit.business.interfaces;

import com.flipfit.exceptions.GymOwnerNotFoundException;
import com.flipfit.exceptions.InvalidChoiceException;
import com.flipfit.bean.*;
import com.flipfit.exceptions.InvalidLoginException;
import com.flipfit.exceptions.NoSlotsFoundException;

import java.util.List;

public interface IFlipFitGymOwner {
    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre) throws InvalidChoiceException;
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner flipFitGymOwner) throws GymOwnerNotFoundException;
//    public  List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre flipFitGymCentre);
    public List<FlipFitPayments> viewPayments();
    public FlipFitGymOwner editDetails(FlipFitGymOwner flipFitGymOwner) throws InvalidChoiceException, GymOwnerNotFoundException;
    public FlipFitGymOwner registerOwner(FlipFitGymOwner owner);
    public FlipFitUser login(FlipFitUser user) throws InvalidLoginException;

    FlipFitSlots addSlot(FlipFitSlots flipFitSlot) throws NoSlotsFoundException;
}
