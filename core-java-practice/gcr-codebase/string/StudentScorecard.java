import java.util.*;

class StudentScoreCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Generate random scores for students
        int[][] scores = generateScores(n);

        // Calculate total, average, and percentage
        double[][] stats = calculateStats(scores);

        // Determine grades
        String[] grades = calculateGrades(stats);

        // Display the scorecard
        displayScoreCard(scores, stats, grades);
        
        sc.close();
    }

    // Method to generate random 2-digit scores for Physics, Chemistry, Math
    static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];
        Random rand = new Random();
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + rand.nextInt(91); // 10 to 100
            }
        }
        return scores;
    }

    // Method to calculate total, average, and percentage
    static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3]; // total, average, percentage
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = average; // as total is out of 100 each, average = percentage
            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    // Method to calculate grade based on percentage
    static String[] calculateGrades(double[][] stats) {
        String[] grades = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double percent = stats[i][2];
            if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B";
            else if (percent >= 60) grades[i] = "C";
            else if (percent >= 50) grades[i] = "D";
            else if (percent >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    // Method to display the scorecard
    static void displayScoreCard(int[][] scores, double[][] stats, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                (i+1) + "\t" +
                scores[i][0] + "\t" +
                scores[i][1] + "\t\t" +
                scores[i][2] + "\t" +
                (int)stats[i][0] + "\t" +
                stats[i][1] + "\t" +
                stats[i][2] + "\t\t" +
                grades[i]
            );
        }
    }
}
