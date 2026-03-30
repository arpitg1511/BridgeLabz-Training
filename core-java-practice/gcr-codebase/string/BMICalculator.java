import java.util.*;

public class BMICalculator {

    // Method to calculate BMI and status for one person
    public static String[] calculateBMIStatus(double weight, double heightCm) {
        double heightM = heightCm / 100; // convert cm to meters
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25) status = "Normal";
        else if (bmi < 30) status = "Overweight";
        else status = "Obese";

        // return as String array with height, weight, BMI, and status
        return new String[] { String.valueOf(heightCm), String.valueOf(weight), String.format("%.2f", bmi), status };
    }

    // Method to process all persons' BMI
    public static String[][] processBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            result[i] = calculateBMIStatus(data[i][0], data[i][1]);
        }
        return result;
    }

    // Method to display the 2D String array in tabular format
    public static void displayBMI(String[][] result) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (String[] person : result) {
            for (String field : person) {
                System.out.print(field + "\t\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2]; // 10 persons, 2 columns (weight, height)

        // Take input for all 10 persons
        for (int i = 0; i < 10; i++) {
            data[i][0] = sc.nextDouble(); // weight
            data[i][1] = sc.nextDouble(); // height
        }

        String[][] result = processBMI(data); // compute BMI and status
        displayBMI(result); // display in tabular format
        sc.close();
    }
}
