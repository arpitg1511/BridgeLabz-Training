import java.util.*;
public class PrimeNumberCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n <= 1) { // Number less than 1 is not prime
			System.out.println("Number is neither primes nor co primes");
		}
		
		else
		System.out.println("Is the number prime: " + isPrime(n));
		
		sc.close();
	}
	
	public static boolean isPrime(int n) {
		for(int i = 2; i < n; i++) { // Loop till n - 1 from 2
			
			if(n % i == 0) return false; // If factor exist return false
		}
		
		return true; // No factor exist
	}
}
