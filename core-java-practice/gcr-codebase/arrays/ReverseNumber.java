import java.util.*;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(); // Input number

        int temp = number;
        int count = 0;

        // Count digits
        while (temp != 0) {
            temp /= 10;
            count++;
        }

        int[] digits = new int[count];

        temp = number;
        // Store digits in array
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10; // last digit first
            temp /= 10;
        }

        // Display digits in reverse of array to get reversed number
        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]);
        }

        sc.close();
    }
}
