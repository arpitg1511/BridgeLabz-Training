import java.util.*;

public class GCDAndLCMCalculator {

    public static void main(String[] args) {

        int[] numbers = input();

        int gcd = calculateGCD(numbers[0], numbers[1]);
        int lcm = calculateLCM(numbers[0], numbers[1], gcd);

        display(gcd, lcm);
    }

    // Method to take input
    public static int[] input() {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[2];
        System.out.print("Enter first number: ");
        arr[0] = sc.nextInt();

        System.out.print("Enter second number: ");
        arr[1] = sc.nextInt();
        
        sc.close();
        return arr;
    }

    // Method to calculate GCD using Euclidean Algorithm
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    // Method to calculate LCM using GCD
    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }

    // Method to display results
    public static void display(int gcd, int lcm) {
        System.out.println("GCD = " + gcd);
        System.out.println("LCM = " + lcm);
    }
}
