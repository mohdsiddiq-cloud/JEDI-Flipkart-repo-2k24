

package com.flipfit.dao;

import com.flipfit.bean.FlipFitBookings;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitUser;

import java.util.List;

/**
 * Interface for Customer DAO operations in FlipFit gym booking system.
 */
public interface FlipFitCustomerDAOInterface {

    /**
     * Retrieves all gyms from the database filtered by area.
     *
     * @return List of FlipFitGym objects representing gyms in the area.
     */
    List<FlipFitGym> getAllGymsByArea();

    /**
     * Books a slot in a gym for a user.
     *
     * @param gymId ID of the gym where the slot is booked.
     * @param time  Time slot to book.
     * @param email Email of the user booking the slot.
     * @return true if booking is successful, false otherwise.
     */
    boolean bookSlot(int gymId, int time, String email);

    /**
     * Retrieves all bookings made by a user.
     *
     * @param userEmail ID of the user whose bookings are retrieved.
     * @return List of FlipFitBookings representing bookings made by the user.
     */
    List<FlipFitBookings> getAllBookingByUserID(String userEmail);

    /**
     * Cancels a booking based on booking ID.
     *
     * @param bookingId ID of the booking to cancel.
     * @return true if cancellation is successful, false otherwise.
     */
    boolean cancelBooking(int bookingId);

    /**
     * Validates user credentials.
     *
     * @param username Username (email) of the user.
     * @param pass     Password of the user.
     * @return true if credentials are valid, false otherwise.
     */
    boolean validateUser(String username, String pass);

    /**
     * Creates a new user in the database.
     *
     * @param flipFitUser FlipFitUser object containing user details.
     */
    void createUser(FlipFitUser flipFitUser);
}
