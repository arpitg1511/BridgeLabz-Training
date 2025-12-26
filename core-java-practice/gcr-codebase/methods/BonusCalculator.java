import java.util.*;

public class BonusCalculator {

    // Method to generate salary and years of service
    public static double[][] generateEmployeeData(int employees) {
        double[][] data = new double[employees][2];

        for (int i = 0; i < employees; i++) {
            // 5-digit salary (10000–99999)
            data[i][0] = (int)(Math.random() * 90000) + 10000;
            // years of service (1–10)
            data[i][1] = (int)(Math.random() * 10) + 1;
        }
        return data;
    }

    // Method to calculate bonus and new salary
    public static double[][] calculateBonus(double[][] data) {
        double[][] result = new double[data.length][2];

        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonus;

            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }

            result[i][0] = bonus;              // bonus
            result[i][1] = salary + bonus;     // new salary
        }
        return result;
    }

    // Method to display totals in tabular format
    public static void displaySummary(double[][] data, double[][] result) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Emp  OldSalary  Years  Bonus   NewSalary");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%3d  %9.0f  %5.0f  %6.0f  %9.0f%n",
                    (i + 1),
                    data[i][0],
                    data[i][1],
                    result[i][0],
                    result[i][1]);

            totalOldSalary += data[i][0];
            totalBonus += result[i][0];
            totalNewSalary += result[i][1];
        }

        System.out.println("---------------------------------------------");
        System.out.printf("TOTAL %9.0f        %6.0f  %9.0f%n",
                totalOldSalary, totalBonus, totalNewSalary);
    }

    // Main method
    public static void main(String[] args) {

        int employees = 10;

        double[][] employeeData = generateEmployeeData(employees);
        double[][] bonusData = calculateBonus(employeeData);

        displaySummary(employeeData, bonusData);
    }
}
