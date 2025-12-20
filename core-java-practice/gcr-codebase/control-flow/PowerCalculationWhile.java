import java.util.Scanner;

public class PowerCalculationWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int power = sc.nextInt();

        // Proceed only if inputs are positive
        if (number > 0 && power > 0) {
            int result = 1;
            int i = 1;

            while (i <= power) {
                result = result * number;
            }

            System.out.println(result);
        }

        sc.close();
    }
}
