package ride_management_system;

import java.util.*;

public class CabBookingApp {

    public static void main(String[] args) {

        User user = new User(1, "Arpit");

        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver(101, "Ravi"));
        drivers.add(new Driver(102, "Amit"));

        RideService service = new RideService();

        FareCalculator fareCalculator = new PeakFare(); // polymorphism

        try {
            Ride ride = service.bookRide(user, drivers, 12, fareCalculator);
            ride.displayRide();

            service.completeRide(ride, drivers.get(0));
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.showRideHistory();
    }
}
