
package com.flipfit.bean;

import java.util.List;

public class FlipFitGym {
    private int gymId; 
    private String gymName; 
    private String gymAddress; 
    private String location; 
    private List<FlipFitSlots> flipFitSlots;
    private int ownerId;
    private String status; 

    public int getOwnerId() {
        return ownerId; // Retrieves the owner ID of the gym.
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId; // Sets the owner ID of the gym.
    }

    public String getStatus() {
        return status; // Retrieves the status of the gym.
    }

    public void setStatus(String status) {
        this.status = status; // Sets the status of the gym.
    }

    public List<FlipFitSlots> getSlots() {
        return flipFitSlots; // Retrieves the list of slots available in the gym.
    }

    public void setSlots(List<FlipFitSlots> flipFitSlots) {
        this.flipFitSlots = flipFitSlots; // Sets the list of slots available in the gym.
    }

    public int getGymId() {
        return gymId; // Retrieves the gym ID.
    }

    public void setGymId(int gymId) {
        this.gymId = gymId; // Sets the gym ID.
    }

    public String getGymName() {
        return gymName; // Retrieves the name of the gym.
    }

    public void setGymName(String gymName) {
        this.gymName = gymName; // Sets the name of the gym.
    }

    public String getGymAddress() {
        return gymAddress; // Retrieves the address of the gym.
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress; // Sets the address of the gym.
    }

    public String getLocation() {
        return location; // Retrieves the location of the gym.
    }

    public void setLocation(String location) {
        this.location = location; // Sets the location of the gym.
    }
}
