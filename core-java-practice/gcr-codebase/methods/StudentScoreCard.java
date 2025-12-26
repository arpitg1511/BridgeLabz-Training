import java.util.*;

public class StudentScoreCard {

    // Method to generate random 2-digit PCM marks
    public static int[][] generatePCMMarks(int students) {
        int[][] pcm = new int[students][3];

        for (int i = 0; i < students; i++) {
            pcm[i][0] = (int)(Math.random() * 90) + 10; // Physics
            pcm[i][1] = (int)(Math.random() * 90) + 10; // Chemistry
            pcm[i][2] = (int)(Math.random() * 90) + 10; // Maths
        }
        return pcm;
    }

    // Method to calculate total, average, percentage
    public static double[][] calculateResults(int[][] pcm) {
        double[][] result = new double[pcm.length][3];

        for (int i = 0; i < pcm.length; i++) {
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }

    // Method to display scorecard
    public static void displayScoreCard(int[][] pcm, double[][] result) {

        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\tPercent");

        for (int i = 0; i < pcm.length; i++) {
            System.out.println(
                (i + 1) + "\t" +
                pcm[i][0] + "\t" +
                pcm[i][1] + "\t" +
                pcm[i][2] + "\t" +
                (int)result[i][0] + "\t" +
                result[i][1] + "\t" +
                result[i][2]
            );
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int students = sc.nextInt();

        int[][] pcm = generatePCMMarks(students);
        double[][] results = calculateResults(pcm);

        displayScoreCard(pcm, results);

        sc.close();
    }
}
