import java.util.Random;

class EmployeeWage {

    // UC 2: Constants for wage calculation
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_TIME_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;

    // UC 6: Monthly constraints (maximum working days and hours)
    private static final int MAX_WORKING_DAYS = 20;
    private static final int MAX_WORKING_HOURS = 100;

    // UC 1: Employee attendance status constants
    private static final int ABSENT = 0;
    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;

    // UC 5 & UC 6: Calculate total employee wage for a month
    public void calculateMonthlyWage() {

        System.out.println("Welcome to Employee Wage Computation Program!");

        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        Random random = new Random();

        // UC 6: Loop continues until max working days or max working hours is reached
        while (totalDays < MAX_WORKING_DAYS && totalHours < MAX_WORKING_HOURS) {

            totalDays++; // UC 6: Increment working day

            // UC 1: Check employee attendance (Absent / Full-Time / Part-Time)
            int empStatus = random.nextInt(3);

            // UC 4: Determine daily working hours using switch-case logic
            int dailyHours = getWorkHours(empStatus);

            // UC 6: Ensure total working hours do not exceed maximum limit
            if (totalHours + dailyHours > MAX_WORKING_HOURS) {
                dailyHours = MAX_WORKING_HOURS - totalHours;
            }

            // UC 2: Calculate daily employee wage
            int dailyWage = dailyHours * WAGE_PER_HOUR;

            totalHours += dailyHours;
            totalWage += dailyWage;

            System.out.println(
                "Day " + totalDays +
                " | Hours: " + dailyHours +
                " | Daily Wage: " + dailyWage +
                " | Total Hours: " + totalHours
            );
        }

        // UC 5: Display total wage and working details for the month
        System.out.println("\n*** Monthly Wage Computation Complete ***");
        System.out.println("Total Working Days: " + totalDays);
        System.out.println("Total Working Hours: " + totalHours);
        System.out.println("Total Employee Wage: " + totalWage);
    }

    // UC 3 & UC 4: Method to return working hours based on employee type
    private int getWorkHours(int empStatus) {
        switch (empStatus) {
            case FULL_TIME:
                return FULL_TIME_HOUR;   // UC 3: Full-time employee
            case PART_TIME:
                return PART_TIME_HOUR;   // UC 3: Part-time employee
            default:
                return ABSENT;                // UC 1: Absent employee
        }
    }
}

// Main class to execute the program
public class EmployeeWageComputation {

    // UC 7 (implicit): Program execution using object and method call
    public static void main(String[] args) {
        EmployeeWage employee = new EmployeeWage();
        employee.calculateMonthlyWage();
    }
}
