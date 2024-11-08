package com.flipfit.business.interfaces;

import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.exceptions.GymCentreDeletionFailedException;
import com.flipfit.exceptions.GymCentreUpdateFailedException;

import java.util.List;

public interface IFlipFitGymCentre {
    public FlipFitGymCentre updateGymCentre(FlipFitGymCentre flipFitGymCentre) throws GymCentreUpdateFailedException;
    public boolean deleteGymCentre(int centreId) throws GymCentreDeletionFailedException;
    public List<FlipFitSlots> viewAvailableSlots(int centreId);
}
