// interface for GPS related operations
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// abstract base class for all ride vehicles
abstract class VehicleClass implements GPS {

    private final String vehicleId;
    private String driverName;
    protected double ratePerKm;

    // encapsulated GPS data
    private String currentLocation;

    // constructor
    VehicleClass(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Not Available";
    }

    // abstract method
    abstract double calculateFare(double distance);

    // concrete method
    void getVehicleDetails() {
        System.out.println("Vehicle ID  : " + vehicleId);
        System.out.println("Driver Name : " + driverName);
        System.out.println("Rate/Km     : " + ratePerKm);
        System.out.println("Location    : " + currentLocation);
    }

    // GPS methods
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// car
class CarClass extends VehicleClass {

    CarClass(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return distance * ratePerKm;
    }
}

// bike
class BikeClass extends VehicleClass {

    BikeClass(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return (distance * ratePerKm) * 0.9; // discount
    }
}

// auto
class AutoClass extends VehicleClass {

    AutoClass(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return (distance * ratePerKm) + 20; // base charge
    }
}

// main class
public class RideHailingApp {

    // polymorphic method
    static void calculateRideFare(VehicleClass v, double distance) {

        v.getVehicleDetails();
        System.out.println("Distance    : " + distance + " km");
        System.out.println("Fare        : " + v.calculateFare(distance));
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        VehicleClass car = new CarClass("CAR101", "Ramesh", 15);
        VehicleClass bike = new BikeClass("BIKE202", "Suresh", 10);
        VehicleClass auto = new AutoClass("AUTO303", "Mahesh", 12);

        car.updateLocation("Sector 21");
        bike.updateLocation("Railway Station");
        auto.updateLocation("Bus Stand");

        calculateRideFare(car, 12);
        calculateRideFare(bike, 12);
        calculateRideFare(auto, 12);
    }
}
