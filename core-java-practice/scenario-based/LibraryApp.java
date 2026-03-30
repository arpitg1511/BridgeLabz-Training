import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int FINE_PER_DAY = 5;

        // Loop for 5 books
        for (int book = 1; book <= 5; book++) {

            System.out.println("\n--- Book " + book + " ---");

            System.out.print("Enter due date (day number): ");
            int dueDate = sc.nextInt();

            System.out.print("Enter return date (day number): ");
            int returnDate = sc.nextInt();

            // Check for late return
            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * FINE_PER_DAY;

                System.out.println("Returned late by " + lateDays + " days.");
                System.out.println("Fine to be paid: ₹" + fine);
            } else {
                System.out.println("Returned on time. No fine.");
            }
        }

        sc.close();
    }
}
