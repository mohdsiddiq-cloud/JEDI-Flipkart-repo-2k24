package com.flipfit.application;

import java.util.Scanner;

public class GymFlipFitAdminMenu {
    public static void getAdminView(){

            Scanner sc=new Scanner(System.in);
            System.out.println("Gym Admin Menu (1 to 4) ");

            System.out.println("1. View Pending Requests");
            System.out.println("2. View Approved Owners");
            System.out.println("3. View all FlipFit Customers");
            System.out.println("4. View all Centres Using OwnerId");
            int choice=sc.nextInt();

            switch (choice){
                case 1:{
                    System.out.println("these are the pending request");
                    break;
                }
                case 2:{
                    System.out.println("Printing list of Approved Owners");
                    break;
                }
                case 3:{
                    System.out.println("All Flipfit Customers");
                    break;
                }
                case 4:{
                    System.out.println("All Flipfit Centres");

                    break;
                }
                default:
                {
                    System.out.println("Invalid Choice Entered");
                }
            }

    }
}
