import java.util.*;
public class RunningSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0.0;
		double a = sc.nextDouble(); //Input first number
		while(a != 0) { //Check for zero input
			sum += a;
			a = sc.nextDouble(); // Input next number
		}
		
		System.out.println(sum);
		sc.close();
	}
}
