import java.time.LocalDate;
import java.util.Scanner;

public class OperationsOnDate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input date
        System.out.print("Enter date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(sc.next());

        // Add 7 days
        LocalDate result = date.plusDays(7);

        // Add 1 month
        result = result.plusMonths(1);

        // Add 2 years
        result = result.plusYears(2);

        // Subtract 3 weeks
        result = result.minusWeeks(3);

        System.out.println("Final Date after calculations: " + result);

        sc.close();
    }
}
