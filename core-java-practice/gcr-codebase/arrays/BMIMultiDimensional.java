import java.util.*;

public class BMIMultiDimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt(); // number of persons

        double[][] personData = new double[number][3]; // 0->weight, 1->height, 2->BMI
        String[] weightStatus = new String[number];

        // Input weight and height (re-enter silently if negative)
        for (int i = 0; i < number; i++) {
            double weight = sc.nextDouble();
            while (weight <= 0) {
                System.out.println("Only enter positive value");
                weight = sc.nextDouble();
            }

            double height = sc.nextDouble();
            while (height <= 0) {
            	System.out.println("Only enter positive value");
                height = sc.nextDouble();
            }

            personData[i][0] = weight;
            personData[i][1] = height;
        }

        // Calculate BMI and weight status
        for (int i = 0; i < number; i++) {
            double bmi = personData[i][0] / (personData[i][1] * personData[i][1]);
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display result
        for (int i = 0; i < number; i++) {
            System.out.println(
                personData[i][1] + " " +
                personData[i][0] + " " +
                personData[i][2] + " " +
                weightStatus[i]
            );
        }

        sc.close();
    }
}
