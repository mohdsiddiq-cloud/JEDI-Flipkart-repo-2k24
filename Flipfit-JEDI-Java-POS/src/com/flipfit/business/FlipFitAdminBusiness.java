package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.business.interfaces.IFlipFitAdmin;


import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminBusiness implements IFlipFitAdmin {


    public boolean adminLogin(FlipFitAdmin flipFitAdmin){
        System.out.println("AdminUserBusiness.adminLogin");
        return true;
    }
    public List<FlipFitGymOwner> getPendingOwnerList(){
        System.out.println("AdminUserBusiness.getPendingOwnerList");
        return new ArrayList<>();
    }
    public List<FlipFitGymOwner> getApprovedOwnerList(){
        System.out.println("AdminUserBusiness.getApprovedOwnerList");
        return new ArrayList<>();
    }
    public List<FlipFitGymCustomer> getUserList(){
        System.out.println("AdminUserBusiness.getUserList");
        return new ArrayList<>();
    }
    public boolean validateOwner(int ownerId){
        return true;
    }
    public boolean deleteOwner(int ownerId){
        System.out.println("AdminUserBusiness.deleteOwner" + ownerId);
        return true;
    }
    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId){
        System.out.println("AdminUserBusiness.getGymCentreUsingOwnerId "+ownerId);
        return new ArrayList<>();
    }

}
