import java.io.*;
import java.util.*;

public class CsvSalarySorter {

    static class Employee {
        String id;
        String name;
        String department;
        int salary;

        Employee(String id, String name, String department, int salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                employees.add(new Employee(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3])
                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort by salary descending
        employees.sort(Comparator.comparingInt(e -> -e.salary));

        System.out.println("Top 5 Highest Paid Employees:");
        System.out.println("ID | Name | Department | Salary");

        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            Employee e = employees.get(i);
            System.out.println(
                    e.id + " | " + e.name + " | " + e.department + " | " + e.salary
            );
        }
    }
}
