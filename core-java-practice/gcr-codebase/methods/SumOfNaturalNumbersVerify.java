import java.util.*;

public class SumOfNaturalNumbersVerify {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int formula = naturalSum(n);
        int recursion = naturalSumRecurssion(n);

        System.out.println(formula);
        System.out.println(recursion);

        if (formula == recursion) {
            System.out.println("Both are equal");
        }

        sc.close();
    }

    // Method using formula
    public static int naturalSum(int n) {
        return (n * (n + 1)) / 2;
    }

    // Method using recursion
    public static int naturalSumRecurssion(int n) {
        if (n == 1)
            return n;

        return n + naturalSumRecurssion(n - 1);
    }
}
