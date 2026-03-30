import java.util.*;

public class WindChill {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double temperature = sc.nextDouble();
        double windSpeed = sc.nextDouble();

        System.out.println(calculateWindChill(temperature, windSpeed));

        sc.close();
    }

    // Method to calculate wind chill temperature
    public static double calculateWindChill(double temperature, double windSpeed) {

        double windChill = 35.74
                + 0.6215 * temperature
                + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);

        return windChill;
    }
}
