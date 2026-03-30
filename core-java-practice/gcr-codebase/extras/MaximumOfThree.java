import java.util.*;

public class MaximumOfThree {

    // Function to take three integers as input
    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[3];

        System.out.print("Enter first number: ");
        numbers[0] = sc.nextInt();

        System.out.print("Enter second number: ");
        numbers[1] = sc.nextInt();

        System.out.print("Enter third number: ");
        numbers[2] = sc.nextInt();
        
        sc.close();	
        return numbers;
    }

    // Function to find maximum of three numbers
    public static int findMaximum(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = takeInput();

        int maximum = findMaximum(nums[0], nums[1], nums[2]);

        System.out.println("Maximum of the three numbers is: " + maximum);
    }
}
