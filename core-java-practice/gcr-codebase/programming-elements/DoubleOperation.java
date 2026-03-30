import java.util.*;
public class DoubleOperation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		double firstOperation = a + b * c;
		double secondOperation = a * b + c;
		double thirdOperation = c + a / b;
		double fourthOperation = a % b + c;
		
		System.out.println("The results of Int Operations are " + firstOperation + "," + secondOperation
				+ "," + thirdOperation + " and " + fourthOperation);
		sc.close();
	}
}
