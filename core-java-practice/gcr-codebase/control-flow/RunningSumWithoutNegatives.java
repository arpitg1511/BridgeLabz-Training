import java.util.*;
public class RunningSumWithoutNegatives {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0.0;
		double a = sc.nextDouble(); //Input first number
		while(a <= 0) { //Check for zero or negative input
			sum += a;
			a = sc.nextDouble(); // Input next number
		}
		
		System.out.println(sum);
		sc.close();
	}
}
