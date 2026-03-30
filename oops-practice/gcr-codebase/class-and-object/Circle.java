import java.util.*;

public class Circle {

    static final double PI = Math.PI;
    double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double areaOfCircle() {
        return PI * radius * radius;
    }

    // Method to calculate circumference
    public double circumferenceOfCircle() {
        return 2 * PI * radius;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double r = sc.nextDouble();
        Circle circle = new Circle(r);

        System.out.printf("Area of circle: %.4f\n", circle.areaOfCircle());
        System.out.printf("Circumference of circle: %.4f\n", circle.circumferenceOfCircle());

        sc.close();
    }
}
