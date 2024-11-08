package com.flipfit.business.interfaces;

import com.flipfit.bean.*;
import com.flipfit.exceptions.AdminLoginFailedException;
import com.flipfit.exceptions.OwnerDeletionFailedException;
import com.flipfit.exceptions.OwnerNotFoundException;

import java.util.List;

public interface IFlipFitAdmin {
    public boolean adminLogin(FlipFitAdmin flipFitAdmin) throws AdminLoginFailedException;
    public List<FlipFitGymOwner> getPendingOwnerList();
    public List<FlipFitGymOwner> getApprovedOwnerList();
    public List<FlipFitGymCustomer> getUserList();
    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId) throws OwnerNotFoundException;
    public boolean validateOwner(int ownerId) throws OwnerNotFoundException;
    public boolean deleteOwner(int ownerId) throws OwnerNotFoundException, OwnerDeletionFailedException;
}
