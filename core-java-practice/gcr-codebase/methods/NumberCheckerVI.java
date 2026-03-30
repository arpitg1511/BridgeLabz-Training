import java.util.*;

public class NumberCheckerVI {

    // Method to check Perfect number
    public static boolean isPerfect(int number) {
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number && number > 0;
    }

    // Method to check Abundant number
    public static boolean isAbundant(int number) {
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum > number;
    }

    // Method to check Deficient number
    public static boolean isDeficient(int number) {
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum < number;
    }

    // Method to check Strong number
    public static boolean isStrong(int number) {
        int temp = number;
        int sum = 0;

        while (temp != 0) {
            int digit = temp % 10;
            int fact = 1;

            for (int i = 1; i <= digit; i++) {
                fact *= i;
            }

            sum += fact;
            temp /= 10;
        }
        return sum == number;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        System.out.println("Perfect Number: " + isPerfect(number));
        System.out.println("Abundant Number: " + isAbundant(number));
        System.out.println("Deficient Number: " + isDeficient(number));
        System.out.println("Strong Number: " + isStrong(number));

        sc.close();
    }
}
