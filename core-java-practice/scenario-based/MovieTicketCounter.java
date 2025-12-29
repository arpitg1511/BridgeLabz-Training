import java.util.*;

public class MovieTicketCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int numberOfCustomers = sc.nextInt();

        for (int customer = 1; customer <= numberOfCustomers; customer++) {

            System.out.println("\n--- Customer " + customer + " ---");

            // Movie type input
            System.out.print("Enter movie type (action/comedy/drama): ");
            String movieType = sc.next().toLowerCase();

            // Seat type input
            System.out.print("Enter seat type (gold/silver): ");
            String seatType = sc.next().toLowerCase();

            // Snacks input
            System.out.print("Do you want snacks? (yes/no): ");
            String wantsSnacks = sc.next().toLowerCase();

            int ticketPrice = 0;
            int snackPrice = 0;

            // Switch for movie type pricing
            switch (movieType) {
                case "action":
                    ticketPrice = 200;
                    break;
                case "comedy":
                    ticketPrice = 150;
                    break;
                case "drama":
                    ticketPrice = 180;
                    break;
                default:
                    System.out.println("Invalid movie type. Booking skipped.");
                    continue;
            }

            // If for seat type pricing
            if (seatType.equals("gold")) {
                ticketPrice += 100;
            } else if (seatType.equals("silver")) {
                ticketPrice += 50;
            } else {
                System.out.println("Invalid seat type. Booking skipped.");
                continue;
            }

            // If for snacks
            if (wantsSnacks.equals("yes")) {
                snackPrice = 80;
            }

            int totalBill = ticketPrice + snackPrice;

            System.out.println("\nBooking Summary:");
            System.out.println("Movie Type: " + movieType);
            System.out.println("Seat Type: " + seatType);
            System.out.println("Snacks: " + (wantsSnacks.equals("yes") ? "Yes" : "No"));
            System.out.println("Total Amount to Pay: ₹" + totalBill);
        }

        sc.close();
    }
}
