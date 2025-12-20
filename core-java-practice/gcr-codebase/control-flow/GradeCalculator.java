import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int marksPhysics = sc.nextInt();
        int marksChemistry = sc.nextInt();
        int marksMaths = sc.nextInt();

        // Calculate average percentage
        double percentage = ((marksPhysics + marksChemistry + marksMaths) / 3.0) * 100;

        if (percentage >= 80) {
            System.out.println("Grade: " + 'A');
            System.out.println("Average: " + percentage + "%");
            System.out.println("Remark: Level 4, Above agency normalised standards");
        } else if (percentage >= 70) {
            System.out.println("Grade: " + 'B');
            System.out.println("Average: " + percentage + "%");
            System.out.println("Remark: Level 3, At agency normalised standards");
        } else if (percentage >= 60) {
            System.out.println("Grade: " + 'C');
            System.out.println("Average: " + percentage + "%");
            System.out.println("Remark: Level 2, Below, but approaching agency normalised standards");
        } else if (percentage >= 50) {
            System.out.println("Grade: " + 'D');
            System.out.println("Average: " + percentage + "%");
            System.out.println("Remark: Level 1, Well below agency normalised standards");
        } else if (percentage >= 40) {
            System.out.println("Grade: " + 'E');
            System.out.println("Average: " + percentage + "%");
            System.out.println("Remark: Level 1, Too below agency normalised standards");
        } else {
            System.out.println("Grade: " + 'R');
            System.out.println("Average: " + percentage + "%");
            System.out.println("Remark: Remedial standards");
        }

        sc.close();
    }
}
