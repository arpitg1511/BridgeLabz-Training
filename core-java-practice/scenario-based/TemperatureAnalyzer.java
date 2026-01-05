import java.util.*;

public class TemperatureAnalyzer {

    public static void main(String[] args) {

        // Scanner to take temperature input
        Scanner sc = new Scanner(System.in);

        // 2D array to store temperatures for 7 days and 24 hours each day
        float[][] temp = new float[7][24];

        // Taking temperature input for each day and each hour
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                temp[i][j] = sc.nextFloat();
            }
        }

        // Variables to track hottest and coldest days
        float hottest = Float.MIN_VALUE;
        int hot = 0;
        float coldest = Float.MAX_VALUE;
        int cold = 0;

        // Processing each day's temperature
        for (int i = 0; i < 7; i++) {

            float daily = 0.0f; // sum of temperatures for one day

            // Calculate total temperature of the day
            for (int j = 0; j < 24; j++) {
                daily += temp[i][j];
            }

            // Check for hottest day
            if (hottest < daily) {
                hottest = daily;
                hot = i + 1;
            }

            // Check for coldest day
            if (coldest > daily) {
                coldest = daily;
                cold = i + 1;
            }

            // Print average temperature of the day
            System.out.println("Average temperature on day " + (i + 1) + " is " + (daily / 24));
        }

        // Display hottest and coldest days
        System.out.println("Hottest day of week is " + hot);
        System.out.println("Coldest day of week is " + cold);

        sc.close();
    }
}
