import java.util.*;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();   // Take input

        int maxFactor = 10;          // Initial size
        int[] factors = new int[maxFactor];
        int index = 0;

        // Loop from 1 to number
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {

                // If array is full, increase size
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2;
                    int[] temp = new int[maxFactor];

                    for (int j = 0; j < index; j++) {
                        temp[j] = factors[j];
                    }

                    factors = temp;
                }

                factors[index] = i; // Store factor
                index++;
            }
        }

        // Display factors
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        sc.close();
    }
}
