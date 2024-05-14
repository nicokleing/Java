package ui;

import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    private static final HotelResource hotelResource = HotelResource.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("\nWelcome to the Hotel Reservation Application");
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");

            try {
                System.out.print("Please select a number for the menu option: ");
                int selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1:
                        findAndReserveRoom();
                        break;
                    case 2:
                        seeReservations();
                        break;
                    case 3:
                        createAccount();
                        break;
                    case 4:
                        AdminMenu.displayAdminMenu();
                        break;
                    case 5:
                        System.out.println("Exiting application...");
                        keepRunning = false;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static void findAndReserveRoom() {
        try {
            System.out.println("Enter Check-In Date (dd/MM/yyyy): ");
            Date checkIn = parseDate(scanner.nextLine());
            System.out.println("Enter Check-Out Date (dd/MM/yyyy): ");
            Date checkOut = parseDate(scanner.nextLine());

            if (checkIn == null || checkOut == null) {
                return; // Exit if the dates are invalid
            }

            Collection<IRoom> availableRooms = hotelResource.findAvailableRooms(checkIn, checkOut);
            if (availableRooms.isEmpty()) {
                System.out.println("No available rooms for the selected dates.");
            } else {
                availableRooms.forEach(System.out::println);
                System.out.println("Enter room number to reserve:");
                String roomNumber = scanner.nextLine();
                IRoom room = hotelResource.getRoom(roomNumber);
                if (room == null) {
                    System.out.println("Room not found.");
                    return;
                }
                System.out.println("Enter your email address:");
                String email = scanner.nextLine();
                try {
                    Reservation reservation = hotelResource.bookARoom(email, room, checkIn, checkOut);
                    System.out.println("Reservation successful: " + reservation);
                } catch (Exception e) {
                    System.out.println("Error making reservation: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
    }

    private static void seeReservations() {
        try {
            System.out.println("Please enter your email address:");
            String email = scanner.nextLine();
            Collection<Reservation> reservations = hotelResource.getCustomersReservations(email);
            if (reservations.isEmpty()) {
                System.out.println("No reservations found.");
            } else {
                reservations.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving reservations: " + e.getMessage());
        }
    }

    private static void createAccount() {
        try {
            System.out.println("Enter your first name:");
            String firstName = scanner.nextLine();
            System.out.println("Enter your last name:");
            String lastName = scanner.nextLine();
            System.out.println("Enter your email address:");
            String email = scanner.nextLine();
            hotelResource.createACustomer(email, firstName, lastName);
            System.out.println("Account created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating account: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false); // Set lenient to false to strictly validate date
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return null; // Return null if the date format is incorrect
        }
    }
}
