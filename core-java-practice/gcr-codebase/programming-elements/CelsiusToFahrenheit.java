import java.util.*;
public class CelsiusToFahrenheit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		double ans = (temp * 1.8) + 32;
		System.out.println(ans);
	}

}
