import java.util.*;

public class Employee {

	// Static variable shared by all Employee objects
	static String companyName = "XYZ Inc.";

	// Static variable to keep track of total employees created
	static int totalEmployees = 0;
	
	// Instance variable: employee name
	String name;

	// Final variable: employee ID cannot be changed once assigned
	final int id;

	// Instance variable: employee designation
	String designation;
	
	// Constructor to initialize employee details
	// 'this' keyword resolves ambiguity between instance variables and parameters
	public Employee(String name, int id, String designation) {
		this.name = name;
		this.id = id;
		this.designation = designation;

		// Increment total employees count whenever a new object is created
		totalEmployees++;
	}
	
	// Static method to return total number of employees
	static int displayTotalEmployees() {
		return totalEmployees;
	}
	
	// Method to display employee details
	// Accepts Object type to demonstrate instanceof usage
	void displayDetails(Object obj) {

		// Runtime check to ensure object is of Employee type
		if (!(obj instanceof Employee)) {
			System.out.println("Object is not of type Employee!");
			return;
		}
		
		// Display employee details
		System.out.println("Id : " + id);
		System.out.println("Name : " + name);
		System.out.println("Designation : " + designation);
	}
	
	public static void main(String[] args) {

		// Scanner object for user input
		Scanner sc = new Scanner(System.in);
        
		// Reading employee ID
		int id = sc.nextInt();

		// Consume leftover newline after nextInt()
		sc.nextLine();

		// Reading employee name
		String name = sc.nextLine();

		// Reading employee designation
		String designation = sc.nextLine();
        
		// Creating Employee object
		Employee emp = new Employee(name, id, designation);

		// Calling static method using class name
		System.out.println("Total Employees: " + Employee.displayTotalEmployees());

		// Accessing static variable using class name
		System.out.println("Company Name: " + Employee.companyName);
        
		// Calling instance method
		emp.displayDetails(emp);

		// Closing scanner to avoid resource leak
		sc.close();
    }
}
