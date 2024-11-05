package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.business.interfaces.IFlipFitGymOwner;
import com.flipfit.exceptions.InvalidChoiceException;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerBusiness implements IFlipFitGymOwner {

    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre){
        return new FlipFitGymCentre();
    }

    public FlipFitSlots addSlot(FlipFitSlots flipFitSlot){

        return flipFitSlot;
    }

    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner flipFitGymOwner) {
        System.out.println("Centres listed:> ");
        return new ArrayList<>();
    }


    public FlipFitGymOwner editDetails(FlipFitGymOwner owner) throws InvalidChoiceException {
        return owner;
    }
    public FlipFitGymOwner registerOwner(FlipFitGymOwner GymOwner) {
        return GymOwner;
    }
    @Override
    public FlipFitUser login(FlipFitUser flipFitUser) {
        return flipFitUser;
    }
}
