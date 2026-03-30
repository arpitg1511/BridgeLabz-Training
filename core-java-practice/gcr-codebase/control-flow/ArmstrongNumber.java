import java.util.*;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int originalNumber = number;
        int sum = 0;

        // Loop until originalNumber becomes 0
        while (originalNumber != 0) {
            int digit = originalNumber % 10;   // get last digit
            sum = sum + (digit * digit * digit); // add cube of digit
            originalNumber = originalNumber / 10; // remove last digit
        }

        // Check Armstrong condition
        if (sum == number) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }

        sc.close();
    }
}
