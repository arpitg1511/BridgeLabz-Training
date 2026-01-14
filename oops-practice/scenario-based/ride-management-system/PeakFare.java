package ride_management_system;

public class PeakFare implements FareCalculator {

    @Override
    public double calculateFare(double distance) {
        return distance * 15;
    }
}
