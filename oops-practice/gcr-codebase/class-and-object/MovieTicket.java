import java.util.*;
public class MovieTicket {

    // Ticket details
    String movieName;
    String seatNumber;
    double price;
    boolean booked = false;

    // Method to book the ticket
    void bookTicket(String movieName, String seatNumber, double price) {

        // Check if ticket is already booked
        if (booked) {
            System.out.println("House full!!! sorry..... Ticket already booked");
            return;
        }

        // Assign ticket details
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        booked = true;

        System.out.println("Ticket booked for movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
    }

    // Method to display ticket details
    void displayTicket() {

        // If ticket is not booked
        if (!booked) {
            System.out.println("Ticket have not booked yet....");
            return;
        }

        // Display ticket info
        System.out.println("Ticket booked for movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        MovieTicket ticket = new MovieTicket();

        // Before booking
        ticket.displayTicket();

        Scanner sc = new Scanner(System.in);
        String movie = sc.nextLine();
        String seatNumber = sc.next();
        double price = sc.nextDouble();
        // Book ticket
        ticket.bookTicket(movie, seatNumber, price);

        // Try booking again
        ticket.bookTicket(movie, seatNumber, price);
        ticket.bookTicket(movie, seatNumber, price);

        // Display final ticket details
        ticket.displayTicket();
        
        sc.close();
    }
}
