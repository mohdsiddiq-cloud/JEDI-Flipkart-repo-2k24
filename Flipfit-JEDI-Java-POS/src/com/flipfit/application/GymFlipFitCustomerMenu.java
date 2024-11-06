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
                System.out.println("Choose an option (1 to 4)" +
                        "\n 1. View Booked Slots" +
                        "\n 2. View Centres" +
                        "\n 3. Logout" +
                        "\n 4. Exit "
                );
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("View Booked Slots");
                        break;
                    }
                    case 2: {
                        System.out.println("View Centres");

                        break;
                    }
                    case 3:
                    {
                        System.out.println("successful logout");
                        break;
                    }
                    case 4: {
                        System.out.println("Exit");
                        break;
                    }
                    default: {
                        System.out.println("Invalid Choice Entered");
                    }
                }
            }
            while (choice !=4 ) ;
        }
}
