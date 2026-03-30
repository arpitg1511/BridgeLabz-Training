import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CompareDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Take first date input
        System.out.print("Enter first date (yyyy-MM-dd): ");
        String firstInput = sc.nextLine();
        LocalDate firstDate = LocalDate.parse(firstInput, formatter);

        // Take second date input
        System.out.print("Enter second date (yyyy-MM-dd): ");
        String secondInput = sc.nextLine();
        LocalDate secondDate = LocalDate.parse(secondInput, formatter);

        // Compare dates
        if (firstDate.isBefore(secondDate)) {
            System.out.println("The first date is BEFORE the second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("The first date is AFTER the second date.");
        } else if (firstDate.isEqual(secondDate)) {
            System.out.println("Both dates are SAME.");
        }

        sc.close();
    }
}
