import java.util.*;
public class RemoveDuplicates {
	public static void main(String[] args) {
		String str = "abababddehsfsdd";
		
		StringBuilder sb = new StringBuilder();
		
		Set<Character> set = new HashSet<>();
		
		for(char ch : str.toCharArray()) {
			if(!set.contains(ch)) sb.append(ch);
			
			set.add(ch);
		}
		
		System.out.println(sb.toString());
	}
}
