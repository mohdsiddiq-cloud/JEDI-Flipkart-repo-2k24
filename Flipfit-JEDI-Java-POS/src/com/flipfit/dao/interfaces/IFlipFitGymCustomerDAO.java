package com.flipfit.dao.interfaces;

import com.flipfit.bean.*;
import com.flipfit.exceptions.GymNotFoundException;
import com.flipfit.exceptions.NoSlotsFoundException;

import java.util.List;

public interface IFlipFitGymCustomerDAO {
    public List<FlipFitSlots> viewBookedSlots(int userID) throws NoSlotsFoundException;
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime);
    public List<FlipFitGymCentre> viewCentres() throws GymNotFoundException;
    public boolean makePayment(int userID);
    public void viewPaymentDetails(int userID);
    public void editPaymentDetails(int userID);
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer customer);
    public FlipFitGymCustomer addCustomer(FlipFitGymCustomer customer);
}