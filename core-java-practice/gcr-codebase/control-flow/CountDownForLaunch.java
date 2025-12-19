import java.util.*;
public class CountDownForLaunch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n >= 1) { //Till number greater than 1
			System.out.println(n);
			n--; //Decrementing the number
		}
		
		sc.close();
	}
}
