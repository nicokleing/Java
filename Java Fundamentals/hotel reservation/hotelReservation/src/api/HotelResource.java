package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    // Singleton instance of HotelResource for global access
    private static HotelResource hotelResource = new HotelResource();

    // Service for accessing customer-related operations
    private CustomerService customerService = CustomerService.getInstance();

    // Service for accessing room and reservation-related operations
    private ReservationService reservationService = ReservationService.getInstance();

    // Private constructor to prevent external instantiation
    private HotelResource() {}

    // Method to get the singleton instance of HotelResource
    public static HotelResource getInstance() {
        return hotelResource;
    }

    // Fetches a customer by their email
    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    // Creates a new customer with email, first name, and last name
    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    // Retrieves a room by its number
    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    // Books a room for a customer for specified check-in and check-out dates
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = getCustomer(customerEmail); // Reuse the method to fetch customer
        return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    // Retrieves all reservations for a specific customer by their email
    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        Customer customer = getCustomer(customerEmail); // Reuse the method to fetch customer
        return reservationService.getCustomersReservation(customer);
    }

    // Finds all available rooms for given check-in and check-out dates
    public Collection<IRoom> findAvailableRooms(Date checkIn, Date checkOut) {
        return reservationService.findAvailableRooms(checkIn, checkOut);
    }
}
