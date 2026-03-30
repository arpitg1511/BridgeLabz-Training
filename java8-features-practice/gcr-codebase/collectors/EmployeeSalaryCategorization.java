import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
	String empName;
	int salary;
	String department;
	
	public Employee(String empName, int salary, String department) {
		// TODO Auto-generated constructor stub
		this.empName = empName;
		this.salary = salary;
		this.department = department;
	}
}
public class EmployeeSalaryCategorization {
	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Arpit", 12000, "IT"),
				new Employee("Nitai", 1288, "Finance"),
				new Employee("Manish", 1421, "HR"),
				new Employee("Taimut", 3200, "Finance"),
				new Employee("Ayush", 21000, "Medical"),
				new Employee("Amrit", 43000, "IT"),
				new Employee("Jitesh", 54000, "Finance"));
		
		Map<String, Integer> mp = empList.stream()
								  .collect(Collectors.groupingBy(
										  emp -> emp.department,
										  Collectors.collectingAndThen(
												  Collectors.averagingInt(e -> e.salary),
												  avg -> avg.intValue()
										)
									));
		
		mp.forEach((department, salary) -> 
					System.out.println(department + " ---> " + salary)
				  );
	}
}
