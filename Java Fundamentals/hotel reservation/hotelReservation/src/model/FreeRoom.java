package model;

/**
 * Represents a room that is free of charge in the hotel reservation system.
 * Extends the Room class, utilizing its properties and methods.
 */
public class FreeRoom extends Room {

    /**
     * Constructor for creating a FreeRoom object. It sets the room price to 0.
     * @param roomNumber The room number which is unique for each room.
     * @param roomType The type of the room (e.g., SINGLE, DOUBLE).
     */
    public FreeRoom(String roomNumber, RoomType roomType) {
        super(roomNumber, 0.0, roomType);  // Calls the superclass constructor with a price of 0.0
    }

    /**
     * Provides a string representation of the FreeRoom object.
     * @return A string that includes the room number and type, highlighting that it is a free room.
     */
    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber='" + getRoomNumber() + '\'' +  // Inherits the room number from the Room class
                ", roomType=" + getRoomType() +  // Inherits the room type from the Room class
                '}';
    }
}
