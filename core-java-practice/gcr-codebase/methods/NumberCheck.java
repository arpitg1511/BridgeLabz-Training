import java.util.*;
public class NumberCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(numberCheck(n));
		sc.close();
	}
	
	public static int numberCheck(int n) {
		if(n > 0) return 1; // Positive -> 1
		if(n < 0) return -1; // Negative -> -1
		return 0; // Zero -> 0
	}
}
