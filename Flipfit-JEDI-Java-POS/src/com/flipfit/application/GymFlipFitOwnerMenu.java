package com.flipfit.application;

import com.flipfit.bean.FlipFitUser;

import java.util.Scanner;

public class GymFlipFitOwnerMenu {
    public static void getFlipFitOwnerView(FlipFitUser gymOwner){
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("Gym Owner Menu (1 to 7) ");
                System.out.println("Choose an option:" +
                        "\n 1. Add Centre" +
                        "\n 2. View Centres" +
                        "\n 3. Update slots"+
                        "\n 4. View Booking Details"+
                        "\n 5. Update Profile"+
                        "\n 6. Logout" +
                        "\n 7. Exit"
                );
                choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Give details to add Centre : ");
                        Scanner scanner = new Scanner(System.in);
                        int ownerID = gymOwner.getUserID();
                        System.out.println("Enter Capacity: ");
                        int capacity = scanner.nextInt();
                        System.out.println("Enter City: ");
                        String city = scanner.next();
                        System.out.println("Enter State: ");
                        String state = scanner.next();
                        System.out.println("Enter Pincode: ");
                        String pincode = scanner.next();

                        System.out.println("Gym Centre created successfully.");
                        break;
                    }
                    case 2: {
                        System.out.println("View Centres for the owner : ");

                        break;
                    }
                    case 3: {
                        System.out.println("Update Slots");

                        break;
                    }
                    case 4: {
                        System.out.println("Booking Details");

                        break;
                    }
                    case 5: {
                        System.out.println("Update Profile");

                        break;
                    }
                    case 6: {
                        System.out.println("Successful logout");
                        break;
                    }
                    case 7:{
                        System.out.println("Exit");
                        break;
                    }
                    default: {
                        System.out.println("Invalid Choice Entered");
                    }
                }
            }
            while (choice != 7);
        }
}
