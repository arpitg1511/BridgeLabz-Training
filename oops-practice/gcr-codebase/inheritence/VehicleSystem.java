import java.util.*;

// Interface representing refueling behavior
interface Refuelable {

    // Method that must be implemented by refuelable vehicles
    void refuel();
}

// Base class representing a generic vehicle
class Vehicle {

    String model;
    int maxSpeed;

    // Constructor to initialize common vehicle details
    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Displays common vehicle information
    void displayInfo() {
        System.out.println("Model : " + model);
        System.out.println("Max Speed : " + maxSpeed + " km/h");
    }
}

// ElectricVehicle is-a Vehicle
class ElectricVehicle extends Vehicle {

    int batteryCapacity;

    // Constructor initializes vehicle and electric-specific details
    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed); // initialize parent class fields
        this.batteryCapacity = batteryCapacity;
    }

    // Electric-specific behavior
    void charge() {
        System.out.println("Charging electric vehicle...");
        System.out.println("Battery Capacity : " + batteryCapacity + " kWh");
    }
}

// PetrolVehicle is-a Vehicle and can be refueled
class PetrolVehicle extends Vehicle implements Refuelable {

    int fuelTankCapacity;

    // Constructor initializes vehicle and petrol-specific details
    public PetrolVehicle(String model, int maxSpeed, int fuelTankCapacity) {
        super(model, maxSpeed); // initialize parent class fields
        this.fuelTankCapacity = fuelTankCapacity;
    }

    // Implementation of refueling behavior
    @Override
    public void refuel() {
        System.out.println("Refueling petrol vehicle...");
        System.out.println("Fuel Tank Capacity : " + fuelTankCapacity + " liters");
    }
}

public class VehicleSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input for Electric Vehicle
        System.out.println("Enter Electric Vehicle Details:");
        System.out.print("Model: ");
        String evModel = sc.nextLine();

        System.out.print("Max Speed: ");
        int evSpeed = sc.nextInt();

        System.out.print("Battery Capacity (kWh): ");
        int battery = sc.nextInt();
        sc.nextLine(); // clear buffer

        // Parent reference pointing to ElectricVehicle object
        Vehicle ev = new ElectricVehicle(evModel, evSpeed, battery);

        System.out.println();

        // Taking input for Petrol Vehicle
        System.out.println("Enter Petrol Vehicle Details:");
        System.out.print("Model: ");
        String pvModel = sc.nextLine();

        System.out.print("Max Speed: ");
        int pvSpeed = sc.nextInt();

        System.out.print("Fuel Tank Capacity (liters): ");
        int fuel = sc.nextInt();

        // Parent reference pointing to PetrolVehicle object
        Vehicle pv = new PetrolVehicle(pvModel, pvSpeed, fuel);

        System.out.println("\n--- Vehicle Details ---\n");

        // Display Electric Vehicle details
        ev.displayInfo();
        ((ElectricVehicle) ev).charge(); // safe downcasting

        System.out.println();

        // Display Petrol Vehicle details
        pv.displayInfo();

        // Interface reference showing hybrid inheritance
        Refuelable r = (Refuelable) pv;
        r.refuel();

        sc.close();
    }
}
