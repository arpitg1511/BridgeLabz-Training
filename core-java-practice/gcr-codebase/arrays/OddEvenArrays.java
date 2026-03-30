import java.util.*;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        // Check for natural number
        if (number <= 0) {
            System.out.println("Invalid number");
            System.exit(0);
        }

        int[] odd = new int[number / 2 + 1];
        int[] even = new int[number / 2 + 1];

        int oddIndex = 0;
        int evenIndex = 0;

        // Store odd and even numbers
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
            } else {
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print odd numbers
        for (int i = 0; i < oddIndex; i++) {
            System.out.println(odd[i]);
        }

        // Print even numbers
        for (int i = 0; i < evenIndex; i++) {
            System.out.println(even[i]);
        }

        sc.close();
    }
}
