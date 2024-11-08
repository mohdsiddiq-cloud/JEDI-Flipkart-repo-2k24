package com.flipfit.business;
import com.flipfit.dao.FlipFitGymCustomerDAOImpl;
import com.flipfit.dao.interfaces.IFlipFitBookingDAO;
import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.dao.FlipFitBookingDAOImpl;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.exceptions.BookingConflictException;
import com.flipfit.exceptions.BookingNotFoundException;
import com.flipfit.exceptions.FlipFitBusinessException;
import com.flipfit.exceptions.SlotNotAvailableException;

public class BookingsBusiness {
    private final IFlipFitBookingDAO bookingDAO;

    public BookingsBusiness(FlipFitBookingDAOImpl FFBooking) {
        this.bookingDAO = FFBooking;
    }

    public FlipFitBooking makeBooking(int userID, int centreID, int startTime) throws SlotNotAvailableException, BookingConflictException, FlipFitBusinessException {
        FlipFitSlotDAOImpl slotDAO = new FlipFitSlotDAOImpl();
        FlipFitSlots slotDetails = slotDAO.getSlotDetails(startTime, centreID);

        if (slotDetails == null || slotDetails.getSeatsAvailable() <= 0) {
            throw new SlotNotAvailableException("No available seats for the selected slot.");
        }

        FlipFitGymCustomerDAOImpl FFGymCustomer = new FlipFitGymCustomerDAOImpl();
        FlipFitGymCustomerBusiness flipFitGymCustomerBusiness = new FlipFitGymCustomerBusiness(FFGymCustomer);

        FlipFitBooking existingBooking = flipFitGymCustomerBusiness.checkBookingConflicts(userID, startTime);
        if (existingBooking != null) {
            try {
                deleteBooking(existingBooking.getBookingId()); // Handle conflict by deleting existing booking
            } catch (BookingNotFoundException e) {
                e.printStackTrace();
            }
        }

        FlipFitBooking booking = new FlipFitBooking();
        booking.setSlotId(slotDetails.getSlotId());
        booking.setSlotTime(slotDetails.getSlotTime());
        booking.setUserId(userID);
        booking.setIsdeleted(false);

        bookingDAO.makeBooking(booking);

        // Update seat availability
        slotDetails.setSeatsAvailable(slotDetails.getSeatsAvailable() - 1);
        FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
        flipFitSlotsBusiness.updateAvailability(slotDetails);

        return booking;
    }

    public boolean deleteBooking(int bookingId) throws BookingNotFoundException, FlipFitBusinessException {
        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        FlipFitBooking bookingDetails = bookingDAO.getBookingDetailsByBookingId(bookingId);

        if (bookingDetails == null) {
            throw new BookingNotFoundException("Booking with ID " + bookingId + " not found.");
        }

        int slotId = bookingDetails.getSlotId();
        FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
        FlipFitSlots flipFitSlots = flipFitSlotDAO.getSlotDetailsById(slotId);

        if (flipFitSlots != null) {
            flipFitSlots.setSeatsAvailable(flipFitSlots.getSeatsAvailable() + 1);
            FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
            flipFitSlotsBusiness.updateAvailability(flipFitSlots);
        }

        bookingDAO.deleteBooking(bookingId);
        return true;
    }
}