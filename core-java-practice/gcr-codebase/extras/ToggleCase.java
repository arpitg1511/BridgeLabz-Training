import java.util.*;
public class ToggleCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		StringBuilder sb = new StringBuilder();
		
		for(char ch : str.toCharArray()) {
			if(ch >= 65 && ch <= 90) ch += 32;
			else if(ch >= 97 && ch <= 122) ch -= 32;
			sb.append(ch);
		}
		
		System.out.println(sb.toString());
		sc.close();
	}
}
