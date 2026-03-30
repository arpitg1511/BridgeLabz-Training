import java.util.*;
public class IsFirstNumberSmallest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int firstNumber = sc.nextInt();
		int secondNumber = sc.nextInt();
		int thirdNumber = sc.nextInt();
		String ans = firstNumber < secondNumber ? (firstNumber < thirdNumber ? "Yes" : "No") : 
			"No";
		
		System.out.println("Is the first number the smallest? " + ans);
	}
}
