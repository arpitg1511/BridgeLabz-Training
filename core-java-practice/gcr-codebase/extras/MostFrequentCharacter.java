import java.util.*;
public class MostFrequentCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		Map<Character, Integer> mp = new HashMap<>();
		int max = 0;
		char ans = '/';
		for(char ch : str.toCharArray()) {
			mp.put(ch, mp.getOrDefault(ch, 0) + 1);
			if(mp.get(ch) > max) {
				max = mp.get(ch);
				ans = ch;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
}
