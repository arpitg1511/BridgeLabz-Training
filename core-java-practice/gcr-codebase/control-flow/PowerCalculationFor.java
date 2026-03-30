import java.util.*;

public class PowerCalculationFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int power = sc.nextInt();

        // Proceed only if inputs are positive
        if (number > 0 && power > 0) {
            int result = 1;

            for (int i = 1; i <= power; i++) {
                result = result * number;
            }

            System.out.println(result);
        }

        sc.close();
    }
}
