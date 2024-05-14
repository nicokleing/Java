package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import java.util.stream.Collectors;
import java.util.*;

public class ReservationService {
    private static final ReservationService instance = new ReservationService();
    private final Map<String, IRoom> rooms = new HashMap<>();  // Stores all rooms by room number
    private final Collection<Reservation> reservations = new ArrayList<>();  // List of all reservations

    // Private constructor to enforce Singleton pattern
    private ReservationService() {}

    // Singleton access method
    public static ReservationService getInstance() {
        return instance;
    }

    // Adds a room to the system
    public void addRoom(IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    // Retrieves a room by room number
    public IRoom getARoom(String roomId) {
        return rooms.get(roomId);
    }

    // Returns all rooms as a collection
    public Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    // Creates a new reservation and adds it to the list
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    // Finds available rooms that are not booked during the specified date range
    public Collection<IRoom> findAvailableRooms(Date checkIn, Date checkOut) {
        return rooms.values().stream()
                .filter(room -> isRoomAvailable(room, checkIn, checkOut))
                .collect(Collectors.toList());
    }

    // Helper method to check if a room is available for booking
    private boolean isRoomAvailable(IRoom room, Date checkIn, Date checkOut) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().equals(room) &&
                    !checkOut.before(reservation.getCheckInDate()) && !checkIn.after(reservation.getCheckOutDate())) {
                return false;
            }
        }
        return true;
    }

    // Retrieves all reservations for a particular customer
    public Collection<Reservation> getCustomersReservation(Customer customer) {
        return reservations.stream()
                .filter(reservation -> reservation.getCustomer().equals(customer))
                .collect(Collectors.toList());
    }

    // Prints all reservations
    public void printAllReservations() {
        reservations.forEach(System.out::println);
    }
}
