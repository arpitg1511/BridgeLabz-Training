package ride_management_system;

import java.util.*;

public class RideService {

    private List<Ride> rideHistory = new ArrayList<>();
    private int rideCounter = 1;

    Ride bookRide(
            User user,
            List<Driver> drivers,
            double distance,
            FareCalculator fareCalculator
    ) throws NoDriverAvailableException {

        Driver assignedDriver = null;

        for (Driver d : drivers) {
            if (d.isAvailable()) {
                assignedDriver = d;
                d.assignRide();
                break;
            }
        }

        if (assignedDriver == null) {
            throw new NoDriverAvailableException("No drivers available");
        }

        double fare = fareCalculator.calculateFare(distance);
        Ride ride = new Ride(rideCounter++, user, assignedDriver, fare);
        rideHistory.add(ride);

        return ride;
    }

    void completeRide(Ride ride, Driver driver) {
        driver.completeRide();
        System.out.println("Ride completed");
    }

    void showRideHistory() {
        for (Ride r : rideHistory) {
            r.displayRide();
        }
    }
}
