// interface for rent related operations
interface IRentable {
    double calculateRent(int days);
}

// abstract base class
abstract class Vehicle implements IRentable {

    private final String vehicleNumber;
    private String type;
    protected double rentPerDay; // protected as required

    Vehicle(String vehicleNumber, String type, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentPerDay = rentPerDay;
    }

    String getVehicleNumber() {
        return vehicleNumber;
    }

    String getType() {
        return type;
    }
}

// Car class
class Car extends Vehicle {

    Car(String number, double rentPerDay) {
        super(number, "Car", rentPerDay);
    }

    @Override
    public double calculateRent(int days) {
        return rentPerDay * days;
    }
}

// Bike class
class Bike extends Vehicle {

    Bike(String number, double rentPerDay) {
        super(number, "Bike", rentPerDay);
    }

    @Override
    public double calculateRent(int days) {
        return rentPerDay * days * 0.9; // discount
    }
}

// Truck class
class Truck extends Vehicle {

    Truck(String number, double rentPerDay) {
        super(number, "Truck", rentPerDay);
    }

    @Override
    public double calculateRent(int days) {
        return rentPerDay * days * 1.2; // extra charge
    }
}

// Customer class
class Customer {

    private int customerId;
    private String customerName;

    Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    void displayCustomer() {
        System.out.println("Customer ID   : " + customerId);
        System.out.println("Customer Name : " + customerName);
    }
}

// MAIN CLASS
public class RentalManagementSystem {

    // polymorphic method
    static void printRentalDetails(Vehicle v, int days) {
        System.out.println("Vehicle Number : " + v.getVehicleNumber());
        System.out.println("Vehicle Type   : " + v.getType());
        System.out.println("Rent (" + days + " days) : " + v.calculateRent(days));
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        Customer customer = new Customer(1, "Amit");

        Vehicle car = new Car("UP32CAR01", 1500);
        Vehicle bike = new Bike("UP32BIKE02", 500);
        Vehicle truck = new Truck("UP32TRUCK03", 3000);

        customer.displayCustomer();
        System.out.println("------------------------------");

        printRentalDetails(car, 5);
        printRentalDetails(bike, 5);
        printRentalDetails(truck, 5);
    }
}
