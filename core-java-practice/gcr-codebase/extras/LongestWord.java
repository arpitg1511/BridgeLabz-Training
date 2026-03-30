import java.util.*;
public class LongestWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int curr = 0;
		int ans = 0;
		
		for(char ch : str.toCharArray()) {
			if(ch != ' ') {
				curr++;
			}
			
			else {
				curr = 0;
			}
			ans = Math.max(ans, curr);
		}
		
		System.out.println(ans);
		sc.close();
	}
}
