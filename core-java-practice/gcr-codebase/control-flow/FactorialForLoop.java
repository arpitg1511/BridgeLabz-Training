import java.util.Scanner;
public class FactorialForLoop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num == 0) {
			System.out.println(1); // 0! = 1
			return;
		}
		int ans = 1;
		for(int i = num; i > 1; i--) {
			ans *= i;
		}
		
		System.out.println(ans);
		sc.close();
	}
}
