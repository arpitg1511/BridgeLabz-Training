import java.util.*;

public class CollinearPoints {

    // Method to check collinearity using slope formula
    public static boolean isCollinearUsingSlope(
            int x1, int y1, int x2, int y2, int x3, int y3) {

        int dy1 = y2 - y1;
        int dx1 = x2 - x1;

        int dy2 = y3 - y2;
        int dx2 = x3 - x2;

        int dy3 = y3 - y1;
        int dx3 = x3 - x1;

        // Cross multiplication to avoid division
        return (dy1 * dx2 == dy2 * dx1) &&
               (dy1 * dx3 == dy3 * dx1);
    }

    // Method to check collinearity using area of triangle formula
    public static boolean isCollinearUsingArea(
            int x1, int y1, int x2, int y2, int x3, int y3) {

        double area = 0.5 * (
                x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2)
        );

        return area == 0;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        System.out.println("Collinear using Slope Formula: " +
                isCollinearUsingSlope(x1, y1, x2, y2, x3, y3));

        System.out.println("Collinear using Area Formula: " +
                isCollinearUsingArea(x1, y1, x2, y2, x3, y3));

        sc.close();
    }
}
