package model;

/**
 * Represents a room in the hotel reservation system.
 */
public class Room implements IRoom {
    private String roomNumber;   // Unique identifier for the room
    private double price;        // Price per night for the room
    private RoomType roomType;   // Type of the room (e.g., SINGLE, DOUBLE)



    /**
     * Constructor for creating a new Room.
     *
     * @param roomNumber the unique identifier for the room
     * @param price the price per night for the room
     * @param roomType the type of the room (e.g., SINGLE, DOUBLE)
     */
    public Room(String roomNumber, double price, RoomType roomType) {
        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Room number cannot be null or empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return Double.valueOf(price);
    }



    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return price == 0;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", roomType=" + roomType +
                ", isFree=" + isFree() +
                '}';
    }

    public class FreeRoom extends Room {
        public FreeRoom(String roomNumber, RoomType roomType) {
            super(roomNumber, 0.0, roomType);
        }

        @Override
        public Double getRoomPrice() {
            return 0.0;
        }
    }

}
