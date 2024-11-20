package com.profo.kennel;

import java.util.Scanner;

public class TravelSimulation {
    public static void main(String[] args) {
        // Create locations
        Location cleveland = new Location("Cleveland", 0, 0, true);
        Location chicago = new Location("Chicago", -200, 75, true);
        Location northPole = new Location("North Pole", 500, -100, true);
        Location campbellHill = new Location("Campbell Hill", -50, -50, false);
        Location tokyo = new Location("Tokyo", -100, 1000, true);
        Location erie = new Location("Erie PA", 150, 0, true);
        Location allegheny = new Location("Allegheny National Forest", 300, -75, false);

        Location[] locations = {cleveland, chicago, northPole, campbellHill, tokyo, erie, allegheny};

        // Create vehicle
        Vehicle car = new Vehicle(cleveland, 15.0, 25.0); // 15 gallons, 25 MPG
        System.out.println("Simulation Started!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCurrent Location: " + car.getCurrentLocation().getName());
            System.out.println("Current Fuel: " + car.getCurrentFuel() + " gallons");
            System.out.println("1. Drive to another location");
            System.out.println("2. Refuel");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                // Drive to another location
                System.out.println("Available Locations:");
                for (int i = 0; i < locations.length; i++) {
                    System.out.println((i + 1) + ". " + locations[i].getName());
                }
                System.out.print("Enter the number of the destination: ");
                int destinationIndex = scanner.nextInt() - 1;

                if (destinationIndex >= 0 && destinationIndex < locations.length) {
                    Location destination = locations[destinationIndex];
                    car.driveTo(destination);
                } else {
                    System.out.println("Invalid choice.");
                }
            } else if (choice == 2) {
                // Refuel
                car.refuel();
            } else if (choice == 3) {
                // Exit
                System.out.println("Simulation Ended.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}