import java.util.*;
public class SpringSeason {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		System.out.println(spring(month, day));
	}
	
	public static String spring(int month, int day) {
		if (
	            (month == 3 && day >= 20) ||   // From March 20 onwards
	            (month == 4) ||                // Entire April
	            (month == 5) ||                // Entire May
	            (month == 6 && day <= 20)      // Up to June 20
	        ) {
	            return "Its a Spring Season";
	      } else {
	           return "Not a Spring Season";
	       }
	}
}
