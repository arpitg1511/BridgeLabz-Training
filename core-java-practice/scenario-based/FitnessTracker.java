import java.util.*;

public class FitnessTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] pushUps = new int[7]; // Store push-ups for 7 days

        System.out.println("Enter push-ups done each day (0 for rest day):");

        // Input for 7 days
        for (int i = 0; i < 7; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            pushUps[i] = sc.nextInt();
        }

        int total = 0;
        int workoutDays = 0;

        // for-each loop to calculate total and average
        for (int count : pushUps) {

            // Skip rest days
            if (count == 0) {
                continue;
            }

            total += count;
            workoutDays++;
        }

        double average = workoutDays > 0 ? (double) total / workoutDays : 0;

        System.out.println("\nTotal push-ups in the week: " + total);
        System.out.println("Average push-ups per workout day: " + average);

        sc.close();
    }
}
 