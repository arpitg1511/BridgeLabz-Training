import java.util.*;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] heights = new double[11];
        double sum = 0;

        // Read heights and calculate sum
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }

        System.out.printf("%.2f", sum / 11);

        sc.close();
    }
}
