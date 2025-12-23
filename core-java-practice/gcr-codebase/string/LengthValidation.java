import java.util.*;
public class LengthValidation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int k = length(str);
		
		if(k == str.length()) { // Comparing both inbuilt and user defined method
			System.out.println("Verified");
		}
		
		System.out.println(k + " " + str.length());
		sc.close();
	}
	
	public static int length(String str) { //Method to calculate length
		int c = 0;
		
		for(char ch : str.toCharArray()) {
			c++;
		}
		
		return c;
	}
}
