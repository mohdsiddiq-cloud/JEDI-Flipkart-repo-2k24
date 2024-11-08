package com.flipfit.business;
import com.flipfit.dao.*;
import com.flipfit.bean.*;
import com.flipfit.business.interfaces.IFlipFitGymCustomer;
import java.util.List;

import com.flipfit.exceptions.FlipFitBusinessException;
import com.flipfit.exceptions.FlipFitLoginException;
import com.flipfit.exceptions.InvalidChoiceException;

public class FlipFitGymCustomerBusiness implements IFlipFitGymCustomer {
    private final FlipFitGymCustomerDAOImpl flipFitGymCustomerDAOImpl;

    public FlipFitGymCustomerBusiness(FlipFitGymCustomerDAOImpl FFGymCustomer) {
        this.flipFitGymCustomerDAOImpl = FFGymCustomer;
    }

    @Override
    public List<FlipFitBooking> viewBookedSlots(int userId) throws FlipFitBusinessException {
        System.out.println("Viewing booked slots:> ");
        try {
            FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
            FlipFitSlotDAOImpl slotDAO = new FlipFitSlotDAOImpl();
            List<FlipFitBooking> bookingsList = bookingDAO.getAllBookings(userId);

            for (FlipFitBooking booking : bookingsList) {
                FlipFitSlots slotdetails = slotDAO.getSlotDetailsById(booking.getSlotId());
                System.out.println("Booking ID: " + booking.getBookingId() + " Slot timing " + slotdetails.getSlotTime());
            }

            return bookingsList;
        } catch (Exception e) {
            throw new FlipFitBusinessException("Error while viewing booked slots for user ID " + userId, e);
        }
    }

    @Override
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime) throws FlipFitBusinessException {
        System.out.println("Checking conflict for slot " + slotTime);
        try {
            return flipFitGymCustomerDAOImpl.checkBookingConflicts(userId, slotTime);
        } catch (Exception e) {
            throw new FlipFitBusinessException("Error while checking booking conflicts for user ID " + userId, e);
        }
    }

    @Override
    public List<FlipFitGymCentre> viewCentres() throws FlipFitBusinessException {
        System.out.println("View centres called:> ");
        try {
            return flipFitGymCustomerDAOImpl.viewCentres();
        } catch (Exception e) {
            throw new FlipFitBusinessException("Error while viewing centres", e);
        }
    }

    public boolean makePayment(int userId) throws FlipFitBusinessException {
        System.out.println("Make payment called:> ");
        try {
            flipFitGymCustomerDAOImpl.makePayment(userId);
            return true;
        } catch (Exception e) {
            throw new FlipFitBusinessException("Error while making payment for user ID " + userId, e);
        }
    }

    public FlipFitGymCustomer editDetails(FlipFitGymCustomer flipFitGymCustomer) throws InvalidChoiceException, FlipFitBusinessException {
        // try
        // {
        try {
            return flipFitGymCustomerDAOImpl.editDetails(flipFitGymCustomer);
        } catch (Exception e) {
            throw new FlipFitBusinessException("Error while editing customer details", e);
        }
        // }
        // catch (InvalidChoiceException e)
        // {
        //     ExceptionHandler.InvalidChoiceEditDetailsMenu(e);
        //     return null;
        // }
    }

    @Override
    public FlipFitGymCustomer registerCustomer(FlipFitGymCustomer flipFitGymCustomer) throws FlipFitBusinessException {
        // FlipFitUser flipFitUser = new FlipFitUser();
        // flipFitUser.setPassword(flipFitGymCustomer.getPassword());
        // flipFitUser.setEmailID(flipFitGymCustomer.getEmailID());
        // flipFitUser.setPhoneNumber(flipFitGymCustomer.getPhoneNumber());
        // flipFitUser.setUserName(flipFitGymCustomer.getUserName());
        // flipFitUser.setRoleID(1);
        // flipFitGymCustomer.setRole(1);
        // flipFitGymCustomerDAOImpl.addUser(flipFitUser);
        // return flipFitGymCustomerDAOImpl.addCustomer(flipFitGymCustomer, flipFitUser);

        try {
            return flipFitGymCustomerDAOImpl.addCustomer(flipFitGymCustomer);
        } catch (Exception e) {
            throw new FlipFitBusinessException("Error while registering customer", e);
        }
    }

    @Override
    public FlipFitUser login(FlipFitUser flipFitUser) throws FlipFitLoginException {
        FlipFitUserDAOImpl userDAO = new FlipFitUserDAOImpl();
        flipFitUser.setRoleID(1);
        try {
            return userDAO.loginAsCustomer(flipFitUser.getEmailID(), flipFitUser.getPassword());
        } catch (Exception e) {
            throw new FlipFitLoginException("Error while logging in customer. Please check credentials and try again.", e);
        }
    }
}