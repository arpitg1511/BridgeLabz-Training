import java.util.*;

public class NumberChecker {

    // Method to check whether a number is positive or negative
    public static boolean isPositive(int num) {
        return num >= 0;
    }

    // Method to check whether a number is even or odd
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Method to compare two numbers
    // Returns 1 if num1 > num2, 0 if equal, -1 if num1 < num2
    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5]; // Array for 5 numbers

        // Take input for the array
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }

        // Loop through the array and check each number
        for (int i = 0; i < 5; i++) {
            int num = numbers[i];
            if (isPositive(num)) {
                if (isEven(num)) {
                    System.out.println(num + " is positive and even");
                } else {
                    System.out.println(num + " is positive and odd");
                }
            } else {
                System.out.println(num + " is negative");
            }
        }

        // Compare first and last element
        int result = compare(numbers[0], numbers[4]);
        if (result == 1) {
            System.out.println("First element is greater than last element");
        } else if (result == 0) {
            System.out.println("First element is equal to last element");
        } else {
            System.out.println("First element is less than last element");
        }

        sc.close();
    }
}
