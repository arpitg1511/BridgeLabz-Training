import java.util.*;

public class Patient {

	// Shared among all patients
	static String hospitalName = "City Hospital";
	static int totalPatients = 0;

	final String patientID;
	String name;
	int age;
	String ailment;

	// Constructor using this
	public Patient(String patientID, String name, int age, String ailment) {
		this.patientID = patientID;
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		totalPatients++;
	}

	static int getTotalPatients() {
		return totalPatients;
	}

	void displayDetails(Object obj) {
		if (!(obj instanceof Patient)) {
			System.out.println("Invalid Patient object");
			return;
		}

		System.out.println("Patient ID: " + patientID);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Ailment: " + ailment);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Patient input
		String id = sc.nextLine();
		String name = sc.nextLine();
		int age = sc.nextInt();
		sc.nextLine();
		String ailment = sc.nextLine();


		Patient p = new Patient(id, name, age, ailment);

		System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
		System.out.println("Hospital Name: " + Patient.hospitalName);

		p.displayDetails(p);

		sc.close();
	}
}
