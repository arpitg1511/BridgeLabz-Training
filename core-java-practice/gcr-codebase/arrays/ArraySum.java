import java.util.*;

public class ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Read values until limit or stop condition
        while (true) {
            double value = sc.nextDouble();

            if (value <= 0 || index == 10) {
                break;
            }

            numbers[index] = value;
            index++;
        }

        // Display numbers and calculate sum
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println(total);

        sc.close();
    }
}
