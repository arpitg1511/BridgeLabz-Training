package ride_management_system;

public class Driver {

    private final int driverId;
    private String name;
    private boolean available;

    Driver(int id, String name) {
        this.driverId = id;
        this.name = name;
        this.available = true;
    }

    boolean isAvailable() {
        return available;
    }

    void assignRide() {
        available = false;
    }

    void completeRide() {
        available = true;
    }

    String getName() {
        return name;
    }
}
