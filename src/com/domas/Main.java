package com.domas;

import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.createRooms(5);

        System.out.println("Welcome to Paradise Hotel!");

        boolean quit = false;
        int choice = 0;
        while (!quit) {
            printInstructions();
            System.out.println("Enter your menu choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            String firstName;
            String lastName;

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    System.out.println("Enter guest's first name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter guest's last name:");
                    lastName = scanner.nextLine();
                    hotel.checkIn(new Guest(firstName, lastName));
                    break;
                case 2:
                    System.out.println("Enter guest's first name:");
                    firstName = scanner.nextLine();
                    System.out.println("Enter guest's last name:");
                    lastName = scanner.nextLine();
                    hotel.checkOut(new Guest(firstName, lastName));
                    break;
                case 3:
                    hotel.showRoomOverview();
                    break;
                case 4:
                    System.out.println("Enter room No:");
                    int roomNo = scanner.nextInt();
                    hotel.showRoomHistory(roomNo);
                    hotel.showRoomStatus(roomNo);
                    break;
                case 5:
                    System.out.println("Goodbye, have a nice day!");
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("-----------------------------------------");
        System.out.println("Press:");
        System.out.println("\t 1 - to check-in guest");
        System.out.println("\t 2 - to check-out guest");
        System.out.println("\t 3 - to show room occupancy overview");
        System.out.println("\t 4 - to show room history");
        System.out.println("\t 5 - to quit");
        System.out.println("-----------------------------------------");
    }
}
