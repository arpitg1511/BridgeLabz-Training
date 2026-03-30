import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of students

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input marks
        for (int i = 0; i < n; i++) {
            int phy = sc.nextInt();
            int chem = sc.nextInt();
            int math = sc.nextInt();

            if (phy < 0 || chem < 0 || math < 0) {
                i--; // decrement index if any mark is negative
                continue;
            }

            physics[i] = phy;
            chemistry[i] = chem;
            maths[i] = math;
        }

        // Calculate percentage and grade
        for (int i = 0; i < n; i++) {
            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        // Display result
        for (int i = 0; i < n; i++) {
            System.out.println(
                physics[i] + " " +
                chemistry[i] + " " +
                maths[i] + " " +
                percentage[i] + " " +
                grade[i]
            );
        }

        sc.close();
    }
}
