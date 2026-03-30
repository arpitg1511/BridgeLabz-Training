import java.util.*;
public class FactorialWhileLoop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num == 0) {
			System.out.println(1); // 0! = 1
			return;
		}
		int ans = 1;
		while(num > 1) {
			ans *= num;
			num--; //Decrementing number
		}
		
		System.out.println(ans);
		sc.close();
	}
}
