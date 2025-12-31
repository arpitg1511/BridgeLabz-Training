import java.util.Scanner;

// Superclass
class Employee {
    public int employeeID;       // public: accessible everywhere
    protected String department; // protected: accessible in subclass
    private double salary;       // private: accessible only in this class

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        if(salary >= 0)
            this.salary = salary;
        else
            System.out.println("Salary cannot be negative!");
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }

    // Display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

// Subclass demonstrating access to public and protected members
class Manager extends Employee {
    private int teamSize;

    public Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    public void displayManagerDetails() {
        // Access public employeeID directly
        System.out.println("Manager ID: " + employeeID);

        // Access protected department directly
        System.out.println("Department: " + department);

        // Access private salary via getter
        System.out.println("Salary: $" + getSalary());

        System.out.println("Team Size: " + teamSize);
    }
}

public class CompanySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Employee
        System.out.println("Enter Employee ID, Department, and Salary:");
        int empID = sc.nextInt();
        sc.nextLine(); // consume newline
        String dept = sc.nextLine();
        double sal = sc.nextDouble();
        sc.nextLine(); // consume newline

        Employee emp = new Employee(empID, dept, sal);
        System.out.println("\n--- Employee Details ---");
        emp.displayEmployeeDetails();

        // Input for Manager
        System.out.println("\nEnter Manager ID, Department, Salary, and Team Size:");
        int mgrID = sc.nextInt();
        sc.nextLine(); // consume newline
        String mgrDept = sc.nextLine();
        double mgrSal = sc.nextDouble();
        int teamSize = sc.nextInt();
        sc.nextLine(); // consume newline

        Manager mgr = new Manager(mgrID, mgrDept, mgrSal, teamSize);
        System.out.println("\n--- Manager Details ---");
        mgr.displayManagerDetails();

        sc.close();
    }
}
