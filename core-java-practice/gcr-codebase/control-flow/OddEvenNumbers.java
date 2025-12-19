import java.util.*;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        // Check whether the number is a natural number
        if (number <= 0) {
            sc.close();
            return;
        }

        // Iterate from 1 to the given number
        for (int i = 1; i <= number; i++) {

            // Check whether the current number is even or odd
            if (i % 2 == 0) {
                System.out.println(i + " is an even number");
            } else {
                System.out.println(i + " is an odd number");
            }
        }

        sc.close();
    }
}
