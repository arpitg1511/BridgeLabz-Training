import java.util.*;

public class NumberOfChocolates {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int divisor = sc.nextInt();

        int[] result = findRemainderAndQuotient(number, divisor);

        if (result != null) {
            System.out.println(result[0] + " " + result[1]);
        }

        sc.close();
    }

    // Method to find quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {

        try {
            int quotient = number / divisor;
            int remainder = number % divisor;
            return new int[]{quotient, remainder};
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide between zero children");
            System.out.println(e);
            return null;
        }
    }
}
