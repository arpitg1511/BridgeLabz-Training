import java.util.Scanner; // For user input

public class CheckNaturalNumberAndSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(); // Read input number

        // Check if the number is a natural number
        if (number < 1) {
            System.out.println("The number " + number + " is not a natural number");
            return;
        }

        // Sum of first n natural numbers: n(n + 1) / 2
        int sum = (number * (number + 1)) / 2;

        System.out.println("The sum of " + number + " natural numbers is " + sum);
        sc.close();
    }
}
