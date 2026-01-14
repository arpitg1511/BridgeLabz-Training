package ride_management_system;

public class Ride {

    private final int rideId;
    private User user;
    private Driver driver;
    private double fare;

    Ride(int id, User user, Driver driver, double fare) {
        this.rideId = id;
        this.user = user;
        this.driver = driver;
        this.fare = fare;
    }

    void displayRide() {
        System.out.println(
            "RideID: " + rideId +
            " User: " + user.getName() +
            " Driver: " + driver.getName() +
            " Fare: ₹" + fare
        );
    }
}
