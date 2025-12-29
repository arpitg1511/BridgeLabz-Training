import java.util.*;
public class FibonacciNumberGenerator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int term = sc.nextInt(); // Input taken
		
		printFibonacci(term); // Method called
		
		sc.close();
	}
	
	public static void printFibonacci(int term) {
	    int a = 0, b = 1; // Store 1st and second term

	    for (int i = 0; i < term; i++) {
	        System.out.printf("%02d ", a);
	        int c = a + b; // Find the next term
	        a = b;
	        b = c;
	    }
	}
}
