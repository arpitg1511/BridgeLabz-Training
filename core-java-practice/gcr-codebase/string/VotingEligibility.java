import java.util.*;

public class VotingEligibility {

    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(90); // ages between 10 and 99
        }
        return ages;
    }

    // Method to check voting eligibility and return 2D array
    public static String[][] checkEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    // Method to display the 2D array
    public static void displayResults(String[][] data) {
        for (String[] row : data) {
            System.out.println(row[0] + " " + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // number of students

        int[] ages = generateAges(n);  // generate random ages
        String[][] results = checkEligibility(ages);  // check eligibility
        displayResults(results);  // print results
        sc.close();
    }
}
