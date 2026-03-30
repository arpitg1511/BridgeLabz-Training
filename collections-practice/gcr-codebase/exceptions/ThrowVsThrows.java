import java.util.*;

public class ThrowVsThrows {

    // method declares that it may throw an exception
    static double calculateInterest(double amount, double rate, int years)
            throws IllegalArgumentException {

        if (amount < 0 || rate < 0) {
            // explicitly throwing exception
            throw new IllegalArgumentException();
        }

        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            double amount = sc.nextDouble();
            double rate = sc.nextDouble();
            int years = sc.nextInt();

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }

        sc.close();
    }
}
