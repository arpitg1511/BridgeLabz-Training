import java.util.*;
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println(longestSubstring(str));
	}
	
	public static String longestSubstring(String str) {
		
		return substr(str, 0, str.length() - 1);
	}
	
	public static String substr(String str, int i, int j) {
		if(i == j) return str.charAt(i) + "";
		
		if(isPalindrome(str, i, j)) return str.substring(i, j + 1);
		
		String left = substr(str, i, j - 1);
		String right = substr(str, i + 1, j);
		
		if(left.length() >= right.length()) return left;
		
		return right;
	}
	
	public static boolean isPalindrome(String str, int i, int j) {
		
		while(i < j) {
			if(str.charAt(i) != str.charAt(j)) return false;
			i++;
			j--;
		}
		
		return true;
	}
}
