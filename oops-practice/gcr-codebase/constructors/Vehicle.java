import java.util.*;

public class Vehicle {

    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Class variable (fixed for all vehicles)
    private static double registrationFee = 500.0;

    // Parameterized constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.printf("Registration Fee: %.2f\n", registrationFee);
    }

    // Class method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input first vehicle
        String owner1 = sc.nextLine();
        String type1 = sc.nextLine();
        Vehicle v1 = new Vehicle(owner1, type1);

        // Input second vehicle
        String owner2 = sc.nextLine();
        String type2 = sc.nextLine();
        Vehicle v2 = new Vehicle(owner2, type2);

        // Display details before fee update
        System.out.println("--- Before Registration Fee Update ---");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        // Update registration fee
        Vehicle.updateRegistrationFee(750.0);

        // Display details after fee update
        System.out.println("\n--- After Registration Fee Update ---");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        sc.close();
    }
}
