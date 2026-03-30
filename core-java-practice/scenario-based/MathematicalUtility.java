class Utility {

	// Method to calculate factorial of a number
	static int factorial(int n) {
		if (n < 0) return -1;           // factorial not defined for negatives
		if (n == 0 || n == 1) return 1; // base case

		return n * factorial(n - 1);   // recursive case
	}

	// Method to find GCD of two numbers
	static int gcd(int a, int b) {
		if (a < 0) a = -a; // handle negatives
		if (b < 0) b = -b;

		if (b > a) return gcd(b, a);

		if (b == 0) return a;

		return gcd(b, a % b);
	}

	// Method to check if a number is prime
	static boolean isPrime(int n) {
		if (n <= 1) return false; // 0, 1, negatives are not prime

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}

		return true;
	}

	// Method to find nth Fibonacci number
	static int nthFibonacci(int n) {
		if (n <= 0) return -1; // invalid input

		if (n == 1) return 0;
		if (n == 2) return 1;

		return nthFibonacci(n - 1) + nthFibonacci(n - 2);
	}
}

public class MathematicalUtility {

	public static void main(String[] args) {

		// Testing factorial
		System.out.println("Factorial Tests:");
		System.out.println("factorial(5) = " + Utility.factorial(5));   // 120
		System.out.println("factorial(0) = " + Utility.factorial(0));   // 1
		System.out.println("factorial(-3) = " + Utility.factorial(-3)); // -1

		System.out.println();

		// Testing prime check
		System.out.println("Prime Tests:");
		System.out.println("isPrime(7) = " + Utility.isPrime(7));   // true
		System.out.println("isPrime(1) = " + Utility.isPrime(1));   // false
		System.out.println("isPrime(0) = " + Utility.isPrime(0));   // false
		System.out.println("isPrime(-5) = " + Utility.isPrime(-5)); // false

		System.out.println();

		// Testing GCD
		System.out.println("GCD Tests:");
		System.out.println("gcd(18, 24) = " + Utility.gcd(18, 24));   // 6
		System.out.println("gcd(10, 0) = " + Utility.gcd(10, 0));    // 10
		System.out.println("gcd(-8, 12) = " + Utility.gcd(-8, 12));  // 4

		System.out.println();

		// Testing Fibonacci
		System.out.println("Fibonacci Tests:");
		System.out.println("nthFibonacci(1) = " + Utility.nthFibonacci(1)); // 0
		System.out.println("nthFibonacci(2) = " + Utility.nthFibonacci(2)); // 1
		System.out.println("nthFibonacci(6) = " + Utility.nthFibonacci(6)); // 5
		System.out.println("nthFibonacci(-2) = " + Utility.nthFibonacci(-2)); // -1
	}
}
