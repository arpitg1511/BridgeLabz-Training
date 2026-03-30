import java.util.*;

public class FriendChecker {

    // Method to find the index of the youngest friend
    public static int findYoungest(int[] ages) {
        int minIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Method to find the index of the tallest friend
    public static int findTallest(double[] heights) {
        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[3];       // Array to store ages
        double[] heights = new double[3]; // Array to store heights

        String[] names = {"Amar", "Akbar", "Anthony"};

        // Input ages
        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
        }

        // Input heights
        for (int i = 0; i < 3; i++) {
            heights[i] = sc.nextDouble();
        }

        // Find youngest
        int youngestIndex = findYoungest(ages);
        System.out.println("The youngest friend is " + names[youngestIndex]);

        // Find tallest
        int tallestIndex = findTallest(heights);
        System.out.println("The tallest friend is " + names[tallestIndex]);

        sc.close();
    }
}
