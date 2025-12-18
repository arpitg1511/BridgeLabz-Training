import java.util.*;
public class PalindromeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(isPalindrome(n));
	}
	
	public static boolean isPalindrome(int x) {
        int a = x;
        int b = 0;
        while(a>0){
            int c = a % 10;
            b = b * 10 + c;
            a /= 10;
        }
        return(b == x);
    }
}
