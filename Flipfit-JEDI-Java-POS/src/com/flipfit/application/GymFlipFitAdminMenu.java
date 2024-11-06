package com.flipfit.application;

import java.util.Scanner;

public class GymFlipFitAdminMenu {
    public static void getAdminView(){

            Scanner sc=new Scanner(System.in);
            System.out.println("Gym Admin Menu (1 to 5) ");

            System.out.println("1. View Pending Requests");
            System.out.println("2. View Approved Owners");
            System.out.println("3. View all FlipFit Customers");
            System.out.println("4. View all Centres Using OwnerId");
            System.out.println("5. Update Profile");
            int choice=sc.nextInt();

            switch (choice){
                case 1:{
                    System.out.println("these are the pending request");
                    break;
                }
                case 2:{
                    System.out.println("Printing list of Approved Owners");

                    System.out.println("Choose  (1 or 2) ");

                    System.out.println("1. Delete Owner");
                    System.out.println("2. Update Owner");

                    int num= sc.nextInt();

                    switch (num){
                        case 1: {
                            System.out.println("Owner Deleted Successfully");
                            break;
                        }
                        case 2:{
                            System.out.println("Owner Profile Updated");
                            break;
                        }
                        default:{
                            System.out.println("invalid Choice");
                        }
                    }


                    break;
                }
                case 3:{
                    System.out.println("All Flipfit Customers");

                    System.out.println("Choose  (1 or 2) ");

                    System.out.println("1. Delete Customer");
                    System.out.println("2. Update Customer");
                    int num= sc.nextInt();
                    switch (num){
                        case 1: {
                            System.out.println("Customer Deleted Successfully");
                            break;
                        }
                        case 2:{
                            System.out.println("Customer Profile Updated");
                            break;
                        }
                        default:{
                            System.out.println("invalid Choice");
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("All Flipfit Centres");

                    break;
                }
                case 5:{
                    System.out.println("Update Admin Profile");
                    break;
                }
                default:
                {
                    System.out.println("Invalid Choice Entered");
                }
            }

    }
}
