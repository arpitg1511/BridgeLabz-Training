import java.util.function.Predicate;

public class TemperatureAlertSystem {

    public static void main(String[] args) {

        double threshold = 38.0;   // alert threshold

        // Predicate to check alert condition
        Predicate<Double> isHighTemperature =
                temp -> temp > threshold;

        double[] temperatures = {36.5, 37.2, 38.6, 39.1};

        for (double temp : temperatures) {
            if (isHighTemperature.test(temp)) {
                System.out.println("ALERT! High temperature: " + temp);
            } else {
                System.out.println("Normal temperature: " + temp);
            }
        }
    }
}
