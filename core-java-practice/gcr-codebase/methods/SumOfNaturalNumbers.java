import java.util.*;
public class SumOfNaturalNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(naturalSum(n));
		sc.close();
	}
	
	public static int naturalSum(int n) {
		return ((n * (n - 1)) / 2); // Sum formula
	}
}
