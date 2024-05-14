package ui;

import model.Room;
import model.RoomType;
import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Date;
import java.util.Collection;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class AdminMenu {
    private static final ReservationService reservationService = ReservationService.getInstance();
    private static final CustomerService customerService = CustomerService.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayAdminMenu() {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. See all customers");
            System.out.println("2. See all rooms");
            System.out.println("3. Find available rooms");
            System.out.println("4. See all reservations");
            System.out.println("5. Add a room");
            System.out.println("6. Back to Main Menu");

            System.out.print("Please select a number for the menu option: ");
            int selection = Integer.parseInt(scanner.nextLine());

            switch (selection) {
                case 1:
                    displayAllCustomers();
                    break;
                case 2:
                    displayAllRooms();
                    break;
                case 3:
                    displayAvailableRooms();
                    break;
                case 4:
                    displayAllReservations();
                    break;
                case 5:
                    addRoom();
                    break;
                case 6:
                    System.out.println("Returning to Main Menu...");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
            }
        }
    }

    private static void displayAllCustomers() {
        try {
            Collection<Customer> customers = customerService.getAllCustomers();
            if (customers.isEmpty()) {
                System.out.println("No customers found.");
            } else {
                customers.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error displaying customers: " + e.getMessage());
        }
    }

    private static void displayAllRooms() {
        try {
            Collection<IRoom> rooms = reservationService.getAllRooms();
            if (rooms.isEmpty()) {
                System.out.println("No rooms found.");
            } else {
                rooms.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error displaying rooms: " + e.getMessage());
        }
    }

    private static void displayAllReservations() {
        try {
            reservationService.printAllReservations();
        } catch (Exception e) {
            System.out.println("Error displaying reservations: " + e.getMessage());
        }
    }

    private static void addRoom() {
        try {
            System.out.println("Enter room number:");
            String roomNumber = scanner.nextLine();

            double price = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Enter price per night:");
                    price = Double.parseDouble(scanner.nextLine());
                    if (price < 0) {
                        System.out.println("Price cannot be negative. Please enter a valid price.");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price entered. Please enter a valid numeric value.");
                }
            }

            RoomType roomType = null;
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Enter room type (SINGLE, DOUBLE):");
                    String roomTypeInput = scanner.nextLine().toUpperCase();
                    roomType = RoomType.valueOf(roomTypeInput);
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid room type entered. Please choose either SINGLE or DOUBLE.");
                }
            }

            Room room = new Room(roomNumber, price, roomType);
            reservationService.addRoom(room);
            System.out.println("Room added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding room: " + e.getMessage());
        }
    }

    private static void displayAvailableRooms() {
        System.out.println("Enter Check-In Date (dd/MM/yyyy): ");
        Date checkIn = parseDate(scanner.nextLine());
        System.out.println("Enter Check-Out Date (dd/MM/yyyy): ");
        Date checkOut = parseDate(scanner.nextLine());

        if (checkIn == null || checkOut == null) {
            return; // Exit if the dates are invalid
        }

        Collection<IRoom> availableRooms = reservationService.findAvailableRooms(checkIn, checkOut);
        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms for the selected dates.");
        } else {
            availableRooms.forEach(System.out::println);
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
