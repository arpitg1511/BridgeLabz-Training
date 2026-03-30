import java.util.*;

public class RunningSumWithoutNegatives {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0.0;

        // Infinite loop to keep taking input until stop condition is met
        while (true) {
            double num = sc.nextDouble();

            // If user enters 0 or a negative number, stop taking input
            if (num <= 0) {
                break;
            }

            // Add only positive numbers to the sum
            sum += num;
        }

        System.out.println(sum);
        sc.close();
    }
}
