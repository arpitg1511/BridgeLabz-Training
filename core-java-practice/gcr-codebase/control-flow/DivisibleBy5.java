import java.util.*;
public class DivisibleBy5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		String ans = number % 5 == 0 ? "Yes" : "No";
		System.out.println("Is the number " + number + " divisible by 5 ? " + ans);
	}
}
