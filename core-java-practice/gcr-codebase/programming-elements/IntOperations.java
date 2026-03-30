import java.util.*;
public class IntOperations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int firstOperation = a + b * c;
		int secondOperation = a * b + c;
		int thirdOperation = c + a / b;
		int fourthOperation = a % b + c;
		
		System.out.println("The results of Int Operations are " + firstOperation + "," + secondOperation
				+ "," + thirdOperation + " and " + fourthOperation);
		sc.close();
	}
}
