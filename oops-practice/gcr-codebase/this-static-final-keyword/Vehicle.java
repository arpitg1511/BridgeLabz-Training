import java.util.*;

public class Vehicle {

	// Common registration fee
	static double registrationFee = 100.0;

	static void updateRegistrationFee(double newFee) {
		registrationFee = newFee;
	}

	final String registrationNumber;
	String ownerName;
	String vehicleType;

	// Constructor using this
	public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
		this.registrationNumber = registrationNumber;
	}

	void displayDetails(Object obj) {
		if (!(obj instanceof Vehicle)) {
			System.out.println("Invalid Vehicle object");
			return;
		}

		System.out.println("Owner Name: " + ownerName);
		System.out.println("Vehicle Type: " + vehicleType);
		System.out.println("Registration Number: " + registrationNumber);
		System.out.println("Registration Fee: $" + registrationFee);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String ownerName = sc.nextLine();
		String vehicleType = sc.nextLine();
		String regNumber = sc.nextLine();
		double fee = sc.nextDouble();

		Vehicle v = new Vehicle(ownerName, vehicleType, regNumber);

		Vehicle.updateRegistrationFee(fee);
		v.displayDetails(v);

		sc.close();
	}
}
