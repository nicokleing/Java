package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    // Static instance for the singleton pattern
    private static AdminResource adminResource = new AdminResource();

    // Access to customer-related services
    private CustomerService customerService = CustomerService.getInstance();

    // Access to reservation and room-related services
    private ReservationService reservationService = ReservationService.getInstance();

    // Private constructor to prevent external instantiation
    private AdminResource() {}

    // Static method to get the singleton instance of AdminResource
    public static AdminResource getInstance() {
        return adminResource;
    }

    // Retrieves a customer by email
    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    // Adds multiple rooms to the reservation system
    public void addRoom(List<IRoom> rooms) {
        rooms.forEach(room -> reservationService.addRoom(room));
    }

    // Retrieves all rooms in the system
    public Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    // Retrieves all customers
    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Displays all reservations in the system
    public void displayAllReservations() {
        reservationService.printAllReservations();
    }
}
