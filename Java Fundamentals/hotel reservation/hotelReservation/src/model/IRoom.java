package model;

/**
 * Interface representing the general contract for rooms in the hotel reservation system.
 * This interface ensures that all types of rooms, regardless of their specific characteristics,
 * conform to a standard set of behaviors.
 */
public interface IRoom {
    /**
     * Retrieves the unique room number assigned to the room.
     * @return A string representing the room number.
     */
    String getRoomNumber();

    /**
     * Retrieves the price per night for the room.
     * @return A Double value representing the nightly rate for the room.
     */
    Double getRoomPrice();

    /**
     * Retrieves the type of the room, which can be SINGLE or DOUBLE.
     * @return An enum value of RoomType indicating the type of room.
     */
    RoomType getRoomType();

    /**
     * Determines if the room is free of charge.
     * @return A boolean where true indicates the room is free (no charge), and false otherwise.
     */
    boolean isFree();
}
