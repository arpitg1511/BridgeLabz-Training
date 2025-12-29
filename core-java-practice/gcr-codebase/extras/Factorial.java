import java.util.*;

public class Factorial {

    public static void main(String[] args) {

        // Take input number
        int n = input();

        // Calculate factorial using recursion
        int ans = factorial(n);

        // Display the result
        display(ans);
    }

    // Method to read integer input
    public static int input() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        return n;
    }

    // Recursive method to calculate factorial
    public static int factorial(int n) {

        // Base case
        if (n == 1) 
            return 1;

        // Recursive call
        return n * factorial(n - 1);
    }

    // Method to display the factorial result
    public static void display(int ans) {
        System.out.println("Factorial of the given number is: " + ans);
    }
}
