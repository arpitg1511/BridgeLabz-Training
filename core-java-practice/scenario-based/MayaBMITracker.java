import java.util.*;

public class MayaBMITracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double height = sc.nextDouble(); // height in meters
        double weight = sc.nextDouble(); // weight in kg

        // Calculate BMI
        double bmi = weight / (height * height);

        // Determine BMI category
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else {
            System.out.println("Overweight");
        }

        sc.close();
    }
}
