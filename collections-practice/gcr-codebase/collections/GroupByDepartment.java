import java.util.*;

public class GroupByDepartment {

    static class Employee {
        String name;
        String department;

        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static Map<String, List<Employee>> groupEmployees(List<Employee> employees) {

        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee emp : employees) {

            String dept = emp.department;

            if (map.containsKey(dept)) {
                map.get(dept).add(emp);
            } else {
                List<Employee> list = new ArrayList<>();
                list.add(emp);
                map.put(dept, list);
            }
        }

        return map;
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        Map<String, List<Employee>> result = groupEmployees(employees);

        for (String dept : result.keySet()) {
            System.out.println(dept + ": " + result.get(dept));
        }
    }
}
