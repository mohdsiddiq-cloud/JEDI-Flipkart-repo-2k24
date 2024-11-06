package com.flipfit.application;

import com.flipfit.bean.FlipFitAdmin;
import com.flipfit.bean.FlipFitGymCustomer;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;

import java.util.Scanner;

public class Flipfit {
    public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("Welcome To FlipFit App ");
                System.out.println("choose (1 to 5)" +
                        "\n 1-> Login, " +
                        "\n 2-> Registration of Customer " +
                        "\n 3-> Registration of Gym Owner " +
                        "\n 4-> Update Password " +
                        "\n 5-> Exit \n"
                );

                choice = in.nextInt();
                switch (choice) {
                    case 1: {
                        // Login
                        System.out.println("Login");
                        System.out.print("Enter your emailId:> ");
                        String username = in.next();
                        System.out.print("Enter your password:> ");
                        String password = in.next();
                        System.out.print("Enter your role:> GymCustomer/GymAdmin/GymOwner ");
                        String role = in.next();
//                        System.out.println("Login Successful");

                        switch (role) {
                            case "GymCustomer": {
                                // customer menu
                                FlipFitUser gymCustomer = new FlipFitUser();
                                gymCustomer.setEmailID(username);
                                gymCustomer.setPassword(password);
                                System.out.println("Customer Menu");
                                GymFlipFitCustomerMenu.getFlipFitCustomerMenu(gymCustomer);
                                break;
                            }
                            case "GymAdmin": {
                                // admin menu
                                FlipFitAdmin admin= new FlipFitAdmin();
                                admin.setEmailID(username);
                                admin.setPassword(password);
                                System.out.println("Admin Menu");
                                GymFlipFitAdminMenu.getAdminView();


                                break;
                            }
                            case "GymOwner": {
                                // gym owner
                                FlipFitUser gymOwner= new FlipFitUser();
                                gymOwner.setEmailID(username);
                                gymOwner.setPassword(password);

                                System.out.println("GymOwner Menu");
                                GymFlipFitOwnerMenu.getFlipFitOwnerView(gymOwner);
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Registration of gym customer");
                        System.out.println("Enter your email address:> ");
                        String emailID = in.next();
                        System.out.println("Enter your phone number:> ");
                        String phoneNumber = in.next();
                        System.out.println("Enter your city:> ");
                        String city = in.next();
                        System.out.println("Enter your pin code:> ");
                        String pinCode = in.next();
                        System.out.println("Enter your password:> ");
                        String password = in.next();
                        System.out.println("Enter username: ");
                        String username = in.next();


                        FlipFitUser gymCustomer = new FlipFitUser();
                        gymCustomer.setEmailID(emailID);
                        gymCustomer.setPassword(password);
                        gymCustomer.setPhoneNumber(phoneNumber);
                        gymCustomer.setUserName(username);

                        FlipFitGymCustomer flipFitGymCustomer=new FlipFitGymCustomer();
                        flipFitGymCustomer.setEmailID(emailID);
                        flipFitGymCustomer.setPassword(password);
                        flipFitGymCustomer.setPhoneNumber(phoneNumber);
                        flipFitGymCustomer.setUserName(username);
                        flipFitGymCustomer.setCity(city);
                        flipFitGymCustomer.setPinCode(pinCode);
                        flipFitGymCustomer.setRole(1);

                        gymCustomer.setUserID(flipFitGymCustomer.getUserId());
                        System.out.println("Registration completed");
                        System.out.println("Customer Menu");

                        GymFlipFitCustomerMenu.getFlipFitCustomerMenu(gymCustomer);
                        break;
                    }
                    case 3: {
                        System.out.println("Registration of gym owner");
                        System.out.println("Enter your email address:> ");
                        String emailID = in.next();
                        System.out.println("Enter your phone number:> ");
                        String phoneNumber = in.next();
                        System.out.println("Enter your city:> ");
                        String city = in.next();
                        System.out.println("Enter your pin code:> ");
                        String pinCode = in.next();
                        System.out.println("Enter your password:> ");
                        String password = in.next();
                        System.out.println("Enter username: ");
                        String username = in.next();
                        System.out.println("Enter your panId: ");
                        String panId = in.next();
                        System.out.println("Enter your gstNum: ");
                        String gstNum = in.next();
                        System.out.println("Enter your aadharNumber: ");
                        String aadharNumber = in.next();


                        FlipFitGymOwner flipFitOwner = new FlipFitGymOwner();
                        flipFitOwner.setEmailID(emailID);
                        flipFitOwner.setPassword(password);
                        flipFitOwner.setPhoneNumber(phoneNumber);
                        flipFitOwner.setCity(city);
                        flipFitOwner.setPinCode(pinCode);
                        flipFitOwner.setUserName(username);
                        flipFitOwner.setRole(2);
                        flipFitOwner.setGSTIN(gstNum);
                        flipFitOwner.setAadharNumber(aadharNumber);
                        flipFitOwner.setPanId(panId);
                        flipFitOwner.setIsApproved(false);

                        System.out.println("Registration completed");

                        break;
                    }
                    case 4: {
                        System.out.println("Enter your email id");
                        String email=in.next();
                        System.out.println("Enter your old Password");
                        String oldPassword= in.next();
                        System.out.println("Enter your new password");
                        String newPassword= in.next();

                        System.out.println("Successfully password updated!");
                        break;

                    }
                    case 5: {
                        System.out.println("Exit");
                        break;
                    }
                    default: {
                        System.out.println("Invalid choice entered");
                    }
                }
            }
            while (choice != 5);

    }
    }

