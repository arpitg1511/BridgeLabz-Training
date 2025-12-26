import java.util.*;
public class AnagramCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String firstString = sc.next();
		String secondString = sc.next();
		
		if(firstString.length() != secondString.length()) {
			System.out.println("Not an anagram");
			sc.close();
			return;
		}
		
		Map<Character, Integer> mp = new HashMap<>();
		Map<Character, Integer> mp2 = new HashMap<>();
		
		for(char ch : firstString.toCharArray()) {
			mp.put(ch, mp.getOrDefault(ch, 0) + 1);
		}
		
		for(char ch : secondString.toCharArray()) {
			mp2.put(ch, mp2.getOrDefault(ch, 0) + 1);
		}
		
		for(char ch : mp.keySet()) {
			if(!mp2.containsKey(ch) || mp.get(ch) != mp2.get(ch)) {
				System.out.println("Not Anagram");
				sc.close();
				return;
			}
		}
		
		System.out.println("It is a Anagram");
		sc.close();
	}
}
