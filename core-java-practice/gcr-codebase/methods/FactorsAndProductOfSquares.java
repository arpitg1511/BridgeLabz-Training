import java.util.*;

public class FactorsAndProductOfSquares {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[countFactors(n)];
        storeFactors(arr, n);

        System.out.println("Factors are : " + Arrays.toString(arr));
        System.out.println("Sum of squares is : " + sumOfSquares(arr));
        System.out.println("Product of factors is : " + productOfFactors(arr));

        sc.close();
    }

    // Method to count factors
    public static int countFactors(int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) c++;
        }
        return c;
    }

    // Method to store factors
    public static void storeFactors(int[] arr, int n) {
        int k = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                arr[k] = i;
                k++;
            }
        }
    }

    // Method to calculate sum of squares
    public static int sumOfSquares(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i] * arr[i];
        }
        return ans;
    }

    // Method to calculate product of factors
    public static int productOfFactors(int[] arr) {
        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            ans *= arr[i];
        }
        return ans;
    }
}
