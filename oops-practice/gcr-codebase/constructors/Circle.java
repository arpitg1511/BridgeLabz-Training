import java.util.*;

public class Circle {

    // Encapsulated attribute
    private double radius;

    // Default constructor (sets default radius)
    public Circle() {
        this(0.0); // constructor chaining
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to display radius
    public double getRadius() {
    	return radius;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Using default constructor
        Circle defaultCircle = new Circle();
        System.out.printf("default circle: %.4f\n", defaultCircle.getRadius());

        // Using user-provided value
        double r = sc.nextDouble();
        Circle userCircle = new Circle(r);

        System.out.printf("Parametarised circle: %.4f\n", userCircle.getRadius());

        sc.close();
    }
}
