import java.util.*;

// interface to handle department related operations
interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

// abstract base class for employees
abstract class Employee implements Department {

    // basic employee details
    private final int employeeId;
    private String name;
    protected double baseSalary;
    private String department;

    // constructor to initialize employee data
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // implemented differently by different employee types
    public abstract double calculateSalary();

    // common method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : " + calculateSalary());
        System.out.println("-------------------------");
    }

    // assigning department to employee
    @Override
    public void assignDepartment(String dept) {
        department = dept;
    }

    // returns department name
    @Override
    public String getDepartmentDetails() {
        return department;
    }

    // getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// full time employee class
class FullTimeEmployee extends Employee {

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    // fixed salary for full time employee
    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

// part time employee class
class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double ratePerHour;

    public PartTimeEmployee(int id, String name, int hoursWorked, double ratePerHour) {
        super(id, name, 0);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    // salary based on hours worked
    @Override
    public double calculateSalary() {
        return hoursWorked * ratePerHour;
    }
}

// main class
public class EmployeeManagementSystem {

    public static void main(String[] args) {

        // list to store different employee objects
        List<Employee> empList = new ArrayList<>();

        Employee e1 = new FullTimeEmployee(101, "Arpit", 60000);
        Employee e2 = new PartTimeEmployee(102, "Rahul", 80, 500);

        // assigning departments
        e1.assignDepartment("Engineering");
        e2.assignDepartment("Support");

        empList.add(e1);
        empList.add(e2);

        // displaying employee details using polymorphism
        for (Employee e : empList) {
            e.displayDetails();
        }
    }
}
