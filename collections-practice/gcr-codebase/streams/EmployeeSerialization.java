import java.io.*;
import java.util.*;

// Employee class must implement Serializable
class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + salary;
    }
}

public class EmployeeSerialization {

    public static void main(String[] args) {

        // Sample list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 60000));
        employees.add(new Employee(103, "Carol", "Finance", 55000));

        String filename = "employees.ser";

        // ===== Serialize the list =====
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(employees);

            oos.close();
            fos.close();

            System.out.println("Employees have been serialized to " + filename);

        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // ===== Deserialize the list =====
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Employee> empFromFile = (List<Employee>) ois.readObject();

            ois.close();
            fis.close();

            System.out.println("\nEmployees retrieved from file:");
            for (Employee e : empFromFile) {
                System.out.println(e);
            }

        } catch (IOException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
