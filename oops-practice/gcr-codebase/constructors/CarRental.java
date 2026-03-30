import java.util.*;

public class CarRental {

    // Attributes
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double costPerDay = 500.0; // Fixed cost per day

    // Default constructor
    public CarRental() {
        this("Guest", "Standard", 1);
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Copy constructor
    public CarRental(CarRental other) {
        this.customerName = other.customerName;
        this.carModel = other.carModel;
        this.rentalDays = other.rentalDays;
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    // Display rental details
    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.printf("Total Cost: %.2f\n", calculateTotalCost());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from user
        String name = sc.nextLine();
        String model = sc.nextLine();
        int days = sc.nextInt();

        // Parameterized constructor
        CarRental rental = new CarRental(name, model, days);

        // Copy constructor example
        CarRental rentalCopy = new CarRental(rental);

        // Display both rentals
        rental.displayRentalDetails();
        System.out.println();
        rentalCopy.displayRentalDetails();

        sc.close();
    }
}
