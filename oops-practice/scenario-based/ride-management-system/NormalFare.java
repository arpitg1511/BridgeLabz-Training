package ride_management_system;

public class NormalFare implements FareCalculator {

    @Override
    public double calculateFare(double distance) {
        return distance * 10;
    }
}
