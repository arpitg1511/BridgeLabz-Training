import java.util.*;

public class BMICalculator {

    // Method to calculate BMI and store in the 2D array (third column)
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];     // Weight in kg
            double heightCm = data[i][1];   // Height in cm
            double heightM = heightCm / 100; // Convert to meters
            double bmi = weight / (heightM * heightM); // BMI formula
            data[i][2] = bmi; // Store BMI in third column
        }
    }

    // Method to determine BMI status
    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal weight";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3]; // 10 persons, columns: weight, height, BMI

        // Input weight and height for 10 members
        for (int i = 0; i < 10; i++) {
            data[i][0] = sc.nextDouble(); // Weight in kg
            data[i][1] = sc.nextDouble(); // Height in cm
        }

        // Calculate BMI
        calculateBMI(data);

        // Determine BMI status
        String[] status = determineBMIStatus(data);

        // Display weight, height, BMI, and status
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ": Weight = " + data[i][0] + 
                               " kg, Height = " + data[i][1] + " cm, BMI = " + data[i][2] + 
                               ", Status = " + status[i]);
        }

        sc.close();
    }
}
