import java.util.*;
public class TriangleAthelete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter dimensions of all three sides in KM: ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		double perimeter = (double) a + b + c; // Calculating perimeter
		
		System.out.printf("%.2f", 5.0 / perimeter);
		sc.close();
	}
}
