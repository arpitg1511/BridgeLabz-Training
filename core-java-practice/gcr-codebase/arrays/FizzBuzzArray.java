import java.util.*;

public class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        // Check for positive integer
        if (number <= 0) {
            sc.close();
            return;
        }

        String[] result = new String[number + 1];

        // Store values
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i] = "Fizz";
            } else if (i % 5 == 0) {
                result[i] = "Buzz";
            } else {
                result[i] = String.valueOf(i);
            }
        }

        // Print output
        for (int i = 1; i <= number; i++) {
            System.out.println(result[i]);
        }

        sc.close();
    }
}
