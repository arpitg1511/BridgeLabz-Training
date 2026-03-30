
import java.util.*;

// Custom Exception
class DriverNotFoundException extends Exception {
    public DriverNotFoundException(String msg) {
        super(msg);
    }
}

// Pricing Strategy Interface
interface PricingStrategy {
    double getFare(double distance);
}

// User Entity
class User {
    private int userId;
    private String userName;

    User(int id, String name) {
        this.userId = id;
        setUserName(name);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        this.userName = name;
    }
}

// Driver Entity
class Driver {
    private int driverId;
    private String driverName;
    private boolean available = true;

    Driver(int id, String name) {
        this.driverId = id;
        setDriverName(name);
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Driver name cannot be empty");
        }
        this.driverName = name;
    }

    public boolean available() {
        return available;
    }

    public void markAvailable(boolean status) {
        this.available = status;
    }
}

// Ride Model
class Ride {
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    Ride(User user, Driver driver, double distance, double fare) {
        this.user = user;
        this.driver = driver;
        setDistance(distance);
        setFare(fare);
    }

    private void setDistance(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance should be greater than zero");
        }
        this.distance = distance;
    }

    private void setFare(double fare) {
        if (fare <= 0) {
            throw new IllegalArgumentException("Fare must be positive");
        }
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

    void printRide() {
        System.out.println(
            "User: " + user.getUserName() +
            " | Driver: " + driver.getDriverName()
        );
        System.out.println("Distance: " + distance + " km | Fare: Rs " + fare);
        System.out.println();
    }
}

// Normal Pricing
class StandardPricing implements PricingStrategy {
    private double perKmRate;

    StandardPricing(double rate) {
        this.perKmRate = rate;
    }

    @Override
    public double getFare(double distance) {
        return distance * perKmRate;
    }
}

// Peak / Surge Pricing
class SurgePricing implements PricingStrategy {
    private double surgeRate;

    SurgePricing(double rate) {
        this.surgeRate = rate;
    }

    @Override
    public double getFare(double distance) {
        return distance * surgeRate;
    }
}

// Ride Service (Booking + History)
class RideService {
    private List<Driver> driverPool = new ArrayList<>();
    private List<Ride> rideRecords = new ArrayList<>();

    public void registerDriver(Driver driver) {
        driverPool.add(driver);
    }

    public Ride createRide(User user, double distance, PricingStrategy pricing)
            throws DriverNotFoundException {

        Driver selectedDriver = null;

        for (Driver d : driverPool) {
            if (d.available()) {
                selectedDriver = d;
                break;
            }
        }

        if (selectedDriver == null) {
            throw new DriverNotFoundException("No drivers available right now");
        }

        selectedDriver.markAvailable(false);
        double fare = pricing.getFare(distance);

        Ride ride = new Ride(user, selectedDriver, distance, fare);
        rideRecords.add(ride);
        return ride;
    }

    void showRideHistory() {
        for (Ride r : rideRecords) {
            r.printRide();
        }
    }
}

// Main Class
public class RideManagementSystem {

    public static void main(String[] args) {

        RideService service = new RideService();

        service.registerDriver(new Driver(1, "Govind"));
        service.registerDriver(new Driver(2, "Akash"));

        User user = new User(1, "Hariom");

        PricingStrategy normal = new StandardPricing(10);
        PricingStrategy peak = new SurgePricing(18);

        try {
            Ride r1 = service.createRide(user, 20, normal);
            System.out.println("Ride booked. Fare: " + r1.getFare());

            Ride r2 = service.createRide(user, 15, peak);
            System.out.println("Ride booked. Fare: " + r2.getFare());

        } catch (DriverNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("\nRide History:");
        service.showRideHistory();
    }
}
