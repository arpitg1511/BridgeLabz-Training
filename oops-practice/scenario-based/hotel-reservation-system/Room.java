package hotel_reservation_system;

public class Room {

    protected int roomNumber;
    protected double basePrice;
    protected boolean available = true;

    Room(int number, double price) {
        this.roomNumber = number;
        this.basePrice = price;
    }

    double getBasePrice() {
        return basePrice;
    }

    boolean isAvailable() {
        return available;
    }

    void book() {
        available = false;
    }

    void checkout() {
        available = true;
    }
}
