package com.flipfit.Application;

import com.flipfit.bean.FlipFitAdmin;
import com.flipfit.bean.FlipFitGymCustomer;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.business.FlipFitSlotsBusiness;

public class Main {
    public static void main(String[] args){
        FlipFitGymCustomer customer=new FlipFitGymCustomer();
        FlipFitGymOwner gymOwner=new FlipFitGymOwner();
        FlipFitAdmin admin=new FlipFitAdmin();
        customer.getUserName();
        gymOwner.getAadharNumber();
        admin.getUserID();
        FlipFitSlotsBusiness slots=new FlipFitSlotsBusiness();
        slots.getSlotDetails();
    }
}
