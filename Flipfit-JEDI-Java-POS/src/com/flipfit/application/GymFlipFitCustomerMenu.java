package com.flipfit.application;


import com.flipfit.bean.FlipFitUser;
import com.flipfit.business.FlipFitGymCustomerBusiness;

import java.util.Scanner;


public class GymFlipFitCustomerMenu {

    public static void getFlipFitCustomerMenu(FlipFitUser gymCustomer) {
            int userId = gymCustomer.getUserID();
            Scanner sc = new Scanner(System.in);

            int choice =0;
            do {
                System.out.println("FlipFit Customer Menu:> ");
                System.out.println("Choose an option (1 to 6)" +
                        "\n 1. View Booked Slots" +
                        "\n 2. View Centres" +
                        "\n 3. View Profile"+
                        "\n 4. Update Profile"+
                        "\n 5. Logout" +
                        "\n 6. Exit "
                );
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("View Booked Slots");
                        System.out.println("Choose  (1 or 2) ");

                        System.out.println("1. Delete Slot");
                        System.out.println("2. Update Slot");

                        int num= sc.nextInt();

                        switch (num){
                            case 1: {
                                System.out.println("Slot Deleted Successfully");
                                break;
                            }
                            case 2:{
                                System.out.println("Slot Updated");
                                break;
                            }
                            default:{
                                System.out.println("invalid Choice");
                            }
                        }

                        break;
                    }
                    case 2: {
                        System.out.println("View Centres");
                        System.out.println("Choose Centre  (1 or 2) ");

                        System.out.println("1. Centre A");
                        System.out.println("2. Centre B");

                        int num= sc.nextInt();
                        System.out.println("View Available Slots");
                        switch (num){
                            case 1: {

                                System.out.println("choose 1 for payment, else exit");
                                int n=sc.nextInt();
                                if(n==1){
                                    System.out.println("Enter your Payment mode");
                                    System.out.println("1. UPI");
                                    System.out.println("2. Card");
                                    System.out.println("3. Cash");
                                    int m=sc.nextInt();
                                    switch (m){
                                        case 1:{
                                            System.out.println("Enter your UPI");
                                            String s=sc.next();

                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Enter card details");
                                            String s=sc.next();
                                            break;
                                        }
                                        case 3:{
                                            System.out.println("payment by cash");
                                            String s=sc.next();
                                            break;
                                        }
                                        default:{
                                            System.out.println("Invalid choice");
                                        }
                                    }
                                    if(m==1 || m==2 || m==3){

                                        System.out.println("Slot for Centre A Booked Successfully");
                                    }
                                }
                                else{
                                    System.out.println("Slot not booked");
                                }

                                break;
                            }
                            case 2:{
                                System.out.println("choose 1 for payment, else exit");
                                int n=sc.nextInt();
                                if(n==1){
                                    System.out.println("Enter your Payment mode");
                                    System.out.println("1. UPI");
                                    System.out.println("2. Card");
                                    System.out.println("3. Cash");
                                    int m=sc.nextInt();
                                    switch (m){
                                        case 1:{
                                            System.out.println("Enter your UPI");
                                            String s=sc.next();
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Enter card details");
                                            String s=sc.next();
                                            break;
                                        }
                                        case 3:{
                                            System.out.println("payment by cash");
                                            String s=sc.next();
                                            break;
                                        }
                                        default:{
                                            System.out.println("Invalid choice");
                                        }
                                    }
                                    if(m==1 || m==2 || m==3){

                                        System.out.println("Slot for Centre B Booked Successfully");
                                    }
                                }
                                else{
                                    System.out.println("Slot not booked");
                                }

                                break;
                            }
                            default:{
                                System.out.println("invalid Choice");
                            }
                        }

                        break;
                    }

                    case 3: {
                        System.out.println("My Profile");
                        break;
                    }
                    case 4: {
                        System.out.println("Update Profile");
                        break;
                    }

                    case 5:
                    {
                        System.out.println("successful logout");
                        break;
                    }
                    case 6: {
                        System.out.println("Exit");
                        break;
                    }
                    default: {
                        System.out.println("Invalid Choice Entered");
                    }
                }
            }
            while (choice !=6 ) ;
        }
}
