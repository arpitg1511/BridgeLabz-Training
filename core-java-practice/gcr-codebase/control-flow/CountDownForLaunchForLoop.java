import java.util.*;
public class CountDownForLaunchForLoop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = n; i >= 1; i--) { //Initialization & decrement done
			System.out.println(i);
		}
		sc.close();
	}
}
