import java.util.*;

public class GradeCalculatorMultiDimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of students

        int[][] marks = new int[n][3]; // 0-physics, 1-chemistry, 2-maths
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

            marks[i][0] = phy;
            marks[i][1] = chem;
            marks[i][2] = math;
        }

        // Calculate percentage and grade
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
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
                marks[i][0] + " " +
                marks[i][1] + " " +
                marks[i][2] + " " +
                percentage[i] + " " +
                grade[i]
            );
        }

        sc.close();
    }
}
