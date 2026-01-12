import java.util.*;

// Flight class
class Flight {

    private int flightId;
    private String source;
    private String destination;
    private int seatsAvailable;

    Flight(int flightId, String source, String destination, int seatsAvailable) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }

    int getFlightId() {
        return flightId;
    }

    String getSource() {
        return source;
    }

    String getDestination() {
        return destination;
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    void bookSeat() {
        seatsAvailable--;
    }

    void displayFlight() {
        System.out.println("Flight ID : " + flightId);
        System.out.println("From      : " + source);
        System.out.println("To        : " + destination);
        System.out.println("Seats     : " + seatsAvailable);
        System.out.println("--------------------------");
    }
}

// Booking class
class Booking {

    private String passengerName;
    private Flight flight;

    Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    void displayBooking() {
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Flight ID      : " + flight.getFlightId());
        System.out.println("Route          : " +
                flight.getSource() + " to " + flight.getDestination());
        System.out.println("--------------------------");
    }
}

// MAIN CLASS
public class FlightBookingSystem {

    // Array to store available flights
    static Flight[] flights = {
            new Flight(101, "Delhi", "Mumbai", 3),
            new Flight(102, "Delhi", "Bangalore", 2),
            new Flight(103, "Mumbai", "Chennai", 1)
    };

    // List to store bookings
    static List<Booking> bookings = new ArrayList<>();

    // search flight (case-insensitive)
    static void searchFlights(String source, String destination) {

        boolean found = false;

        for (Flight f : flights) {
            if (f.getSource().equalsIgnoreCase(source)
                    && f.getDestination().equalsIgnoreCase(destination)) {

                f.displayFlight();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No flights found.");
        }
    }

    // book flight
    static void bookFlight(int flightId, String passengerName) {

        for (Flight f : flights) {
            if (f.getFlightId() == flightId && f.getSeatsAvailable() > 0) {

                f.bookSeat();
                bookings.add(new Booking(passengerName, f));
                System.out.println("Booking successful!");
                return;
            }
        }

        System.out.println("Flight not available or no seats left.");
    }

    // display all bookings
    static void displayBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings done yet.");
            return;
        }

        for (Booking b : bookings) {
            b.displayBooking();
        }
    }

    // main method
    public static void main(String[] args) {

        // search flights
        System.out.println("Searching Flights (Delhi -> Mumbai)");
        searchFlights("delhi", "mumbai");

        // book flights
        bookFlight(101, "Amit");
        bookFlight(101, "Rohit");

        // display bookings
        System.out.println("Booking Details:");
        displayBookings();
    }
}
