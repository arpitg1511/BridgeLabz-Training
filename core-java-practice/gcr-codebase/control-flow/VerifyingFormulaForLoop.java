import java.util.*;

public class VerifyingFormulaForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Check whether the number is a natural number
        if (n <= 0) {
            System.out.println("Not a Natural Number");
            sc.close();
            return;
        }

        int sum = 0;

        // Compute sum using for loop
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        // Compute sum using formula n*(n+1)/2
        int formulaSum = n * (n + 1) / 2;

        // Compare both results
        if (sum == formulaSum) {
            System.out.println("Both results are correct");
        } else {
            System.out.println("Results are not matching");
        }

        System.out.println("Sum using for loop: " + sum);
        System.out.println("Sum using formula: " + formulaSum);

        sc.close();
    }
}
