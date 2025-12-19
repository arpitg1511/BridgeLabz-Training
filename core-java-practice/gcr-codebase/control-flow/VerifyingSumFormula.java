import java.util.*;

public class VerifyingSumFormula {
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
        int i = 1;

        // Compute sum using while loop
        while (i <= n) {
            sum += i;
            i++;
        }

        // Compute sum using formula n*(n+1)/2
        int formulaSum = n * (n + 1) / 2;

        // Compare both results
        if (sum == formulaSum) {
            System.out.println("Both results are correct");
        } else {
            System.out.println("Results are not matching");
        }

        System.out.println("Sum using while loop: " + sum);
        System.out.println("Sum using formula: " + formulaSum);

        sc.close();
    }
}
