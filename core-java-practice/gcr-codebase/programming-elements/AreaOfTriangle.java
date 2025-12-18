import java.util.*;
public class AreaOfTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double height = sc.nextDouble();
		double base = sc.nextDouble();
		System.out.println("Area of Triangle in sq. centimeteres is " + (0.5 * base * height));
		System.out.println("Area of Triangle in sq. inches is " + (0.5 * base * height * 0.155));
	}
}
