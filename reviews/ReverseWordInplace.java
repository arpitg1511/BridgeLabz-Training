import java.util.*;
public class ReverseWordInplace {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		str = str.trim();
		
		String[] strArr = str.split("\\s+");
		
		for(int i = 0; i < strArr.length; i++) {
			strArr[i] = reverse(strArr[i]);
		}
		
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < strArr.length; i++) {
			ans.append(strArr[i]);
			ans.append(' ');
		}
		
		System.out.println(ans.toString());
		
	}
	
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}
}
