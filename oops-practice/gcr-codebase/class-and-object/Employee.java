import java.util.*;
public class Employee {

    // Attributes
    String name;
    int id;
    double salary;
    
    //Constructor Used
    public Employee(String name, int id, double salary) {
    	this.name = name;
    	this.id = id;
    	this.salary = salary;
    }

    // Method to display employee details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
        // Creating Employee object
        Employee emp = new Employee(sc.next(), sc.nextInt(), sc.nextDouble());


        // Displaying details
        emp.displayDetails();
        
        sc.close();
    }
}
