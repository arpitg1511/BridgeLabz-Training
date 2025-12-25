import java.util.*;

public class StudentVotes {

    // Static method to check if a student can vote
    public static boolean canStudentVote(int age) {
        if (age < 0) { // Negative age not allowed
            return false;
        } else if (age >= 18) { // Eligible to vote
            return true;
        } else { // Not eligible
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[10]; // Array for 10 students

        for (int i = 0; i < 10; i++) {
            ages[i] = sc.nextInt(); // Take input for each student

            boolean canVote = canStudentVote(ages[i]); // Call static method directly

            // Display result
            if (canVote) {
                System.out.println("Student " + (i + 1) + " can vote");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote");
            }
        }

        sc.close();
    }
}
