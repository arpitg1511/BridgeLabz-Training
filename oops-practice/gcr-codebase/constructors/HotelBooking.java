import java.util.*;

public class HotelBooking {

    // Attributes
    private String guestName;
    private String roomType;
    private int nights;

    // Default constructor
    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Method to display booking details
    public void displayBooking() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input for booking
        String name = sc.nextLine();
        String room = sc.nextLine();
        int nights = sc.nextInt();

        // Parameterized constructor
        HotelBooking booking = new HotelBooking(name, room, nights);

        // Copy constructor
        HotelBooking bookingCopy = new HotelBooking(booking);

        // Display both bookings
        booking.displayBooking();
        System.out.println();
        bookingCopy.displayBooking();

        sc.close();
    }
}
