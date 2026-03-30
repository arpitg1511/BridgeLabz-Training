import java.util.*;

public class PositiveOrNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5];

        // Read 5 numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        // Check each number
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                System.out.println("Negative");
            } else if (numbers[i] == 0) {
                System.out.println("Zero");
            } else {
                if (numbers[i] % 2 == 0) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            }
        }

        // Compare first and last elements
        if (numbers[0] == numbers[4]) {
            System.out.println("Equal");
        } else if (numbers[0] < numbers[4]) {
            System.out.println("Last element is greater");
        } else {
            System.out.println("First Element is Greater");
        }

        sc.close();
    }
}
