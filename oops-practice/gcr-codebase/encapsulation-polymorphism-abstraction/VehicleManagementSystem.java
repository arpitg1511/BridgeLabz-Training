// interface for insurance related operations
interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}

// abstract base class for all vehicles
abstract class Vehicle implements Insurable {

    private final String vehicleNumber;
    private String type;
    protected double rentalRate;

    // constructor
    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // abstract method
    abstract double calculateRentalCost(int days);

    // getters
    String getVehicleNumber() {
        return vehicleNumber;
    }

    String getType() {
        return type;
    }
}

// car
class Car extends Vehicle {

    Car(String number, double rate) {
        super(number, "Car", rate);
    }

    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 500;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Car Insurance Applied");
    }
}

// bike
class Bike extends Vehicle {

    Bike(String number, double rate) {
        super(number, "Bike", rate);
    }

    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days * 0.9;
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Bike Insurance Applied");
    }
}

// truck
class Truck extends Vehicle {

    Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    @Override
    double calculateRentalCost(int days) {
        return rentalRate * days * 1.2;
    }

    @Override
    public double calculateInsurance() {
        return 1000;
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Truck Insurance Applied");
    }
}

// main class
public class VehicleManagementSystem {

    // polymorphic method (same pattern as earlier questions)
    static void printVehicleDetails(Vehicle v, int days) {

        System.out.println("Vehicle Number : " + v.getVehicleNumber());
        System.out.println("Type           : " + v.getType());
        System.out.println("Rental Cost    : " + v.calculateRentalCost(days));
        System.out.println("Insurance Cost : " + v.calculateInsurance());
        v.getInsuranceDetails();
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        Vehicle car = new Car("UP32CAR01", 1500);
        Vehicle bike = new Bike("UP32BIKE02", 500);
        Vehicle truck = new Truck("UP32TRUCK03", 3000);

        printVehicleDetails(car, 5);
        printVehicleDetails(bike, 5);
        printVehicleDetails(truck, 5);
    }
}
