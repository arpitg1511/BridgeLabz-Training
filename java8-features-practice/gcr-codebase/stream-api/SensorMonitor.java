import java.util.Arrays;
import java.util.List;

public class SensorMonitor {

    public static void main(String[] args) {

        List<Double> sensorReadings = Arrays.asList(
                22.5, 35.0, 18.9, 42.3, 30.1
        );

        double threshold = 30.0;

        sensorReadings.stream()
                .filter(reading -> reading > threshold)
                .forEach(reading ->
                        System.out.println("Alert! Reading: " + reading)
                );
    }
}
