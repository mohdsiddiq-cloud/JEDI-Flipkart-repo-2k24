package com.flipfit.business;
import com.flipfit.dao.interfaces.IFlipFitAdminDAO;
import com.flipfit.bean.*;
import com.flipfit.business.interfaces.IFlipFitAdmin;
import com.flipfit.dao.FlipFitAdminDAOImpl;
import com.flipfit.exceptions.AdminLoginFailedException;
import com.flipfit.exceptions.OwnerDeletionFailedException;
import com.flipfit.exceptions.OwnerNotFoundException;

import java.util.List;

public class FlipFitAdminBusiness implements IFlipFitAdmin {
    private final IFlipFitAdminDAO flipFitAdminDAOImpl;

    public FlipFitAdminBusiness(FlipFitAdminDAOImpl FFAdmin) {
        this.flipFitAdminDAOImpl = FFAdmin;
    }

    public boolean adminLogin(FlipFitAdmin flipFitAdmin) throws AdminLoginFailedException {
        System.out.println("AdminUserBusiness.adminLogin");
        boolean loginSuccess = flipFitAdminDAOImpl.adminLogin(flipFitAdmin);
        if (!loginSuccess) {
            throw new AdminLoginFailedException("Admin login failed. Please check your credentials.");
        }
        return loginSuccess;
    }

    public List<FlipFitGymOwner> getPendingOwnerList() {
        System.out.println("AdminUserBusiness.getPendingOwnerList");
        return flipFitAdminDAOImpl.getPendingOwnerList();
    }

    public List<FlipFitGymOwner> getApprovedOwnerList() {
        System.out.println("AdminUserBusiness.getApprovedOwnerList");
        return flipFitAdminDAOImpl.getApprovedOwnerList();
    }

    public List<FlipFitGymCustomer> getUserList() {
        System.out.println("AdminUserBusiness.getUserList");
        return flipFitAdminDAOImpl.getUserList();
    }

    public boolean validateOwner(int ownerId) throws OwnerNotFoundException {
        boolean isValid = flipFitAdminDAOImpl.validateOwner(ownerId);
        if (!isValid) {
            throw new OwnerNotFoundException("Owner with ID " + ownerId + " not found.");
        }
        return isValid;
    }

    public boolean deleteOwner(int ownerId) throws OwnerNotFoundException, OwnerDeletionFailedException {
        System.out.println("AdminUserBusiness.deleteOwner " + ownerId);
        boolean ownerExists = flipFitAdminDAOImpl.validateOwner(ownerId);
        if (!ownerExists) {
            throw new OwnerNotFoundException("Owner with ID " + ownerId + " does not exist.");
        }

        boolean deletionSuccess = flipFitAdminDAOImpl.deleteOwner(ownerId);
        if (!deletionSuccess) {
            throw new OwnerDeletionFailedException("Failed to delete owner with ID " + ownerId);
        }
        return deletionSuccess;
    }

    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId) throws OwnerNotFoundException {
        System.out.println("AdminUserBusiness.getGymCentreUsingOwnerId " + ownerId);
        boolean ownerExists = flipFitAdminDAOImpl.validateOwner(ownerId);
        if (!ownerExists) {
            throw new OwnerNotFoundException("Owner with ID " + ownerId + " not found.");
        }
        return flipFitAdminDAOImpl.getGymCentreUsingOwnerId(ownerId);
    }
}