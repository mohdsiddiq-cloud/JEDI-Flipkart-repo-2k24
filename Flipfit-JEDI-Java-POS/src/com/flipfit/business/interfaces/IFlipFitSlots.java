package com.flipfit.business.interfaces;

import com.flipfit.bean.FlipFitSlots;
import com.flipfit.exceptions.FlipFitBusinessException;

public interface IFlipFitSlots {
    public boolean updateAvailability(FlipFitSlots flipFitSlots) throws FlipFitBusinessException;
    public void getSlotDetails() throws FlipFitBusinessException;
}
