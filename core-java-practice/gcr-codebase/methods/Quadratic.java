import java.util.*;

public class Quadratic {

    // Method to find roots of quadratic equation ax^2 + bx + c
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c; // Compute discriminant

        if (delta > 0) { // Two real roots
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) { // One real root
            double root = -b / (2 * a);
            return new double[]{root};
        } else { // No real roots
            return new double[]{}; // Empty array
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input coefficients
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        // Find roots
        double[] roots = findRoots(a, b, c);

        // Display roots if any
        for (double root : roots) {
            System.out.println(root);
        }

        sc.close();
    }
}
