import java.util.*;

public class EmployeeNameUppercase {

    public static void main(String[] args) {

        List<String> employeeNames = Arrays.asList(
                "Arpit", "Rahul", "Sneha", "Neha"
        );

        employeeNames.stream()
                     .map(String::toUpperCase)
                     .forEach(System.out::println);
    }
}
