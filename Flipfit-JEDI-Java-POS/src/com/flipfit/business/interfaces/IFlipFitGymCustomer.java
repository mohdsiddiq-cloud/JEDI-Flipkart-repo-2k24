package com.flipfit.business.interfaces;

import com.flipfit.exceptions.FlipFitBusinessException;
import com.flipfit.exceptions.FlipFitLoginException;
import com.flipfit.exceptions.InvalidChoiceException;
import com.flipkart.exceptions.InvalidChoiceException;
import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.bean.FlipFitGymCustomer;
import com.flipfit.bean.FlipFitUser;

import java.util.List;

public interface IFlipFitGymCustomer {
    public List<FlipFitBooking> viewBookedSlots(int userId) throws FlipFitBusinessException;
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime) throws FlipFitBusinessException;
    public List<FlipFitGymCentre> viewCentres() throws FlipFitBusinessException;
    public boolean makePayment(int userId) throws FlipFitBusinessException;
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer flipFitGymCustomer) throws InvalidChoiceException, InvalidChoiceException, FlipFitBusinessException;
    public FlipFitUser login(FlipFitUser flipFitUser) throws FlipFitBusinessException, FlipFitLoginException;
    public FlipFitGymCustomer registerCustomer(FlipFitGymCustomer flipFitGymCustomer) throws FlipFitBusinessException;
}
